package seedu.address.model.residency;

import seedu.address.model.person.Person;
import seedu.address.model.room.Room;

import java.util.Collections;
import java.util.Set;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

/**
 * Encapsulates the stay of a guest in a room.
 */
public class Residency {

    private final Room room;
    private final Set<Person> guests;

    protected Residency(Room room, Set<Person> guests) {
        requireNonNull(room);
        requireAllNonNull(guests);
        this.room = room;
        this.guests = guests;
    }

    public Room getRoom() {
        return room;
    }

    /**
     * @return An unmodifiable set of guests.
     */
    public Set<Person> getGuests() {
        return Collections.unmodifiableSet(guests);
    }

    /**
     * Replaces a guest object with its updated Person object.
     *
     * @param personToEdit The Person object to replace
     * @param editedPerson The Person object to replace with
     */
    public void setGuest(Person personToEdit, Person editedPerson) {
        guests.remove(personToEdit);
        guests.add(editedPerson);
    }
}
