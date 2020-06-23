package pl.tomaszosuch.carrental.components.inventory.rent;

import pl.tomaszosuch.carrental.components.assignment.Assignment;
import pl.tomaszosuch.carrental.components.user.User;

public class RentAssignmentMapper {

    static RentAssignmentDto toDto(Assignment assignment){
        RentAssignmentDto dto = new RentAssignmentDto();
        dto.setId(assignment.getId());
        dto.setStart(assignment.getStart());
        dto.setEnd(assignment.getEnd());

        User user = assignment.getUser();
        dto.setUserId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setPesel(user.getPesel());
        return dto;
    }
}
