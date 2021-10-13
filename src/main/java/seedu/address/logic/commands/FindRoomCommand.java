package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.Messages;
import seedu.address.model.Model;
import seedu.address.model.room.RoomNumberContainsKeywordsPredicate;

/**
 * Finds and lists all rooms in address book whose room number contains any of the argument keywords.
 * Keyword matching is case insensitive.
 */
public class FindRoomCommand extends Command {
    public static final String COMMAND_WORD = "room";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds the specific room number";

    private final RoomNumberContainsKeywordsPredicate predicate;

    public FindRoomCommand(RoomNumberContainsKeywordsPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredRoomList(predicate);
        return new CommandResult(
                String.format(Messages.MESSAGE_ROOM_LISTED_OVERVIEW));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof FindRoomCommand // instanceof handles nulls
                && predicate.equals(((FindRoomCommand) other).predicate)); // state check
    }
}