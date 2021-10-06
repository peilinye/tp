package seedu.address.storage;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.model.person.Id;
import seedu.address.model.person.Person;
import seedu.address.model.residency.Residency;
import seedu.address.model.room.Room;
import seedu.address.model.room.RoomNumber;

/**
 * Jackson-friendly version of {@link Residency}.
 */
class JsonAdaptedResidency {

    private final String roomNumber;
    private final int[] guestIds;

    /**
     * Constructs a {@code JsonAdaptedResidency} with the given residency details.
     */
    @JsonCreator
    public JsonAdaptedResidency(@JsonProperty("roomNumber") String roomNumber,
                                @JsonProperty("guestIds") int[] guestIds) {
        this.roomNumber = roomNumber;
        this.guestIds = guestIds;

    }

    /**
     * Converts a given {@code Residency} into this class for Jackson use.
     */
    public JsonAdaptedResidency(Residency source) {
        roomNumber = source.getRoom().getRoomNumber().value;
        List<Integer> ids = source.getGuests()
                                  .stream()
                                  .map(person -> person.getId().value)
                                  .collect(Collectors.toList());
        guestIds = new int[ids.size()];
        for (int i = 0; i < ids.size(); i++) {
            guestIds[i] = ids.get(i);
        }
    }

    /**
     * Converts this Jackson-friendly adapted residency object into the model's {@code Residency} object.
     */
    public Residency toModelType(Map<Id, Person> idPersonMap, Map<RoomNumber, Room> roomNumberRoomMap) {
        Set<Person> guests = new HashSet<>();
        for (int guestId : guestIds) {
            guests.add(idPersonMap.get(Id.of(guestId)));
        }

        Room room = roomNumberRoomMap.get(new RoomNumber(roomNumber));

        // TODO: Check if any data constraints are violated

        return new Residency(room, guests);
    }
}
