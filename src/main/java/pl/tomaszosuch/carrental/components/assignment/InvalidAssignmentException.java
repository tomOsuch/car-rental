package pl.tomaszosuch.carrental.components.assignment;

public class InvalidAssignmentException extends RuntimeException {
    public InvalidAssignmentException(String message){
        super(message);
    }
}
