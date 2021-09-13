package seedu.address.model.room;

import seedu.address.model.person.Person;

import java.util.ArrayList;
import java.util.List;

public class Room {
    public final Integer roomNumber;
    public List<Person> guests;
    boolean isVacant;

    /**
     * Constructs a {@code RoomNumber}.
     *
     * @param roomNumber A valid room number.
     */
    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        guests = new ArrayList<Person>();
        this.isVacant = false;
    }

    public void addPerson(Person person) {
        guests.add(person);
    }

    public List<Person> getGuests() {
        return this.guests;
    }

    @Override
    public String toString() {
        return roomNumber.toString();
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof Room
                && roomNumber.equals(((Room) other).roomNumber));
    }

    @Override
    public int hashCode() {
        return roomNumber.hashCode();
    }
}
