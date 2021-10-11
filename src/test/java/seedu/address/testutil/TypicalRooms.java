package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_ROOM_ONE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_ROOM_TWO;
import static seedu.address.logic.commands.CommandTestUtil.VALID_VACANCY_ROOM_ONE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_VACANCY_ROOM_TWO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.person.Person;
import seedu.address.model.room.Room;

public class TypicalRooms {

    public static final Person ALICE = TypicalPersons.ALICE;
    public static final Person BENSON = TypicalPersons.BENSON;
    public static final Person CARL = TypicalPersons.CARL;

    public static final Person[] GUESTS = new Person[]{ALICE, BENSON, CARL};

    public static final Room ROOM_ONE = new RoomBuilder().withNumber(VALID_NAME_ROOM_ONE)
            .withVacancy(VALID_VACANCY_ROOM_ONE).build();

    public static final Room ROOM_TWO = new RoomBuilder().withNumber(VALID_NAME_ROOM_TWO)
            .withVacancy(VALID_VACANCY_ROOM_TWO).withGuests(GUESTS).build();

    private TypicalRooms() {} // prevents instantiation

    public static List<Room> getTypicalRooms() {
        return new ArrayList<>(Arrays.asList(ROOM_ONE, ROOM_TWO));
    }
}
