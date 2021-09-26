package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_ROOMS;

import java.util.function.Predicate;

import seedu.address.commons.core.listtype.ListType;
import seedu.address.model.Model;
import seedu.address.model.room.Room;

/**
 * Lists all persons in the address book to the user.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_SUCCESS_GUESTS = "Listed all guests";

    public static final String MESSAGE_SUCCESS_ROOMS = "Listed all rooms";

    public static final String MESSAGE_SUCCESS_ROOMS_TYPE = "Listed all rooms of indicated type";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Lists all guests or rooms based on given argument.\n"
            + "Parameters: LISTTYPE ('guests' or 'rooms')\n"
            + "Example: " + COMMAND_WORD + " guests";

    private ListType listType;

    private Predicate<Room> predicate;

    public ListCommand(ListType listType) {
        this.listType = listType;
    }

    /**
     * Constructs a ListCommand object with the ListType and predicate.
     *
     * @param listType The type to be listed.
     * @param predicate The predicate to filter the objects to be listed by.
     */
    public ListCommand(ListType listType, Predicate<Room> predicate) {
        this.listType = listType;
        this.predicate = predicate;
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
        } else if (this.isRooms()) {
            if (this.predicate == null) {
                model.updateFilteredRoomList(PREDICATE_SHOW_ALL_ROOMS);
                return new CommandResult(MESSAGE_SUCCESS_ROOMS);
            } else {
                model.updateFilteredRoomList(predicate);
                return new CommandResult(MESSAGE_SUCCESS_ROOMS_TYPE);
            }
        } else {
            return new CommandResult("placeholder");
        }
    }
}
