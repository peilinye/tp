package seedu.address.model.room;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.person.Person;
import seedu.address.model.tag.Tag;

public class Room {
    private final RoomNumber roomNumber;
    private final Vacancy vacancy;
    private final Set<Person> guests = new HashSet<>();
    private final Set<Tag> tags = new HashSet<>();

    /**
     * Constructs a {@code Room}.
     *
     * @param roomNumber A valid room number.
     */
    public Room(RoomNumber roomNumber, Set<Tag> tags) {
        this.roomNumber = roomNumber;
        vacancy = Vacancy.VACANT;
        this.tags.addAll(tags);
    }

    /**
     * Constructs a Room given its roomNumber, vacancy, status and list of guests.
     *
     * @param roomNumber RoomNumber roomNumber
     * @param vacancy Vacant if room has no guests.
     * @param guests List of guests in the room.
     */
    public Room(RoomNumber roomNumber, Vacancy vacancy, Set<Person> guests, Set<Tag> tags) {
        requireAllNonNull(roomNumber, vacancy, tags);
        this.roomNumber = roomNumber;
        this.vacancy = vacancy;
        this.guests.addAll(guests);
        this.tags.addAll(tags);
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

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    public boolean isVacant() {
        return vacancy.isVacant();
    }

    /**
     * Returns true if both rooms have the same {@code RoomNumber}.
     */
    public boolean isSameRoom(Room otherRoom) {
        if (otherRoom == this) {
            return true;
        }

        return otherRoom != null
                && otherRoom.getRoomNumber().equals(getRoomNumber());
    }

    /**
     * Finds a guest to replace his/her details with updated information.
     * @param oldGuest the guest in the current guests
     * @param editedGuest the guest with the updated information
     * @return Room that contained the edited guests
     */
    public Room replaceGuest(Person oldGuest, Person editedGuest) {
        Set<Person> editedGuests = guests;

        if (editedGuests.contains(oldGuest)) {
            editedGuests.remove(oldGuest);
            editedGuests.add(editedGuest);
        }

        return new Room(roomNumber, vacancy, editedGuests, tags);
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
                && guests.equals(((Room) other).guests)
                && tags.equals(((Room) other).tags));
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, vacancy, guests);
    }
}
