package seedu.address.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Person;
import seedu.address.model.room.Room;
import seedu.address.model.room.RoomNumber;

/**
 * Jackson-friendly version of {@link Room}.
 */
class JsonAdaptedRoom {
    public final String roomNumber;
    private final List<JsonAdaptedPerson> guests = new ArrayList<>();
    private final boolean isVacant;

    /**
     * Constructs a {@code JsonAdaptedRoom} with the given room details.
     */
    @JsonCreator
    public JsonAdaptedRoom(@JsonProperty("roomNumber") String roomNumber, @JsonProperty("isVacant") boolean isVacant,
        @JsonProperty("guests") List<JsonAdaptedPerson> guests) {
        this.roomNumber = roomNumber;
        this.isVacant = isVacant;
        if (guests != null) {
            this.guests.addAll(guests);
        }
    }

    /**
     * Converts a given {@code Room} into this class for Jackson use.
     */
    public JsonAdaptedRoom(Room source) {
        roomNumber = source.getRoomNumber().value;
        isVacant = source.getIsVacant();
        guests.addAll(source.getGuests().stream()
                .map(JsonAdaptedPerson::new)
                .collect(Collectors.toList()));
    }

    /**
     * Converts this Jackson-friendly adapted room object into the model's {@code Room} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted room.
     */
    public Room toModelType() throws IllegalValueException {
        final List<Person> roomGuests = new ArrayList<>();
        for (JsonAdaptedPerson person: guests) {
            roomGuests.add(person.toModelType());
        }
        //insert validity checks and exception handling
        final RoomNumber modelRoomNumber = new RoomNumber(roomNumber);
        final Boolean modelIsVacant = isVacant;
        final List<Person> modelGuests = roomGuests;
        return new Room(modelRoomNumber, modelIsVacant, modelGuests);
    }
}
