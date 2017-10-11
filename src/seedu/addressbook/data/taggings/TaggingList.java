package seedu.addressbook.data.taggings;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;

public class TaggingList implements Iterable<Tagging>{

    private final List<Tagging> internalList = new ArrayList<>();

    /**
     * Constructs empty tagging list.
     */
    public TaggingList() {}

    /**
     * Constructs a shallow copy of the list.
     */

    public TaggingList(TaggingList source) {
        internalList.addAll(source.internalList);
    }

    /**
     * Adds an entry to the list.
     */
    public void add(String action, ReadOnlyPerson person) {
        Tagging toAdd;
        UniqueTagList tagChanges = person.getTags();
        for (Tag tag : tagChanges) {
            toAdd = new Tagging(action, person, tag);
            internalList.add(toAdd);
        }
    }

    @Override
    public Iterator<Tagging> iterator() {
        return internalList.iterator();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof TaggingList // instanceof handles nulls
                && this.internalList.equals(((TaggingList) other).internalList));
    }

}
