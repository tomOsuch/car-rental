package pl.tomaszosuch.carrental.components.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Brak użytkownika o takim nr. ID")
public class UserNotFoundException extends RuntimeException {
}
