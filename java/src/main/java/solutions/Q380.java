package solutions;

import java.util.*;

/**
 * Design a data structure that supports all following operations in average O(1) time.
 *  1. insert(val): Inserts an item val to the set if not already present.
 *  2. remove(val): Removes an item val from the set if present.
 *  3. getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 *
 * Example:
 *
 *  // Init an empty set.
 *  RandomizedSet randomSet = new RandomizedSet();
 *
 *  // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 *  randomSet.insert(1);
 *
 *  // Returns false as 2 does not exist in the set.
 *  randomSet.remove(2);
 *
 *  // Inserts 2 to the set, returns true. Set now contains [1,2].
 *  randomSet.insert(2);
 *
 *  // getRandom should return either 1 or 2 randomly.
 *  randomSet.getRandom();
 *
 *  // Removes 1 from the set, returns true. Set now contains [2].
 *  randomSet.remove(1);
 *
 *  // 2 was already in the set, so return false.
 *  randomSet.insert(2);
 *
 *  // Since 1 is the only number in the set, getRandom always return 1.
 *  randomSet.getRandom();
 */

public class Q380 extends Solution {

    public class RandomizedSet {

        private List<Integer> list;
        private Map<Integer, Integer> hm;
        private int size;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            list = new ArrayList<>();
            hm = new HashMap<>();
            size = 0;
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (hm.containsKey(val)) {
                return false;
            } else {
                if (size < list.size()) {
                    list.set(size, val);
                } else {
                    list.add(val);
                }
                hm.put(val, size++);
                return true;
            }
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!hm.containsKey(val)) {
                return false;
            } else {
                if (size != 1) {
                    int lastVal = list.get(size-1);
                    int idx = hm.get(val);
                    Collections.swap(list, idx, size-1);
                    hm.put(lastVal, idx);
                }
                hm.remove(val);
                size--;
                return true;
            }
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int idx = (int)(Math.random() * size);
            return list.get(idx);
        }
    }

}
