package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.*;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalAddressBook.getTypicalAddressBook;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_ROOM;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_ROOM;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Person;
import seedu.address.model.room.Room;
import seedu.address.model.room.Vacancy;
import seedu.address.testutil.RoomBuilder;

public class CheckInCommandTest {

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute_validRoomIndexValidGuestList_success() {
        List<Index> guestList = Arrays.asList(INDEX_FIRST_PERSON, INDEX_SECOND_PERSON);
        CheckInCommand checkInCommand = new CheckInCommand(INDEX_FIRST_ROOM, guestList);

        Room roomToEdit = model.getFilteredRoomList().get(INDEX_FIRST_ROOM.getZeroBased());

        Set<Person> guests = new HashSet<>();
        guests.add(model.getFilteredPersonList().get(INDEX_FIRST_PERSON.getZeroBased()));
        guests.add(model.getFilteredPersonList().get(INDEX_SECOND_PERSON.getZeroBased()));
        Room editedRoom = new Room(roomToEdit.getRoomNumber(), Vacancy.OCCUPIED, guests);

        ModelManager expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        expectedModel.setRoom(roomToEdit, editedRoom);

        String expectedMessage = String.format(CheckInCommand.MESSAGE_CHECKIN_SUCCESS, editedRoom);

        assertCommandSuccess(checkInCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidRoomIndex_throwsCommandException() {
        Index invalidRoomIndex = Index.fromZeroBased(model.getFilteredRoomList().size());
        List<Index> guestList = Arrays.asList(INDEX_FIRST_PERSON, INDEX_SECOND_PERSON);
        CheckInCommand checkInCommand = new CheckInCommand(invalidRoomIndex, guestList);

        assertCommandFailure(checkInCommand, model, Messages.MESSAGE_INVALID_ROOM_DISPLAYED_INDEX);
    }

    @Test
    public void execute_invalidGuestIndex_throwsCommandException() {
        Index invalidGuestIndex = Index.fromZeroBased(model.getFilteredPersonList().size());
        List<Index> guestList = Arrays.asList(INDEX_FIRST_PERSON, INDEX_SECOND_PERSON, invalidGuestIndex);
        CheckInCommand checkInCommand = new CheckInCommand(INDEX_FIRST_ROOM, guestList);

        assertCommandFailure(checkInCommand, model, Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
    }

    @Test
    public void execute_occupiedRoom_throwsCommandException() {
        Person[] currentGuests = new Person[] {
                model.getFilteredPersonList().get(INDEX_FIRST_PERSON.getZeroBased())};
        Room roomToEdit = model.getFilteredRoomList().get(INDEX_FIRST_ROOM.getZeroBased());
        Room editedRoom = new RoomBuilder(roomToEdit)
                .withVacancy(Vacancy.OCCUPIED)
                .withGuests(currentGuests)
                .build();
        model.setRoom(roomToEdit, editedRoom);

        List<Index> newGuestList = Arrays.asList(INDEX_SECOND_PERSON);
        CheckInCommand checkInCommand = new CheckInCommand(INDEX_FIRST_ROOM, newGuestList);

        assertCommandFailure(checkInCommand, model, CheckInCommand.MESSAGE_ROOM_IS_OCCUPIED);
    }

    @Test
    public void execute_noGuests_throwsCommandException() {
        List<Index> guestList = Collections.emptyList();
        CheckInCommand checkInCommand = new CheckInCommand(INDEX_FIRST_ROOM, guestList);

        assertCommandFailure(checkInCommand, model, CheckInCommand.MESSAGE_NO_GUESTS);
    }

    @Test
    public void equals() {
        List<Index> guestList = Arrays.asList(INDEX_FIRST_PERSON, INDEX_SECOND_PERSON);
        CheckInCommand checkInRoomOneCommand = new CheckInCommand(INDEX_FIRST_ROOM, guestList);
        CheckInCommand checkInRoomTwoCommand = new CheckInCommand(INDEX_SECOND_ROOM, guestList);

        // same object -> returns true
        assertEquals(checkInRoomOneCommand, checkInRoomOneCommand);

        // same values -> returns true
        CheckInCommand checkInRoomOneCommandCopy = new CheckInCommand(INDEX_FIRST_ROOM, guestList);
        assertEquals(checkInRoomOneCommandCopy, checkInRoomOneCommand);

        // different types -> returns false
        assertNotEquals(checkInRoomOneCommand, 1);

        // null -> returns false
        assertNotEquals(checkInRoomOneCommand, null);

        // different CheckInCommand -> returns false
        assertNotEquals(checkInRoomTwoCommand, checkInRoomOneCommand);
    }
}
