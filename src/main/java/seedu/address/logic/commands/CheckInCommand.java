package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

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

    @Override
    public CommandResult execute(Model model) throws CommandException {
       throw new CommandException(MESSAGE_NOT_IMPLEMENTED_YET);
    }
}
