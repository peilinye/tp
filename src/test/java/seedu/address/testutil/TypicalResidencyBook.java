package seedu.address.testutil;


//import static seedu.address.testutil.TypicalPersons.ALICE;
//import static seedu.address.testutil.TypicalPersons.BOB;
//import static seedu.address.testutil.TypicalPersons.CHARLIE;
//import static seedu.address.testutil.TypicalPersons.DANIEL;
import static seedu.address.testutil.TypicalPersons.PERSON_LIST_ONE;
//import static seedu.address.testutil.TypicalPersons.PERSON_LIST_TWO;
import static seedu.address.testutil.TypicalRooms.ROOM_ONE;
//import static seedu.address.testutil.TypicalRooms.ROOM_TWO;
//import seedu.address.model.person.Person;

import java.util.ArrayList;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.residency.Residency;

public class TypicalResidencyBook {

    //TODO: implement code once ready
    public static final Residency RESIDENCY_ONE = new Residency(ROOM_ONE, PERSON_LIST_ONE);

    private TypicalResidencyBook() {}

    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Residency residency : getTypicalResidencyBook()) {
            ab.register(residency);
        }
        return ab;
    }

    public static List<Residency> getTypicalResidencyBook() {
        ArrayList<Residency> residencies = new ArrayList<>();
        residencies.add(RESIDENCY_ONE);
        return residencies;
    }
}
