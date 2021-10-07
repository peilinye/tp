package seedu.address.model.residency.exceptions;

public class DuplicateRoomRegException extends RuntimeException {
    public DuplicateRoomRegException() {
        super("This room is currently occupied.");
    }
}
