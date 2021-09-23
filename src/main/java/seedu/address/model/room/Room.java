package seedu.address.model.room;

import java.util.ArrayList;
import java.util.List;

import seedu.address.model.person.Person;

public class Room {
    public final RoomNumber roomNumber;
    private Vacancy isVacant;
    private List<Person> guests;

    /**
     * Constructs a {@code Room}.
     *
     * @param roomNumber A valid room number.
     */
    public Room(RoomNumber roomNumber) {
        this.roomNumber = roomNumber;
        guests = new ArrayList<Person>();
        this.isVacant = new Vacancy("Vacant");
    }

    /**
     * Constructs a Room given its roomNumber, vacancy, status and list of guests.
     *
     * @param roomNumber RoomNumber roomNumber
     * @param isVacant Vacancy true if room has no guests.
     * @param guests List of guests in the room.
     */
    public Room(RoomNumber roomNumber, Vacancy isVacant, List<Person> guests) {
        this.roomNumber = roomNumber;
        this.isVacant = isVacant;
        this.guests = guests;
    }

    public void addPerson(Person person) {
        guests.add(person);
    }

    public RoomNumber getRoomNumber() {
        return roomNumber;
    }

    public Vacancy getIsVacant() {
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
