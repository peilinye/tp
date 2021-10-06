package seedu.address.model.residency;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.person.Person;
import seedu.address.model.room.Room;

/**
 * Encapsulates the stay of a guest in a room.
 */
public class Residency {

    private final Room room;
    private final Set<Person> guests;

    /**
     * Constructor for Residency object.
     *
     * @param room Room object where guests stay in.
     * @param guests Set of Person objects who stayed in this room.
     */
    public Residency(Room room, Set<Person> guests) {
        requireNonNull(room);
        requireAllNonNull(guests);
        this.room = room;
        this.guests = guests;
    }

    /**
     * Returns the Room object in this Residency object.
     * @return Room object.
     */
    public Room getRoom() {
        return room;
    }

    /**
     * Returns the Set of Person objects in this Residency object.
     *
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

    @Override
    public String toString() {
        String message = String.format("Room [], Guests []", String.valueOf(room), String.valueOf(guests));
        return message;
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof Residency
                && ((Residency) other).room == this.room
                && ((Residency) other).guests == this.guests);
    }

    @Override
    public int hashCode() {
        return Objects.hash(room, guests);
    }
}
