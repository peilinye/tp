package seedu.address.logic.parser;

import org.junit.jupiter.api.Test;
import seedu.address.logic.commands.FindRoomCommand;
import seedu.address.model.room.RoomNumberContainsKeywordsPredicate;

import java.util.Arrays;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

public class FindRoomCommandParserTest {

    private FindRoomCommandParser parser = new FindRoomCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ", String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindRoomCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsFindCommand() {
        // no leading and trailing whitespaces
        FindRoomCommand expectedFindCommand =
                new FindRoomCommand(new RoomNumberContainsKeywordsPredicate(Arrays.asList("001", "002")));
        assertParseSuccess(parser, "001 002", expectedFindCommand);

        // multiple whitespaces between keywords
        assertParseSuccess(parser, " \n 001 \n \t 002  \t", expectedFindCommand);
    }

}
