package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

import seedu.address.model.person.exceptions.InvalidNRICException;

/**
 * The ID field of a person. Used to distinguish between different Persons,
 * especially if they have the same name.
 */
public class NRIC {

    public static final String MESSAGE_CONSTRAINTS =
            "NRICs must not be an empty string, or null.";
    //private static int nextId = 0;
    //public final int value;
    public final String value;

    public static String NOT_APPLICABLE_TO_PERSON = "NOT APPLICABLE";

    /**
     * Constructor for NRIC object.
     */
    public NRIC(String IC) {
        this.value = IC;
    }

    /**
     * Default constructor for NRIC object; used if person for some reason does not
     * have an NRIC number; usually a foreigner.
     */
    protected NRIC() {
        this.value = NOT_APPLICABLE_TO_PERSON;
    }

    /**
     * Constructs an Id object using given Integer Id.
     *
     * @param IC the NRIC of the guest, stored as a String.
     * @return a unique NRIC object.
     */
    public static NRIC of(String IC) {
        requireNonNull(IC);

        if (IC.isEmpty()) {
            throw new InvalidNRICException();
        }

        return new NRIC(IC);
    }

    /**
     * Evaluates if an NRIC provided is valid to be a Person's NRIC.
     * In other words, it checks for null or whether the string is empty.
     *
     * @param IC the String of a supposed NRIC.
     * @return boolean to indicate if integer is non-negative.
     */
    public static boolean isValidNRIC(String IC) {
        requireNonNull(IC);
        return IC.isEmpty();
    }

    /**
     * Returns the NRIC object's value.
     * @return the String that the NRIC object contains.
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
                || (other instanceof NRIC
                && ((NRIC) other).value == this.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
