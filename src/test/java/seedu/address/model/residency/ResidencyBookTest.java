package seedu.address.model.residency;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.Collections;

public class ResidencyBookTest {

    private final ResidencyBook residencyBook = new ResidencyBook();

    @Test
    public void constructor() {
        assertEquals(Collections.emptyList(), residencyBook.asUnmodifiableObservableList());
    }
}
