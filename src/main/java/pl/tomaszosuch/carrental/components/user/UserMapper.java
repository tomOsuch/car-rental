package pl.tomaszosuch.carrental.components.user;

public class UserMapper {

    static UserDto toDto(User user){
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setBirthDate(user.getBirthDate());
        dto.setPesel(user.getPesel());
        dto.setPhoneNumber(user.getPhoneNumber());
        dto.setEmail(user.getEmail());
        dto.setAddress(user.getAddress());
        dto.setZipCode(user.getZipCode());
        dto.setCity(user.getCity());
        return dto;
    }

    static User toEntity(UserDto user){
        User entity = new User();
        entity.setId(user.getId());
        entity.setFirstName(user.getFirstName());
        entity.setLastName(user.getLastName());
        entity.setBirthDate(user.getBirthDate());
        entity.setPesel(user.getPesel());
        entity.setPhoneNumber(user.getPhoneNumber());
        entity.setEmail(user.getEmail());
        entity.setAddress(user.getAddress());
        entity.setZipCode(user.getZipCode());
        entity.setCity(user.getCity());
        return entity;
    }
}
