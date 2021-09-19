package seedu.address.model.room;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.person.Person;
import seedu.address.model.person.exceptions.DuplicatePersonException;

public class RoomList implements Iterable<Room> {

    private final ObservableList<Room> internalList = FXCollections.observableArrayList();
    private final ObservableList<Room> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(internalList);

    /**
     * Returns true if the list contains an equivalent Room as the given argument.
     */
    public boolean contains(Room toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(toCheck::equals);
    }

    /**
     * Adds a person to the list.
     * The person must not already exist in the list.
     */
    public void add(Room toAdd) {
        requireNonNull(toAdd);

        //need some exception here in the future
        /*
        if (contains(toAdd)) {
            throw new DuplicatePersonException();
        }
        */

        internalList.add(toAdd);
    }

    /**
     *
     * Removes the equivalent person from the list.
     * The person must exist in the list.
     */
    public void remove(Person toRemove) {
        requireNonNull(toRemove);

        //TODO: Error handling if room is not found
        /*
        if (!internalList.remove(toRemove)) {
            throw new PersonNotFoundException();
        }
        */
    }

    /**
     * Replaces the contents of this list with {@code rooms}.
     * {@code rooms} must not contain duplicate persons.
     */
    public void setRooms(List<Room> rooms) {
        requireAllNonNull(rooms);
//        implement the check below
//        if (!roomsAreUnique(rooms)) {
//            throw new DuplicatePersonException();
//        }

        internalList.setAll(rooms);
    }

    /**
     * Returns the backing list as an unmodifiable {@code ObservableList}.
     */
    public ObservableList<Room> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    @Override
    public Iterator<Room> iterator() {
        return internalList.iterator();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof RoomList // instanceof handles nulls
                && internalList.equals(((RoomList) other).internalList));
    }

    @Override
    public int hashCode() {
        return internalList.hashCode();
    }
}
