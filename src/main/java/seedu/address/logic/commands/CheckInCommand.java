package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;
import seedu.address.model.room.Room;
import seedu.address.model.room.Vacancy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Checks a group of persons into a room.
 */
public class CheckInCommand extends Command {
    public static final String COMMAND_WORD = "checkin";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Checks in people to a room "
            + "using their index numbers used in the last person listing.\n"
            + "Parameters: INDEX_ROOM (must be a positive integer) "
            + "g/ [GUEST_INDEX] (can be used multiple times)\n"
            + "Example: " + COMMAND_WORD + " 1 "
            + "g/ 43 g/ 22";

    public static final String MESSAGE_CHECKIN_SUCCESS = "Room Checked In: %1$s";
    public static final String MESSAGE_NO_GUESTS = "At least one person must be checked into the room.";

    private final Index roomIndex;
    private final List<Index> guestIndexes;

    /**
     * @param roomIndex The index of the room to be checked into
     * @param guestIndexes A list of the indexes of guests to check into the room
     */
    public CheckInCommand(Index roomIndex, List<Index> guestIndexes) {
        this.roomIndex = roomIndex;
        this.guestIndexes = guestIndexes;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Person> lastShownPersonList = model.getFilteredPersonList();
        List<Room> lastShownRoomList = model.getFilteredRoomList();

        if (roomIndex.getZeroBased() >= lastShownRoomList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_ROOM_DISPLAYED_INDEX);
        }
        for (Index guestIndex : guestIndexes) {
            if (guestIndex.getZeroBased() >= lastShownPersonList.size()) {
                throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
            }
        }

        Room roomToEdit = lastShownRoomList.get(roomIndex.getZeroBased());
        //TO-DO: Check if room is vacant first

        Vacancy isOccupied = new Vacancy("Occupied");
        Set<Person> guests = new HashSet<>();
        for (Index guestIndex : guestIndexes) {
            Person guestToAdd = lastShownPersonList.get(guestIndex.getZeroBased());
            guests.add(guestToAdd);
        }
        if (guests.isEmpty()) {
            throw new CommandException(MESSAGE_NO_GUESTS);
        }

        Room editedRoom = new Room(roomToEdit.getRoomNumber(), isOccupied, guests);

        model.setRoom(roomToEdit, editedRoom);
        model.updateFilteredRoomList(Model.PREDICATE_SHOW_ALL_ROOMS);
        return new CommandResult(String.format(MESSAGE_CHECKIN_SUCCESS, editedRoom));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof CheckInCommand)) {
            return false;
        }

        CheckInCommand e = (CheckInCommand) other;

        return roomIndex.equals(e.roomIndex)
                && guestIndexes.equals(e.guestIndexes);
    }
}
