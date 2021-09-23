package seedu.address.model.room;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class Vacancy {

    //TODO: Need a parser
    public static final String MESSAGE_CONSTRAINTS = "Vacancy can either only be vacant or occupied.";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";
    //public static final String VALIDATION_REGEX = "[^\\s].*";

    public final String value;

    /**
     * Constructs an {@code Vacancy}.
     *
     * @param vacancy A valid vacancy.
     */
    public Vacancy(String vacancy) {
        requireNonNull(vacancy);
        checkArgument(isValidVacancy(vacancy), MESSAGE_CONSTRAINTS);
        value = vacancy;
    }

    /**
     * Returns true if a given string is a valid vacancy status.
     */
    public static boolean isValidVacancy(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Vacancy // instanceof handles nulls
                && value.equals(((Vacancy) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
