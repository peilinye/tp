package seedu.address.storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Id;
import seedu.address.model.person.Person;
import seedu.address.model.residency.Residency;
import seedu.address.model.room.Room;
import seedu.address.model.room.RoomNumber;

/**
 * An Immutable AddressBook that is serializable to JSON format.
 */
@JsonRootName(value = "addressbook")
class JsonSerializableAddressBook {

    public static final String MESSAGE_DUPLICATE_PERSON = "Persons list contains duplicate person(s).";

    public static final String MESSAGE_DUPLICATE_ROOM = "Rooms list contains duplicate room(s).";

    private final List<JsonAdaptedPerson> persons = new ArrayList<>();

    private final List<JsonAdaptedRoom> rooms = new ArrayList<>();

    private final List<JsonAdaptedResidency> residencies = new ArrayList<>();

    private final int idCounter;

    /**
     * Constructs a {@code JsonSerializableAddressBook} with the given persons, rooms and id counter.
     */
    @JsonCreator
    public JsonSerializableAddressBook(@JsonProperty("persons") List<JsonAdaptedPerson> persons,
                                       @JsonProperty("rooms") List<JsonAdaptedRoom> rooms,
                                       @JsonProperty("residencies") List<JsonAdaptedResidency> residencies,
                                       @JsonProperty("id counter") int idCounter) {
        this.persons.addAll(persons);
        this.rooms.addAll(rooms);
        this.residencies.addAll(residencies);
        this.idCounter = idCounter;
    }

    /**
     * Converts a given {@code ReadOnlyAddressBook} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableAddressBook}.
     */
    public JsonSerializableAddressBook(ReadOnlyAddressBook source) {
        persons.addAll(source.getPersonList().stream().map(JsonAdaptedPerson::new).collect(Collectors.toList()));
        rooms.addAll(source.getRoomList().stream().map(JsonAdaptedRoom::new).collect(Collectors.toList()));
        residencies.addAll(source.getResidencyList().stream()
                .map(JsonAdaptedResidency::new).collect(Collectors.toList()));
        idCounter = Id.getNextId();
    }

    /**
     * Converts this address book into the model's {@code AddressBook} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public AddressBook toModelType() throws IllegalValueException {
        AddressBook addressBook = new AddressBook();

        addPersonsAndRooms(addressBook);
        addResidencies(addressBook);
        setId();

        return addressBook;
    }

    private void addPersonsAndRooms(AddressBook addressBook) throws IllegalValueException {
        for (JsonAdaptedPerson jsonAdaptedPerson : persons) {
            Person person = jsonAdaptedPerson.toModelType();
            if (addressBook.hasPerson(person)) {
                throw new IllegalValueException(MESSAGE_DUPLICATE_PERSON);
            }
            addressBook.addPerson(person);
        }
        for (JsonAdaptedRoom jsonAdaptedRoom : rooms) {
            Room room = jsonAdaptedRoom.toModelType();
            if (addressBook.hasRoom(room)) {
                throw new IllegalValueException(MESSAGE_DUPLICATE_ROOM);
            }
            addressBook.addRoom(room);
        }
    }

    private void addResidencies(AddressBook addressBook) {
        Map<Id, Person> idPersonMap = new HashMap<>();
        Map<RoomNumber, Room> roomNumberRoomMap = new HashMap<>();

        for (Person person : addressBook.getPersonList()) {
            idPersonMap.put(person.getId(), person);
        }

        for (Room room : addressBook.getRoomList()) {
            roomNumberRoomMap.put(room.getRoomNumber(), room);
        }

        for (JsonAdaptedResidency jsonAdaptedResidency : residencies) {
            Residency residency = jsonAdaptedResidency.toModelType(idPersonMap, roomNumberRoomMap);
            addressBook.register(residency);
        }
    }

    private void setId() {
        Id.setNextId(idCounter);
    }

}
