package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.CheckOutCommand;
import seedu.address.logic.parser.exceptions.ParseException;

public class CheckOutCommandParser implements Parser<CheckOutCommand> {

    @Override
    public CheckOutCommand parse(String args) throws ParseException {
        requireNonNull(args);
        try {
            Index roomIndex = ParserUtil.parseIndex(args);
            return new CheckOutCommand(roomIndex);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, CheckOutCommand.MESSAGE_USAGE), pe);
        }
    }
}
