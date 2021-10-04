package seedu.address.model.residency;

import seedu.address.model.person.Person;
import seedu.address.model.room.Room;

import java.util.Set;

public class Residency {

    private Room room;
    private Set<Person> guests;

    protected Residency(Room room, Set<Person> guests) {
        this.room = room;
        this.guests = guests;
    }

    public Room getRoom() {
        return room;
    }

    public Set<Person> getGuests() {
        return guests;
    }
}
