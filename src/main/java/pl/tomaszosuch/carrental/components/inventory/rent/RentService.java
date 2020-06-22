package pl.tomaszosuch.carrental.components.inventory.rent;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RentService {

    private RentRepository rentRepository;
    private RentMapper rentMapper;

    public RentService(RentRepository rentRepository, RentMapper rentMapper) {
        this.rentRepository = rentRepository;
        this.rentMapper = rentMapper;
    }

    List<RentDto> findAll(){
        return rentRepository.findAll()
                .stream().map(rentMapper::toDto)
                .collect(Collectors.toList());
    }

    List<RentDto> findByRejNumberOrVinNumber(String text) {
        return rentRepository.findByRejNumberOrVinNumber(text)
                .stream()
                .map(rentMapper::toDto)
                .collect(Collectors.toList());
    }

    Optional<RentDto> findById(Long id){
        return rentRepository.findById(id).map(rentMapper::toDto);
    }

    RentDto save(RentDto rent){
        Optional<Rent> rentByRejNumber = rentRepository.findByRejNumber(rent.getRejNumber());
        rentByRejNumber.ifPresent(a -> {
            throw new DuplicateRejNumberException();
        });
        return mapAndSave(rent);
    }

    RentDto update(RentDto rent){
        Optional<Rent> rentByRejNumber = rentRepository.findByRejNumber(rent.getRejNumber());
        rentByRejNumber.ifPresent(a -> {
            if (!a.getId().equals(rent.getId()))
                throw new DuplicateRejNumberException();
        });
        return mapAndSave(rent);
    }

    private RentDto mapAndSave(RentDto rent){
        Rent rentEntity = rentMapper.toEntity(rent);
        Rent savedRent = rentRepository.save(rentEntity);
        return rentMapper.toDto(savedRent);
    }
}
