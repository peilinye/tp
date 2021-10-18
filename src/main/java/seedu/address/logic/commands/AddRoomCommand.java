package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import java.util.HashSet;
import java.util.Set;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.room.Room;
import seedu.address.model.room.RoomNumber;
import seedu.address.model.tag.Tag;

public class AddRoomCommand extends Command {

    public static final String COMMAND_WORD = "addroom";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Adds the specified number of rooms with the specified type. "
            + "Maximum number of rooms allowed is 999.\n"
            + "Parameters: NUMBER_OF_ROOMS (must be a positive integer) "
            + PREFIX_TAG + "TAG\n"
            + "Example: " + COMMAND_WORD + " 50 "
            + PREFIX_TAG + "normal";

    public static final String MESSAGE_SUCCESS = "%1$s new rooms of type %2$s added.";
    public static final String MESSAGE_EXCEEDED_MAX_NUMBER_OF_ROOMS =
            "Adding %1$s rooms exceeds maximum 999 rooms allowed.";

    private final int number;
    private final Set<Tag> tags = new HashSet<>();

    /**
     * Creates an AddRoomCommand to add the specified number of {@code Rooms} with the specified {@code Tags}
     */
    public AddRoomCommand(int number, Set<Tag> tags) {
        requireAllNonNull(number, tags);
        this.number = number;
        this.tags.addAll(tags);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        int numRooms = model.getFilteredRoomList().size();
        if (this.number + numRooms > 999) {
            throw new CommandException(MESSAGE_EXCEEDED_MAX_NUMBER_OF_ROOMS);
        }

        for (int i = 1; i <= number; i++) {
            int newNum = numRooms + i;
            String roomNumber = String.format("%03d", newNum);
            Room room = new Room(new RoomNumber(roomNumber), tags);
            model.addRoom(room);
        }

        return new CommandResult(String.format(MESSAGE_SUCCESS, number, tags.toString()));
    }

}
