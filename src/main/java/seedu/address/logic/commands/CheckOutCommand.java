package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

public class CheckOutCommand extends Command {
    public static final String COMMAND_WORD = "checkout";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Checks out all the people in a room "
            + "using their index numbers used in the last person listing.\n"
            + "Parameters: INDEX_ROOM (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_NOT_IMPLEMENTED_YET =
            "CheckOut command not implemented yet";

    @Override
    public CommandResult execute(Model model) throws CommandException {
        throw new CommandException(MESSAGE_NOT_IMPLEMENTED_YET);
    }
}
