package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.room.Room;

import java.util.List;

public class CheckInCommand extends Command{
    public static final String COMMAND_WORD = "checkin";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Checks in people to a room "
            + "using their index numbers used in the last person listing.\n"
            + "Parameters: INDEX_ROOM (must be a positive integer) "
            + "g/ [GUEST_INDEX]\n"
            + "Example: " + COMMAND_WORD + " 1 "
            + "g/ 43 g/ 22";

    public static final String MESSAGE_NOT_IMPLEMENTED_YET =
            "CheckIn command not implemented yet";

    private final Index roomIndex;
    private final List<Index> guestIndexes;

    public CheckInCommand(Index roomIndex, List<Index> guestIndexes) {
        this.roomIndex = roomIndex;
        this.guestIndexes = guestIndexes;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
       throw new CommandException(MESSAGE_NOT_IMPLEMENTED_YET);
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
