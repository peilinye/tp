package seedu.address.model.person;

import org.junit.jupiter.api.Test;
import seedu.address.model.person.exceptions.InvalidIdException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

public class IdTest {

    @Test
    public void constructor_invalidId_throwsInvalidIdException() {
        //should throw an error since IDs are supposed to non-negative
        assertThrows(InvalidIdException.class, () -> Id.of(-1));
    }

    @Test
    public void constructor_invalidSetNextId_throwsInvalidIdException() {
        //should throw an error since IDs are supposed to non-negative
        assertThrows(InvalidIdException.class, () -> Id.setNextId(-1));
    }

    @Test
    public void isSameId() {
        Id idOne = Id.of(1);

        // nextId parameter starts at 0. calling empty .of() created a new Id based on current nextId value and
        // automatically increments nextId by 1
        Id idZero = Id.of();
        Id idOneSame = Id.of();

        assertFalse(idOne.equals(idZero));
        assertTrue(idOne.equals(idOneSame));
    }

    @Test
    public void setIdTest() {
        Id idOne = Id.of(1);
        Id idZero = Id.of();
        Id.setNextId(0);
        Id nextIdReset = Id.of();

        assertTrue(idZero.equals(nextIdReset));
        assertFalse(idOne.equals(nextIdReset));
    }

    @Test
    public void getIdTest() {
        Id idOne = Id.of(1);
        int afterIdOne = Id.getNextId();
        Id idZero = Id.of();

        assertTrue(afterIdOne == 0);
        assertTrue(Id.getNextId() == 1);
    }

    @Test
    public void sameIdTest() {
        Id idZero = Id.of(0);
        Id idZeroConstructor = Id.of();
        Id idOne = Id.of();

        assertTrue(idZeroConstructor.equals(idZero));
        assertFalse(idZero.equals(idOne));
    }

    @Test
    public void hashcodeTest() {
        Id idZero = Id.of(0);
        Id idZeroConstructor = Id.of();
        Id idOne = Id.of();

        assertTrue(idZeroConstructor.hashCode() == idZero.hashCode());
        assertFalse(idZero.hashCode() == idOne.hashCode());
    }
}
