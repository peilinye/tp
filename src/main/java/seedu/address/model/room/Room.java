package seedu.address.model.room;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.person.Person;

public class Room {
    private final RoomNumber roomNumber;
    private final Vacancy vacancy;
    private final Set<Person> guests = new HashSet<>();

    /**
     * Constructs a {@code Room}.
     *
     * @param roomNumber A valid room number.
     */
    public Room(RoomNumber roomNumber) {
        this.roomNumber = roomNumber;
        vacancy = Vacancy.VACANT;
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
        this.guests.addAll(guests);
    }

    public RoomNumber getRoomNumber() {
        return roomNumber;
    }

    public Vacancy getVacancy() {
        return this.vacancy;
    }

    /**
     * Returns an immutable person set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Person> getGuests() {
        return Collections.unmodifiableSet(guests);
    }

    public boolean isVacant() {
        return vacancy.isVacant();
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
                && roomNumber.equals(((Room) other).roomNumber)
                && vacancy.equals(((Room) other).vacancy)
                && guests.equals(((Room) other).guests));
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, vacancy, guests);
    }
}
