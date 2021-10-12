package seedu.address.storage;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.model.person.NRIC;
import seedu.address.model.person.Person;
import seedu.address.model.residency.Residency;
import seedu.address.model.room.Room;
import seedu.address.model.room.RoomNumber;

/**
 * Jackson-friendly version of {@link Residency}.
 */
class JsonAdaptedResidency {

    private final String roomNumber;
    private final String[] guestNRICs;

    /**
     * Constructs a {@code JsonAdaptedResidency} with the given residency details.
     */
    @JsonCreator
    public JsonAdaptedResidency(@JsonProperty("roomNumber") String roomNumber,
                                @JsonProperty("guestNRICs") String[] guestNRICs) {
        this.roomNumber = roomNumber;
        this.guestNRICs = guestNRICs;

    }

    /**
     * Converts a given {@code Residency} into this class for Jackson use.
     */
    public JsonAdaptedResidency(Residency source) {
        roomNumber = source.getRoom().getRoomNumber().value;
        List<String> NRICs = source.getGuests()
                                  .stream()
                                  .map(person -> person.getNRIC().value)
                                  .collect(Collectors.toList());
        guestNRICs = new String[NRICs.size()];
        for (int i = 0; i < NRICs.size(); i++) {
            guestNRICs[i] = NRICs.get(i);
        }
    }

    /**
     * Converts this Jackson-friendly adapted residency object into the model's {@code Residency} object.
     */
    public Residency toModelType(Map<NRIC, Person> NRICPersonMap, Map<RoomNumber, Room> roomNumberRoomMap) {
        Set<Person> guests = new HashSet<>();
        for (String nric : guestNRICs) {
            NRIC something = NRIC.of(nric);
            Person x = NRICPersonMap.get(something);
            guests.add(x);
            //guests.add(NRICPersonMap.get(NRIC.of(nric)));
        }

        Room room = roomNumberRoomMap.get(new RoomNumber(roomNumber));

        // TODO: Check if any data constraints are violated

        return new Residency(room, guests);
    }
}
