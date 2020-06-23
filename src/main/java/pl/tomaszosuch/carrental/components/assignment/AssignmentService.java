package pl.tomaszosuch.carrental.components.assignment;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.tomaszosuch.carrental.components.inventory.rent.Rent;
import pl.tomaszosuch.carrental.components.inventory.rent.RentRepository;
import pl.tomaszosuch.carrental.components.user.User;
import pl.tomaszosuch.carrental.components.user.UserRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AssignmentService {

    private AssignmentRepository assignmentRepository;
    private RentRepository rentRepository;
    private UserRepository userRepository;

    public AssignmentService(AssignmentRepository assignmentRepository, RentRepository rentRepository, UserRepository userRepository) {
        this.assignmentRepository = assignmentRepository;
        this.rentRepository = rentRepository;
        this.userRepository = userRepository;
    }

    AssignmentDto createAssignment(AssignmentDto assignmentDto){
        Optional<Assignment> activeAssignmentForRent = assignmentRepository.findByRent_IdAndEndIsNull(assignmentDto.getRentId());
        activeAssignmentForRent.ifPresent(a ->{
            throw new InvalidAssignmentException("Ten samochód jest aktualnie do kogoś przypisany");
        });
        Optional<User> user = userRepository.findById(assignmentDto.getUserId());
        Optional<Rent> rent = rentRepository.findById(assignmentDto.getRentId());
        Assignment assignment = new Assignment();
        Long userId = assignmentDto.getUserId();
        Long rentId = assignmentDto.getRentId();
        assignment.setUser(user.orElseThrow(() ->
                new InvalidAssignmentException("Brak użytkownika z id: " + userId)));
        assignment.setRent(rent.orElseThrow(() ->
                new InvalidAssignmentException("Brak pojazdu z id: " + rentId)));
        assignment.setStart(LocalDateTime.now());
        return AssignmentMapper.toDto(assignmentRepository.save(assignment));
    }

    @Transactional
    public  LocalDateTime finishAssignment(Long assignmentId){
        Optional<Assignment> assignment = assignmentRepository.findById(assignmentId);
        Assignment assignmentEntity = assignment.orElseThrow(AssignmentNotFoundException::new);
        if (assignmentEntity.getEnd() !=null)
            throw new AssignmentAlreadyFinishedException();
        else
            assignmentEntity.setEnd(LocalDateTime.now());
        return assignmentEntity.getEnd();
    }
}
