package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.address.model.person.exceptions.InvalidNRICException;
import seedu.address.model.room.RoomNumber;

public class NRICTest {

    @Test
    public void constructor_invalidNRIC_throwsInvalidIdException() {
        //should throw an error since NRICs should not be empty strings
        assertThrows(InvalidNRICException.class, () -> NRIC.of(""));
    }

    /*
    @Test
    public void constructor_invalidSetNextId_throwsInvalidIdException() {
        //should throw an error since IDs are supposed to non-negative
        assertThrows(InvalidNRICException.class, () -> Id.setNextId(-1));
    }
    */

    @Test
    public void isValidId() {
        assertThrows(NullPointerException.class, () -> NRIC.isValidNRIC(null));
        assertTrue(NRIC.isValidNRIC("hello"));
    }

    @Test
    public void isSameId() {
        NRIC NRICOne = NRIC.of("test1");

        // nextId parameter starts at 0. calling empty .of() created a new Id based on current nextId value and
        // automatically increments nextId by 1
        NRIC NRICZero = NRIC.of("test0");
        NRIC NRICOneSame = NRIC.of("test1");

        assertFalse(NRICOne.equals(NRICZero));
        assertTrue(NRICOne.equals(NRICOneSame));
    }

    @Test
    public void sameIdTest() {
        NRIC NRICZero = NRIC.of("test0");
        NRIC NRICZeroSame = NRIC.of("test0");
        NRIC NRICOne = NRIC.of("test1");

        assertTrue(NRICZeroSame.equals(NRICZero));
        assertFalse(NRICZero.equals(NRICOne));
    }

    @Test
    public void getValueTest() {
        NRIC idZero = NRIC.of("test0");
        NRIC idZeroSame = NRIC.of("test0");
        NRIC idOne = NRIC.of("test1");

        assertTrue(idZeroSame.getValue() == idZero.getValue());
        assertFalse(idZero.getValue() == idOne.getValue());
    }

    @Test
    public void equalsTest() {
        NRIC NRICZero = NRIC.of("test0");
        NRIC NRICZeroSame = NRIC.of("test0");
        NRIC NRICOne = NRIC.of("test1");
        RoomNumber roomNumber = new RoomNumber("005");

        assertTrue(NRICZero.equals(NRICZero));
        assertTrue(NRICZeroSame.equals(NRICZero));
        assertFalse(NRICZero.equals(NRICOne));
        assertFalse(NRICZero.equals(roomNumber));
    }

    @Test
    public void hashcodeTest() {
        NRIC NRICZero = NRIC.of("test0");
        NRIC NRICZeroSame = NRIC.of("test0");
        NRIC NRICOne = NRIC.of("test1");

        assertTrue(NRICZeroSame.hashCode() == NRICZero.hashCode());
        assertFalse(NRICZero.hashCode() == NRICOne.hashCode());
    }
}
