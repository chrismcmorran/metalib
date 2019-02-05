package jdkreplacement;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ArrayList<E> extends java.util.ArrayList<E> {

    public ArrayList(int initialCapacity) {
        super(initialCapacity);
    }

    public ArrayList() {
    }

    public ArrayList(Collection<? extends E> c) {
        super(c);
    }

    /**
     * Prints each item in the list.
     * @return This list.
     */
    public ArrayList<E> Print() {
        for (E item : this) {
            System.out.println(item);
        }
        return this;
    }

    /**
     * Creates a set from the list.
     * @return A Set.
     */
    public Set<E> Set() {
        return new HashSet<>(this);
    }
}
