package seedu.address.model.room;

import java.util.ArrayList;
import java.util.List;

import seedu.address.model.person.Person;

public class Room {
    public final Integer roomNumber;
    private List<Person> guests;
    private boolean isVacant;

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

    /**
     * Constructs a Room given its roomNumber, isVacant status and list of guests.
     *
     * @param roomNumber Integer roomNumber
     * @param isVacant Boolean true if room has no guests.
     * @param guests List of guests in the room.
     */
    public Room(int roomNumber, boolean isVacant, List<Person> guests) {
        this.roomNumber = roomNumber;
        this.isVacant = isVacant;
        this.guests = guests;
    }

    public void addPerson(Person person) {
        guests.add(person);
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public boolean getIsVacant() {
        return this.isVacant;
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
