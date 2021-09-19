package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_ROOMS;

import java.util.List;

import seedu.address.commons.core.listtype.ListType;
import seedu.address.model.Model;

/**
 * Lists all persons in the address book to the user.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_SUCCESS_GUESTS = "Listed all guests";

    public static final String MESSAGE_SUCCESS_ROOMS = "Listed all rooms";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Lists all guests or rooms based on given argument.\n"
            + "Parameters: LISTTYPE ('guests' or 'rooms')\n"
            + "Example: " + COMMAND_WORD + " guests";

    private ListType listType;

    public ListCommand(ListType listType) {
        this.listType = listType;
    }

    /**
     * Returns true if the ListCommand lists guests.
     */
    public boolean isGuests() {
        return this.listType.isGuestsType();
    }

    /**
     * Returns true if the ListCommand lists rooms.
     */
    public boolean isRooms() {
        return this.listType.isRoomsType();
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        if (this.isGuests()) {
            model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
            return new CommandResult(MESSAGE_SUCCESS_GUESTS);
        } else if (this.isRooms()){
            model.updateFilteredRoomList(PREDICATE_SHOW_ALL_ROOMS);
            return new CommandResult(MESSAGE_SUCCESS_ROOMS);
        } else {
            return new CommandResult("placeholder");
        }
    }
}
