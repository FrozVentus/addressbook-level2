package seedu.addressbook.data.taggings;

import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.tag.Tag;

public class Tagging {

    public static final String TAGGING_ACTION_ADD = "+";
    public static final String TAGGING_ACTION_DELETE = "-";

    private final String value;

    public Tagging(String actionType, ReadOnlyPerson person, Tag tag) {
        String taggingString = actionType + " " + person.getName() + " " + tag;
        this.value = taggingString;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Tagging // instanceof handles nulls
                && this.value.equals(((Tagging) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
