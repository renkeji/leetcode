package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 *  add - Add the number to an internal data structure.
 *  find - Find if there exists any pair of numbers which sum is equal to the value.
 *
 * For example,
 *  add(1); add(3); add(5);
 *  find(4) -> true
 *  find(7) -> false
 */

public class Q170 extends Solution {

    public class TwoSum {

        private Map<Integer, Integer> hm;

        public TwoSum() {
            hm = new HashMap<>();
        }

        public void add(int number) {
            if (!hm.containsKey(number)) {
                hm.put(number, 0);
            }
            hm.put(number, hm.get(number) + 1);
        }

        public boolean find(int value) {
            for (Integer key : hm.keySet()) {
                int remainder = value - key;
                if (hm.containsKey(remainder)) {
                    return remainder != key || hm.get(key) >= 2;
                }
            }
            return false;
        }

    }

}
