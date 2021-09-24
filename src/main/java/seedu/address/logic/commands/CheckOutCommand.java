package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.room.Room;

import java.util.List;

public class CheckOutCommand extends Command {
    public static final String COMMAND_WORD = "checkout";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Checks out all the people in a room "
            + "using their index numbers used in the last person listing.\n"
            + "Parameters: INDEX_ROOM (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_CHECKOUT_SUCCESS = "Room Checked Out: %1$s";

    private final Index roomIndex;

    public CheckOutCommand(Index roomIndex) {
        this.roomIndex = roomIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Room> lastShownRoomList = model.getFilteredRoomList();

        if (roomIndex.getZeroBased() >= lastShownRoomList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_ROOM_DISPLAYED_INDEX);
        }

        Room roomToEdit = lastShownRoomList.get(roomIndex.getZeroBased());
        //Resets room to default (vacant, no guests)
        Room editedRoom = new Room(roomToEdit.getRoomNumber());

        model.setRoom(roomToEdit, editedRoom);
        model.updateFilteredRoomList(Model.PREDICATE_SHOW_ALL_ROOMS);
        return new CommandResult(String.format(MESSAGE_CHECKOUT_SUCCESS, editedRoom));
    }
}
