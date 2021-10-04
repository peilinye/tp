package seedu.address.model.residency;

import seedu.address.model.person.Person;
import seedu.address.model.room.Room;

import java.util.Map;

/**
 * Unmodifiable view of a residency book
 */
public interface ReadOnlyResidencyBook {

    /**
     * Returns an unmodifiable view of the person to residency map.
     * This map will not contain any duplicate registrations.
     */
    Map<Person, Residency> getGuestMap();

    /**
     * Returns an unmodifiable view of the room to residency map.
     * This map will not contain any duplicate registrations.
     */
    Map<Room, Residency> getRoomMap();
}
