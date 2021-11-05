package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

import seedu.address.model.person.exceptions.InvalidNricException;

/**
 * The ID field of a person. Used to distinguish between different Persons,
 * especially if they have the same name.
 */
public class Nric {

    public static final String MESSAGE_CONSTRAINTS =
            "IDs must not be empty or only whitespace characters";
    public static final String NOT_APPLICABLE_TO_PERSON = "NOT APPLICABLE";
    public final String value;

    /**
     * Constructor for Nric object.
     */
    public Nric(String ic) {
        this.value = ic;
    }

    /**
     * Default constructor for Nric object; used if person for some reason does not
     * have an Nric number; usually a foreigner.
     */
    protected Nric() {
        this.value = NOT_APPLICABLE_TO_PERSON;
    }

    /**
     * Constructs an Id object using given Integer Id.
     *
     * @param ic the Nric of the guest, stored as a String.
     * @return a unique Nric object.
     */
    public static Nric of(String ic) {
        requireNonNull(ic);

        if (ic.isEmpty()) {
            throw new InvalidNricException();
        }

        return new Nric(ic);
    }

    /**
     * Evaluates if an Nric provided is valid to be a Person's Nric.
     * In other words, it checks for null or whether the string is empty.
     *
     * @param ic the String of a supposed Nric.
     * @return boolean to indicate if string is non-empty.
     */
    public static boolean isValidNric(String ic) {
        requireNonNull(ic);
        return (ic.length() > 0);
    }

    /**
     * Returns the Nric object's value.
     * @return the String that the Nric object contains.
     */
    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof Nric
                && ((Nric) other).value.equals(this.value));
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
