package seedu.address.storage;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.model.person.Nric;
import seedu.address.model.person.Person;
import seedu.address.model.residency.Residency;
import seedu.address.model.room.Room;
import seedu.address.model.room.RoomNumber;

/**
 * Jackson-friendly version of {@link Residency}.
 */
class JsonAdaptedResidency {

    private final String roomNumber;
    private final String[] guestNrics;
    private final String checkInTime;
    private final String checkOutTime;

    /**
     * Constructs a {@code JsonAdaptedResidency} with the given residency details.
     */
    @JsonCreator
    public JsonAdaptedResidency(@JsonProperty("roomNumber") String roomNumber,
                                @JsonProperty("guestNRICs") String[] guestNrics,
                                @JsonProperty("checkInTime") String checkInTime,
                                @JsonProperty("checkOutTime") String checkOutTime) {
        this.roomNumber = roomNumber;
        this.guestNrics = guestNrics;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
    }

    /**
     * Converts a given {@code Residency} into this class for Jackson use.
     */
    public JsonAdaptedResidency(Residency source) {
        roomNumber = source.getRoom().getRoomNumber().value;

        List<String> nrics = source.getGuests()
                                  .stream()
                                  .map(person -> person.getNric().value)
                                  .collect(Collectors.toList());
        guestNrics = new String[nrics.size()];
        for (int i = 0; i < nrics.size(); i++) {
            guestNrics[i] = nrics.get(i);
        }

        checkInTime = source.getCheckInTime().toString();
        checkOutTime = source.getCheckOutTime().map(LocalDateTime::toString).orElseGet(() -> null);
    }

    /**
     * Converts this Jackson-friendly adapted residency object into the model's {@code Residency} object.
     */
    public Residency toModelType(Map<Nric, Person> nricPersonMap, Map<RoomNumber, Room> roomNumberRoomMap) {
        Set<Person> guests = new HashSet<>();
        for (String nric : guestNrics) {
            Nric something = Nric.of(nric);
            Person x = nricPersonMap.get(something);
            guests.add(x);
        }

        Room room = roomNumberRoomMap.get(new RoomNumber(roomNumber));

        LocalDateTime checkIn = LocalDateTime.parse(checkInTime);
        LocalDateTime checkOut = checkOutTime != null ? LocalDateTime.parse(checkOutTime) : null;

        // TODO: Check if any data constraints are violated

        return new Residency(room, guests, checkIn, checkOut);
    }
}
