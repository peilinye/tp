package seedu.address.model.room;

import java.util.function.Predicate;

/**
 * Tests that a {@code Person}'s {@code Name} matches any of the keywords given.
 */
public class RoomIsOccupiedPredicate implements Predicate<Room> {

    @Override
    public boolean test(Room room) {
        return room.getVacancy().equals(Vacancy.OCCUPIED);
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof RoomIsOccupiedPredicate);
    }
}
