package seedu.address.model.person;

public class Id {

    public static final String MESSAGE_CONSTRAINTS =
            "IDs must be an integer greater than or equal to 0.";
    private static int nextId = 0;
    public final int value;

    protected Id() {
        this.value = nextId;
        nextId++;
    }

    private Id(int id) {
        this.value = id;
    }

    public static Id of(int id) {
        return new Id(id);
    }

    public static boolean isValidId(int id) {
        return id >= 0;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int newNextId) {
        nextId = newNextId;
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
