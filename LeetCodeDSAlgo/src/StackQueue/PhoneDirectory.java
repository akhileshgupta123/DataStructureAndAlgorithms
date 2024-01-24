package StackQueue;
import java.util.*;

//379 Design Phone Directory
public class PhoneDirectory {
    private HashSet<Integer> used;
    private Queue<Integer> available;
    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        available = new LinkedList<Integer>();
        used = new HashSet<Integer>();
        for (int i = 0; i < maxNumbers; i ++) {
            available.add(i);
        }
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (available.isEmpty()) {
            return -1;
        }
        int next = available.poll();
        used.add(next);
        return next;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !used.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (used.contains(number)) {
            used.remove((Integer) number);
            available.add(number);
        }
    }
}
