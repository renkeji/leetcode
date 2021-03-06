package solutions;

import solutions.datastructures.NestedInteger;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a nested list of integers, implement an iterator to flatten it.
 *
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 * Example 1:
 *  Given the list [[1,1],2,[1,1]],
 *  By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
 *
 * Example 2:
 *  Given the list [1,[4,[6]]],
 *  By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
 */

public class Q341 extends Solution {

    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     *
     *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     *     public boolean isInteger();
     *
     *     // @return the single integer that this NestedInteger holds, if it holds a single integer
     *     // Return null if this NestedInteger holds a nested list
     *     public Integer getInteger();
     *
     *     // @return the nested list that this NestedInteger holds, if it holds a nested list
     *     // Return null if this NestedInteger holds a single integer
     *     public List<NestedInteger> getList();
     * }
     */
    public class NestedIterator implements Iterator<Integer> {

        private LinkedList<NestedInteger> list;

        public NestedIterator(List<NestedInteger> nestedList) {
            list = new LinkedList<>();
            flatten(nestedList);
        }

        @Override
        public Integer next() {
            return hasNext() ? list.removeFirst().getInteger() : null;
        }

        @Override
        public boolean hasNext() {
            return !list.isEmpty();
        }

        private void flatten(List<NestedInteger> nestedList) {
            for (NestedInteger ni : nestedList) {
                if (ni.isInteger()) {
                    list.add(ni);
                } else {
                    flatten(ni.getList());
                }
            }
        }

        @Override
        public void remove() {
            return;
        }
    }

}
