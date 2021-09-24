package seedu.address.testutil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import seedu.address.model.person.Person;
import seedu.address.model.room.Room;
import seedu.address.model.room.RoomNumber;
import seedu.address.model.room.Vacancy;

public class RoomBuilder {

    public static final String DEFAULT_ROOM_NUMBER = "777";
    public static final Vacancy DEFAULT_VACANCY = Vacancy.VACANT;

    private RoomNumber number;
    private Vacancy vacancy;
    private Set<Person> guests;

    /**
     * Creates a {@code RoomBuilder} with the default details.
     */
    public RoomBuilder() {
        number = new RoomNumber(DEFAULT_ROOM_NUMBER);
        vacancy = DEFAULT_VACANCY;
        guests = new HashSet<>();
    }

    /**
     * Initializes the RoomBuilder with the data of {@code roomToCopy}.
     */
    public RoomBuilder(Room roomToCopy) {
        number = roomToCopy.getRoomNumber();
        vacancy = roomToCopy.getVacancy();
        guests = roomToCopy.getGuests();
    }

    /**
     * Sets the {@code RoomNumber} of the {@code Room} that we are building.
     */
    public RoomBuilder withNumber(String number) {
        this.number = new RoomNumber(number);
        return this;
    }


    /**
     * Sets the {@code Vacancy} of the {@code Room} that we are building.
     */
    public RoomBuilder withVacancy(Vacancy vacancy) {
        this.vacancy = vacancy;
        return this;
    }

    /**
     * Sets the {@code Guests} of the {@code Room} that we are building.
     */
    public RoomBuilder withGuests(Person[] guests) {
        this.guests.addAll(Arrays.asList(guests.clone()));
        return this;
    }

    public Room build() {
        return new Room(number);
    }

}
