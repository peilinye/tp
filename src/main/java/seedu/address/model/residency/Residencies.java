package seedu.address.model.residency;

import seedu.address.model.person.Person;
import seedu.address.model.room.Room;

import java.util.HashMap;
import java.util.Optional;
import java.util.Set;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

public class Residencies {

    private static final HashMap<Room, Residency> roomMap = new HashMap<>();
    private static final HashMap<Person, Residency> guestMap = new HashMap<>();

    public static void register(Room room, Set<Person> guests) {
        requireNonNull(room);
        requireAllNonNull(guests);
    }

    public static void remove(Residency residency) {
        requireNonNull(residency);
        Room room = residency.getRoom();
        Set<Person> guests = residency.getGuests();

        roomMap.remove(room);
        for (Person guest : guests) {
            guestMap.remove(guest);
        }
    }

    public static void edit(Person personToEdit, Person editedPerson) {
        requireAllNonNull(personToEdit, editedPerson);
        Optional residencyOption = getResidency(personToEdit);
        residencyOption.ifPresent(obj -> {
            Residency residency = (Residency) obj;

            Room room = residency.getRoom();
            Set<Person> guests = residency.getGuests();
            guests.remove(personToEdit);
            guests.add(editedPerson);

            remove(residency);
            register(room, guests);
        });
    }

    public static Optional<Residency> getResidency(Room room) {
        requireNonNull(room);
        return Optional.ofNullable(roomMap.get(room));
    }

    public static Optional<Residency> getResidency(Person guest) {
        requireNonNull(guest);
        return Optional.ofNullable(guestMap.get(guest));
    }

}
