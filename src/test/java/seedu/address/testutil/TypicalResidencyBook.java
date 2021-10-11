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

import seedu.address.model.residency.Residency;
import seedu.address.model.residency.ResidencyBook;

public class TypicalResidencyBook {

    //TODO: implement code once ready
    public static final Residency RESIDENCY_ONE = new Residency(ROOM_ONE, PERSON_LIST_ONE);


    private TypicalResidencyBook() {}

    public static ResidencyBook getTypicalResidencyBook() {
        ResidencyBook residencies = new ResidencyBook(false);
        residencies.register(RESIDENCY_ONE);
        return residencies;
    }
}
