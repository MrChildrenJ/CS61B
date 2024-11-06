package IntList;
import java.util.*;
import static java.lang.System.*;

public class SLList {
    // The 1st item (if it exists) is at sentinel. Sentinel is never null
    /**
     * Invariants:
     *  1. The sentinel reference always points to a sentinel node
     *  2. The 1st node (if it exists) is always at sentinel.next
     *  3. The size variable is always the total number of items that have been added
     */
    private final IntNode sentinel = new IntNode();
    private int size;

    private static class IntNode {              // IntNode never use SLList object, so should be private and STATIC
        public int item;
        public IntNode next;

        public IntNode() {}
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    public SLList() {
        sentinel.next = null;
        size = 0;
    }

    public SLList(int x) {
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public void addFirst(int value) {
        sentinel.next = new IntNode(value, sentinel.next);
        size++;
    }

    public void addLast(int value) {
        IntNode curr = sentinel;

        // Move p until it reaches the end of the list
        while (curr.next != null) { curr = curr.next; }
        curr.next = new IntNode(value, null);
        size++;
    }

    public int realSize() {
        int count = 0;
        IntNode curr = sentinel.next;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    public int size() {
        return size;
    }

    public int getFirst() {
        return sentinel.next.item;
    }

    public static void main(String[] args) {
        SLList L = new SLList();
        L.addFirst(9);
        L.addFirst(8);
        L.addLast(11);
        IntNode curr = L.sentinel.next;
        while (curr != null) {
            out.println(curr.item);
            curr = curr.next;
        }
        out.println(L.size());
    }
}
