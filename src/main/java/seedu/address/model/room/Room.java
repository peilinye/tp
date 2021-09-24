package seedu.address.model.room;

import java.util.Collections;
import java.util.Set;

import seedu.address.model.person.Person;

public class Room {
    public final RoomNumber roomNumber;
    private final Vacancy vacancy;
    private final Set<Person> guests;

    /**
     * Constructs a {@code Room}.
     *
     * @param roomNumber A valid room number.
     */
    public Room(RoomNumber roomNumber) {
        this.roomNumber = roomNumber;
        vacancy = Vacancy.VACANT;
        guests = (Set<Person>) Collections.EMPTY_SET;
    }

    /**
     * Constructs a Room given its roomNumber, vacancy, status and list of guests.
     *
     * @param roomNumber RoomNumber roomNumber
     * @param vacancy Vacant if room has no guests.
     * @param guests List of guests in the room.
     */
    public Room(RoomNumber roomNumber, Vacancy vacancy, Set<Person> guests) {
        this.roomNumber = roomNumber;
        this.vacancy = vacancy;
        this.guests = guests;
    }

    public RoomNumber getRoomNumber() {
        return roomNumber;
    }

    public Vacancy getVacancy() {
        return this.vacancy;
    }

    public Set<Person> getGuests() {
        return this.guests;
    }

    /**
     * Returns true if both rooms have the same name.
     */
    public boolean isSameRoom(Room otherRoom) {
        if (otherRoom == this) {
            return true;
        }

        return otherRoom != null
                && otherRoom.getRoomNumber().equals(getRoomNumber());
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
