package IntList;

public class IntListExercises {

    /**
     * Part A: (Buggy) mutative method that adds a constant C to each
     * element of an IntList
     *
     * @param lst IntList from Lecture
     */
    public static void addConstant(IntList lst, int c) {
        IntList head = lst;
        while (head != null) {
            head.first += c;
            head = head.rest;
        }
    }
    
    public static IntList incrList(IntList L, int x) {
        if (L == null)  return null;

        IntList result = new IntList();
        result.first = L.first + x;

        if (L.rest != null) {
            result.rest = incrList(L.rest, x);
        }
        return result;
    }

    public static IntList ultimateIncrList(IntList L, int x) {
        if (L == null)  return null;
        return new IntList(L.first + x, ultimateIncrList(L.rest, x));
    }

    public static void incrementList(IntList L, int x) {
        if (L == null) return;
        while (L != null) {
            L.first += x;
            L = L.rest;
        }
    }
    /**
     * Part B: Buggy method that sets first.first to zero if
     * the max value in the list starting at first has the same
     * first and last digit, for every first in L
     *
     * @param L IntList from Lecture
     */
    public static void setToZeroIfMaxFEL(IntList L) {
        IntList p = L;
        while (p != null) {
            if (firstDigitEqualsLastDigit(max(p))) {
                p.first = 0;
            }
            p = p.rest;
        }
    }
    /** Returns the max value in the IntList starting at L. */
    public static int max(IntList L) {
        int max = L.first;
        IntList p = L.rest;
        while (p != null) {
            if (p.first > max) {
                max = p.first;
            }
            p = p.rest;
        }
        return max;
    }
    /** Returns true if the last digit of x is equal to
     *  the first digit of x.
     */
    public static boolean firstDigitEqualsLastDigit(int x) {
        int lastDigit = x % 10;
        while (x > 9) {
            x = x / 10;
        }
        int firstDigit = x % 10;
        return firstDigit == lastDigit;
    }
    /**
     * Part C: (Buggy) mutative method that squares each prime
     * element of the IntList.
     *
     * @param lst IntList from Lecture
     * @return True if there was an update to the list
     */
    public static boolean squarePrimes(IntList lst) {
        // Base Case: we have reached the end of the list
        boolean currElemIsPrime = false;
        if (lst == null)    return currElemIsPrime;

        while (lst.rest != null) {
            currElemIsPrime = Primes.isPrime(lst.first);
            if (currElemIsPrime)    lst.first *= lst.first;
            lst = lst.rest;
        }
        return currElemIsPrime || squarePrimes(lst.rest);
    }

    public static void main(String[] args) {
        IntList testList = IntList.of(1, 2, 3, 4);

        addConstant(testList, 5);
        System.out.println(testList.toString());
    }
}
