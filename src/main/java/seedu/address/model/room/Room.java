package seedu.address.model.room;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.person.Person;

public class Room {
    public final RoomNumber roomNumber;
    private Vacancy isVacant = Vacancy.VACANT;
    private Set<Person> guests = new HashSet<>();

    /**
     * Constructs a {@code Room}.
     *
     * @param roomNumber A valid room number.
     */
    public Room(RoomNumber roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * Constructs a Room given its roomNumber, vacancy, status and list of guests.
     *
     * @param roomNumber RoomNumber roomNumber
     * @param isVacant Vacancy true if room has no guests.
     * @param guests List of guests in the room.
     */
    public Room(RoomNumber roomNumber, Vacancy isVacant, Set<Person> guests) {
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
