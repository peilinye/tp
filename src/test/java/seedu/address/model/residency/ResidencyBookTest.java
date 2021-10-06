package seedu.address.model.residency;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.BENSON;
import static seedu.address.testutil.TypicalPersons.CARL;
import static seedu.address.testutil.TypicalRooms.ROOM_ONE;
import static seedu.address.testutil.TypicalRooms.ROOM_TWO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;

import seedu.address.model.person.Person;
import seedu.address.model.residency.exceptions.DuplicatePersonRegException;
import seedu.address.model.residency.exceptions.DuplicateRoomRegException;
import seedu.address.model.residency.exceptions.ResidencyNotFoundException;

public class ResidencyBookTest {

    private final ResidencyBook residencyBook = new ResidencyBook();

    @Test
    public void constructor() {
        assertEquals(Collections.emptyList(), residencyBook.asUnmodifiableObservableList());
    }

    @Test
    public void register_validRoomValidGuests_success() {
        Set<Person> guests = new HashSet<>();

        guests.add(ALICE);
        guests.add(BENSON);

        residencyBook.register(ROOM_ONE, guests);

        Optional<Residency> residencyRoomOne = residencyBook.getResidency(ROOM_ONE);
        Optional<Residency> residencyAlice = residencyBook.getResidency(ALICE);
        Optional<Residency> residencyBenson = residencyBook.getResidency(BENSON);

        assertTrue(residencyRoomOne.isPresent());
        assertTrue(residencyAlice.isPresent());
        assertTrue(residencyBenson.isPresent());
        assertEquals(residencyRoomOne.get(), residencyAlice.get());
        assertEquals(residencyRoomOne.get(), residencyBenson.get());

        // Check if internal list contains the residency
        assertTrue(residencyBook.asUnmodifiableObservableList().contains(residencyRoomOne.get()));
    }

    @Test
    public void register_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, ()
            -> residencyBook.register(null, new HashSet<Person>()));
        assertThrows(NullPointerException.class, ()
            -> residencyBook.register(ROOM_ONE, null));
    }

    @Test
    public void register_personAlreadyRegistered_throwsDuplicatePersonRegException() {
        Set<Person> guestsRoomOne = new HashSet<>();
        Set<Person> guestsRoomTwo = new HashSet<>();

        guestsRoomOne.add(ALICE);
        guestsRoomOne.add(BENSON);
        guestsRoomTwo.add(BENSON);
        guestsRoomTwo.add(CARL);

        residencyBook.register(ROOM_ONE, guestsRoomOne);
        assertThrows(DuplicatePersonRegException.class, ()
            -> residencyBook.register(ROOM_TWO, guestsRoomTwo));
    }

    @Test
    public void register_roomAlreadyRegistered_throwsDuplicateRoomRegException() {
        Set<Person> guestsRoomOne = new HashSet<>();
        Set<Person> guestsRoomTwo = new HashSet<>();

        guestsRoomOne.add(ALICE);
        guestsRoomOne.add(BENSON);
        guestsRoomTwo.add(CARL);

        residencyBook.register(ROOM_ONE, guestsRoomOne);
        assertThrows(DuplicateRoomRegException.class, ()
            -> residencyBook.register(ROOM_ONE, guestsRoomTwo));
    }

    @Test
    public void remove_registeredResidency_success() {
        Set<Person> guests = new HashSet<>();
        guests.add(ALICE);
        Residency residency = new Residency(ROOM_ONE, guests);

        residencyBook.register(residency);
        residencyBook.remove(residency);

        assertTrue(residencyBook.getResidency(ALICE).isEmpty());
        assertTrue(residencyBook.getResidency(ROOM_ONE).isEmpty());
        assertFalse(residencyBook.asUnmodifiableObservableList().contains(residency));
    }

    @Test
    public void remove_unregisteredResidency_throwsResidencyNotFoundException() {
        Set<Person> guests = new HashSet<>();
        guests.add(ALICE);
        Residency residency = new Residency(ROOM_ONE, guests);

        assertThrows(ResidencyNotFoundException.class, ()
            -> residencyBook.remove(residency));
    }

    @Test
    public void remove_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, ()
            -> residencyBook.remove(null));
    }

    @Test
    public void setResidencies_emptyList_success() {
        Set<Person> guests = new HashSet<>();
        guests.add(ALICE);
        Residency residency = new Residency(ROOM_ONE, guests);

        residencyBook.register(residency);
        residencyBook.setResidencies(new ArrayList<>());

        assertTrue(residencyBook.asUnmodifiableObservableList().isEmpty());
        assertTrue(residencyBook.getRoomMap().isEmpty());
        assertTrue(residencyBook.getGuestMap().isEmpty());
    }

    @Test
    public void setResidencies_populatedList_success() {
        Set<Person> guestsRoomOne = new HashSet<>();
        Set<Person> guestsRoomTwo = new HashSet<>();
        guestsRoomOne.add(ALICE);
        guestsRoomTwo.add(BENSON);

        List<Residency> residencies = new ArrayList<>();
        residencies.add(new Residency(ROOM_TWO, guestsRoomTwo));

        residencyBook.register(ROOM_ONE, guestsRoomOne);
        residencyBook.setResidencies(residencies);

        Optional<Residency> residencyRoomTwo = residencyBook.getResidency(ROOM_TWO);
        Optional<Residency> residencyBenson = residencyBook.getResidency(BENSON);

        assertTrue(residencyBook.getResidency(ROOM_ONE).isEmpty());
        assertTrue(residencyBook.getResidency(ALICE).isEmpty());
        assertTrue(residencyRoomTwo.isPresent());
        assertEquals(residencyRoomTwo, residencyBenson);
    }
}
