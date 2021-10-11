package seedu.address.testutil;

import static seedu.address.testutil.TypicalPersons.PERSON_LIST_ONE;
import static seedu.address.testutil.TypicalRooms.ROOM_ONE;

import seedu.address.model.residency.Residency;
import seedu.address.model.residency.ResidencyBook;

public class TypicalRecordsBook {

    public static final Residency RESIDENCY_ONE = new Residency(ROOM_ONE, PERSON_LIST_ONE);

    private TypicalRecordsBook() {};

    public static ResidencyBook getTypicalRecordsBook() {
        ResidencyBook residencies = new ResidencyBook(true);
        residencies.register(RESIDENCY_ONE);
        return residencies;
    }
}
