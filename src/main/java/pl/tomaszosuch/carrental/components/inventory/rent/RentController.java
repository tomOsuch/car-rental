package pl.tomaszosuch.carrental.components.inventory.rent;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/rents")
public class RentController {

    private RentService rentService;

    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @GetMapping("")
    public List<RentDto> findAll(@RequestParam(required = false) String text){
        if (text != null)
            return rentService.findByRejNumberOrVinNumber(text);
        else
            return rentService.findAll();
    }

    @PostMapping("")
    public ResponseEntity<RentDto> save(@RequestBody RentDto rent){
        if (rent.getId() != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Zapisywany obiekt nie może mieć ustawionego id");
        RentDto saveRent = rentService.save(rent);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saveRent.getId())
                .toUri();
        return ResponseEntity.created(location).body(saveRent);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentDto> findById(@PathVariable Long id){
        return rentService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RentDto> update(@PathVariable Long id, @RequestBody RentDto rent){
        if (!id.equals(rent.getId()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Aktualizowany obiekt powinien mieć id zgodne z id ścieżki zasobu");
        RentDto updateRent = rentService.update(rent);
        return  ResponseEntity.ok(updateRent);
    }

    @GetMapping("/{id}/assignments")
    public List<RentAssignmentDto> getRentAssignments(@PathVariable Long id){
        return  rentService.getRentAssignment(id);
    }

}
