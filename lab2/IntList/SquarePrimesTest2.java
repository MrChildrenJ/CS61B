package IntList;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import static java.lang.System.*;

class SquarePrimesTest2 {

    @Test
    void squarePrimes() {
        IntList list = IntList.of(2, 3, 5, 7, 11, 12);
        boolean changed = IntListExercises.squarePrimes(list);
        assertEquals("4 -> 9 -> 25 -> 49 -> 121 -> 12", list.toString());
        assertTrue(changed);
    }
}