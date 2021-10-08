package seedu.address.logic.parser;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.FindRoomCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.room.RoomNumberContainsKeywordsPredicate;

import java.util.Arrays;

public class FindRoomCommandParser implements Parser<FindRoomCommand> {

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
