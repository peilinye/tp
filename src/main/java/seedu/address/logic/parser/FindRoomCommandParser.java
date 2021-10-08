package seedu.address.logic.parser;

import java.util.Arrays;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.FindRoomCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.room.RoomNumberContainsKeywordsPredicate;

/**
 * Parses input arguments and creates a new FindRoomCommand object.
 */
public class FindRoomCommandParser implements Parser<FindRoomCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the FindRoomCommand
     * returns a FindRoomCommand object for execution.
     *
     * @param args takes in a String args in the context of the FindRoomCommand
     * @return returns a FindRoomCommand object for execution
     * @throws ParseException if the user input does not conform the expected format
     */
    public FindRoomCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(String.format(Messages.MESSAGE_INVALID_COMMAND_FORMAT,
                    FindRoomCommand.MESSAGE_USAGE));
        }

        String[] roomNumberKeywords = trimmedArgs.split("\\s+");

        return new FindRoomCommand(new RoomNumberContainsKeywordsPredicate(Arrays.asList(roomNumberKeywords)));
    }
}
