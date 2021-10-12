package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.BENSON;
import static seedu.address.testutil.TypicalRooms.ROOM_ONE;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

import seedu.address.model.person.NRIC;
import seedu.address.model.person.Person;
import seedu.address.model.residency.Residency;
import seedu.address.model.room.Room;
import seedu.address.model.room.RoomNumber;

public class JsonAdaptedResidencyTest {

    @Test
    public void toModelType_validResidency_returnsResidency() {
        Set<Person> guests = new HashSet<>();
        guests.add(ALICE);
        guests.add(BENSON);

        Residency residency = new Residency(ROOM_ONE, guests);
        JsonAdaptedResidency jsonResidency = new JsonAdaptedResidency(residency);

        Map<NRIC, Person> idPersonMap = new HashMap<>();
        Map<RoomNumber, Room> roomNumberRoomMap = new HashMap<>();
        idPersonMap.put(ALICE.getNRIC(), ALICE);
        idPersonMap.put(BENSON.getNRIC(), BENSON);
        roomNumberRoomMap.put(ROOM_ONE.getRoomNumber(), ROOM_ONE);

        Residency test = jsonResidency.toModelType(idPersonMap, roomNumberRoomMap);
        System.out.println(test.getGuests());

        assertEquals(residency, jsonResidency.toModelType(idPersonMap, roomNumberRoomMap));
    }
}
