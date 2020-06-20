package pl.tomaszosuch.carrental.components.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Użytkownik o takim nr id już istnieje")
public class DuplicatePeselException extends RuntimeException {
}
