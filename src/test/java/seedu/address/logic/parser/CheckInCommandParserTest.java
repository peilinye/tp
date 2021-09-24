package seedu.address.logic.parser;

import org.junit.jupiter.api.Test;
import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.CheckInCommand;

import java.util.Arrays;
import java.util.List;

import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.*;

public class CheckInCommandParserTest {

    private CheckInCommandParser parser = new CheckInCommandParser();

    @Test
    public void parse_singleGuest_returnsCheckInCommand() {
        String userInput = INDEX_FIRST_ROOM.getOneBased()
                + " g/"
                + INDEX_FIRST_PERSON.getOneBased();
        List<Index> guestIndexes = Arrays.asList(INDEX_FIRST_PERSON);
        CheckInCommand checkInCommand = new CheckInCommand(INDEX_FIRST_ROOM, guestIndexes);

        assertParseSuccess(parser, userInput, checkInCommand);
    }

    @Test
    public void parse_multipleGuests_returnsCheckInCommand() {
        String userInput = INDEX_FIRST_ROOM.getOneBased()
                + " g/"
                + INDEX_FIRST_PERSON.getOneBased()
                + " g/"
                + INDEX_SECOND_PERSON.getOneBased()
                + " g/"
                + INDEX_THIRD_PERSON.getOneBased();
        List<Index> guestIndexes = Arrays.asList(
                INDEX_FIRST_PERSON,
                INDEX_SECOND_PERSON,
                INDEX_THIRD_PERSON);
        CheckInCommand checkInCommand = new CheckInCommand(INDEX_FIRST_ROOM, guestIndexes);

        assertParseSuccess(parser, userInput, checkInCommand);
    }

    @Test
    public void parse_invalidPreamble_throwsParseException() {
        String userInput = "a g/"
                + INDEX_FIRST_PERSON.getOneBased();

        assertParseFailure(parser, userInput, String.format(Messages.MESSAGE_INVALID_COMMAND_FORMAT, CheckInCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_invalidGuestIndex_throwsParseException() {
        String userInput = INDEX_FIRST_ROOM.getOneBased()
                + " g/ a";

        assertParseFailure(parser, userInput, String.format(Messages.MESSAGE_INVALID_COMMAND_FORMAT, CheckInCommand.MESSAGE_USAGE));
    }

}
