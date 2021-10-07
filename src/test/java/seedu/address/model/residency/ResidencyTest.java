package seedu.address.model.residency;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPersons.PERSON_LIST_ONE;
import static seedu.address.testutil.TypicalPersons.PERSON_LIST_TWO;
import static seedu.address.testutil.TypicalRooms.ROOM_ONE;
import static seedu.address.testutil.TypicalRooms.ROOM_TWO;

import org.junit.jupiter.api.Test;

public class ResidencyTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Residency(null, null));
    }

    @Test
    public void isSameResidency() {
        Residency residencyOne = new Residency(ROOM_ONE, PERSON_LIST_ONE);
        Residency residencyOneSame = new Residency(ROOM_ONE, PERSON_LIST_ONE);
        Residency residencyTwo = new Residency(ROOM_TWO, PERSON_LIST_TWO);

        assertFalse(residencyOne.equals(residencyTwo));
        assertTrue(residencyOne.equals(residencyOneSame));
    }

    @Test
    public void toStringTest() {
        Residency residencyOne = new Residency(ROOM_ONE, PERSON_LIST_ONE);
        Residency residencyOneSame = new Residency(ROOM_ONE, PERSON_LIST_ONE);
        Residency residencyTwo = new Residency(ROOM_TWO, PERSON_LIST_TWO);

        assertFalse(residencyOne.toString().equals(residencyTwo.toString()));
        assertTrue(residencyOne.toString().equals(residencyOneSame.toString()));
    }

    @Test
    public void hashcodeTest() {
        Residency residencyOne = new Residency(ROOM_ONE, PERSON_LIST_ONE);
        Residency residencyOneSame = new Residency(ROOM_ONE, PERSON_LIST_ONE);
        Residency residencyTwo = new Residency(ROOM_TWO, PERSON_LIST_TWO);

        assertFalse(residencyOne.hashCode() == residencyTwo.hashCode());
        assertTrue(residencyOne.hashCode() == residencyOneSame.hashCode());
    }

}
