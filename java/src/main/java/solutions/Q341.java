package solutions;

import solutions.datastructures.NestedInteger;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

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

        private Stack<NestedInteger> stack;

        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new Stack<>();
            flatten(nestedList);
        }

        @Override
        public Integer next() {
            return hasNext() ? stack.pop().getInteger() : null;
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        private void flatten(List<NestedInteger> nestedList) {
            for (int i = nestedList.size() - 1; i >= 0; --i) {
                NestedInteger ni = nestedList.get(i);
                if (ni.isInteger()) {
                    stack.push(ni);
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
