package seedu.address.model.room;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.person.Person;

import java.util.Iterator;

import static java.util.Objects.requireNonNull;

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
