package pl.tomaszosuch.carrental.components.assignment;

import pl.tomaszosuch.carrental.components.inventory.rent.Rent;
import pl.tomaszosuch.carrental.components.user.User;

public class AssignmentMapper {

    static AssignmentDto toDto(Assignment assignment){
        AssignmentDto dto = new AssignmentDto();
        User user = assignment.getUser();
        dto.setId(assignment.getId());
        dto.setStart(assignment.getStart());
        dto.setEnd(assignment.getEnd());
        dto.setUserId(user.getId());
        Rent rent = assignment.getRent();
        dto.setRentId(rent.getId());
        return dto;
    }
}
