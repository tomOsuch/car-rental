package pl.tomaszosuch.carrental.components.inventory.rent;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Brak samochodu o takim nr. ID")
public class RentNotFoundException extends RuntimeException {
}
