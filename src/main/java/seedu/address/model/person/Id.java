package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

import seedu.address.model.person.exceptions.InvalidIdException;

public class Id {

    public static final String MESSAGE_CONSTRAINTS =
            "IDs must be an integer greater than or equal to 0.";
    private static int nextId = 0;
    public final int value;

    /**
     * Constructor for Id object.
     * Automatically increases nextId.
     */
    protected Id() {
        this.value = nextId;
        nextId++;
    }

    /**
     * Constructor for Id object given an Integer Id.
     * @param id
     */
    private Id(int id) {
        this.value = id;
    }

    /**
     * Constructs an Id object using given Integer Id.
     *
     * @param id integer id of the guest.
     * @return a unique Id object.
     */
    public static Id of(int id) {
        requireNonNull(id);

        if (id < 0) {
            throw new InvalidIdException();
        }
        return new Id(id);
    }

    /**
     * Evaluates if an Integer provided is valid to be an Id.
     *
     * @param id integer value provided.
     * @return boolean to indicate if integer is non-negative.
     */
    public static boolean isValidId(int id) {
        return id >= 0;
    }

    /**
     * Returns the class's nextId attribute.
     *
     * @return integer value of class's nextId attribute.
     */
    public static int getNextId() {
        return nextId;
    }

    /**
     * Sets the class's nextId attribute.
     *
     * @param newNextId integer value of class's nextId to be set to.
     */
    public static void setNextId(int newNextId) {
        requireNonNull(newNextId);

        if (newNextId < 0) {
            throw new InvalidIdException();
        }
        nextId = newNextId;
    }

    /**
     * Returns the Id object's value.
     * @return the Integer value the Id object holds.
     */
    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof Id
                && ((Id) other).value == this.value);
    }

    @Override
    public int hashCode() {
        return ((Integer) value).hashCode();
    }

}
