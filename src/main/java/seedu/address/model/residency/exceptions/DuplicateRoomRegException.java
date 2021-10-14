package seedu.address.model.residency.exceptions;

public class DuplicateRoomRegException extends RuntimeException {
    public static final String message = "This room is currently occupied.";
    public DuplicateRoomRegException() {
        super(message);
    }
}
