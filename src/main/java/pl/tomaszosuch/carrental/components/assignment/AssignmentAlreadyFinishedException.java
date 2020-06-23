package pl.tomaszosuch.carrental.components.assignment;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "To przypisanie juź zostało zakończone")
public class AssignmentAlreadyFinishedException extends RuntimeException {
}
