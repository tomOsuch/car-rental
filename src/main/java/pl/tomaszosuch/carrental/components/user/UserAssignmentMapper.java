package pl.tomaszosuch.carrental.components.user;

import pl.tomaszosuch.carrental.components.assignment.Assignment;
import pl.tomaszosuch.carrental.components.inventory.rent.Rent;

public class UserAssignmentMapper {

    static UserAssignmentDto toDto(Assignment assignment){
        UserAssignmentDto dto = new UserAssignmentDto();
        dto.setId(assignment.getId());
        dto.setRentId(assignment.getId());
        dto.setStart(assignment.getStart());
        dto.setEnd(assignment.getEnd());
        Rent rent = assignment.getRent();
        dto.setCarBrand(rent.getCarBrand());
        dto.setCarModel(rent.getCarModel());
        dto.setRejNumber(rent.getRejNumber());
        dto.setVinNumber(rent.getVinNumber());
        dto.setSerialNumber(rent.getSerialNumber());
        return dto;
    }
}
