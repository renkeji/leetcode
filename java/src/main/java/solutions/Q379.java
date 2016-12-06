package solutions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Design a Phone Directory which supports the following operations:
 *  1. get: Provide a number which is not assigned to anyone.
 *  2. check: Check if a number is available or not.
 *  3. release: Recycle or release a number.
 *
 * Example:
 *
 *  // Init a phone directory containing a total of 3 numbers: 0, 1, and 2.
 *  PhoneDirectory directory = new PhoneDirectory(3);
 *
 *  // It can return any available phone number. Here we assume it returns 0.
 *  directory.get();
 *
 *  // Assume it returns 1.
 *  directory.get();
 *
 *  // The number 2 is available, so return true.
 *  directory.check(2);
 *
 *  // It returns 2, the only number that is left.
 *  directory.get();
 *
 *  // The number 2 is no longer available, so return false.
 *  directory.check(2);
 *
 *  // Release number 2 back to the pool.
 *  directory.release(2);
 *
 *  // Number 2 is available again, return true.
 *  directory.check(2);
 */

public class Q379 extends Solution {

    public class PhoneDirectory {

        LinkedList<Integer> availableNums;
        boolean[] isUsed;

        /** Initialize your data structure here
         @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
        public PhoneDirectory(int maxNumbers) {
            availableNums = new LinkedList<>();
            isUsed = new boolean[maxNumbers];
            for (int num = 0; num < maxNumbers; ++num) {
                availableNums.addFirst(num);
            }
        }

        /** Provide a number which is not assigned to anyone.
         @return - Return an available number. Return -1 if none is available. */
        public int get() {
            if (availableNums.isEmpty()) {
                return -1;
            } else {
                int num = availableNums.removeFirst();
                isUsed[num] = true;
                return num;
            }
        }

        /** Check if a number is available or not. */
        public boolean check(int number) {
            return !isUsed[number];
        }

        /** Recycle or release a number. */
        public void release(int number) {
            if (isUsed[number]) {
                isUsed[number] = false;
                availableNums.addFirst(number);
            }
        }
    }

}
