package pl.tomaszosuch.carrental.components.inventory.rent;

import org.springframework.stereotype.Service;
import pl.tomaszosuch.carrental.components.inventory.category.Category;
import pl.tomaszosuch.carrental.components.inventory.category.CategoryRepository;

import java.util.Optional;

@Service
public class RentMapper {

    private CategoryRepository categoryRepository;

    public RentMapper(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    RentDto toDto(Rent rent){
        RentDto dto = new RentDto();
        dto.setId(rent.getId());
        dto.setCarBrand(rent.getCarBrand());
        dto.setCarModel(rent.getCarModel());
        dto.setRejNumber(rent.getRejNumber());
        dto.setVinNumber(rent.getVinNumber());
        dto.setSerialNumber(rent.getSerialNumber());
        if (rent.getCategory() != null)
            dto.setCategory(rent.getCategory().getName());
        return dto;
    }

    Rent toEntity(RentDto rent){
        Rent entity = new Rent();
        entity.setId(rent.getId());
        entity.setCarBrand(rent.getCarBrand());
        entity.setCarModel(rent.getCarModel());
        entity.setRejNumber(rent.getRejNumber());
        entity.setVinNumber(rent.getVinNumber());
        entity.setSerialNumber(rent.getSerialNumber());
        Optional<Category> category = categoryRepository.findByName(rent.getCategory());
        category.ifPresent(entity::setCategory);
        entity.setSerialNumber(rent.getSerialNumber());
        return entity;
    }
}
