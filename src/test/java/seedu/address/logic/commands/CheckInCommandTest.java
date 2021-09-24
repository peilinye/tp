package seedu.address.logic.commands;

import org.junit.jupiter.api.Test;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Person;
import seedu.address.model.room.Room;
import seedu.address.model.room.Vacancy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_ROOM;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_ROOM;
import static seedu.address.testutil.TypicalAddressBook.getTypicalAddressBook;

public class CheckInCommandTest {

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute_validRoomIndexValidGuestList_success() {
        List guestList = Arrays.asList(INDEX_FIRST_PERSON, INDEX_SECOND_PERSON);
        CheckInCommand checkInRoomOneCommand = new CheckInCommand(INDEX_FIRST_ROOM, guestList);

        Room roomToEdit = model.getFilteredRoomList().get(INDEX_FIRST_ROOM.getZeroBased());

        Vacancy isOccupied = new Vacancy("Occupied");
        Set<Person> guests = new HashSet<>();
        guests.add(model.getFilteredPersonList().get(INDEX_FIRST_PERSON.getZeroBased()));
        guests.add(model.getFilteredPersonList().get(INDEX_SECOND_PERSON.getZeroBased()));
        Room editedRoom = new Room(roomToEdit.getRoomNumber(), isOccupied, guests);

        ModelManager expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        expectedModel.setRoom(roomToEdit, editedRoom);

        String expectedMessage = String.format(CheckInCommand.MESSAGE_CHECKIN_SUCCESS, editedRoom);

        assertCommandSuccess(checkInRoomOneCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void equals() {
        List guestList = Arrays.asList(INDEX_FIRST_PERSON, INDEX_SECOND_PERSON);
        CheckInCommand checkInRoomOneCommand = new CheckInCommand(INDEX_FIRST_ROOM, guestList);
        CheckInCommand checkInRoomTwoCommand = new CheckInCommand(INDEX_SECOND_ROOM, guestList);

        // same object -> returns true
        assertTrue(checkInRoomOneCommand.equals(checkInRoomOneCommand));

        // same values -> returns true
        CheckInCommand checkInRoomOneCommandCopy = new CheckInCommand(INDEX_FIRST_ROOM, guestList);
        assertTrue(checkInRoomOneCommand.equals(checkInRoomOneCommandCopy));

        // different types -> returns false
        assertFalse(checkInRoomOneCommand.equals(1));

        // null -> returns false
        assertFalse(checkInRoomOneCommand.equals(null));

        // different CheckInCommand -> returns false
        assertFalse(checkInRoomOneCommand.equals(checkInRoomTwoCommand));
    }
}
