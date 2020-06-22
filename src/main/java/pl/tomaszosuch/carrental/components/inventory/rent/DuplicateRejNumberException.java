package pl.tomaszosuch.carrental.components.inventory.rent;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.BAD_REQUEST,
        reason = "Samochód z takim nr id już istnieje"
)
public class DuplicateRejNumberException extends RuntimeException {
}
