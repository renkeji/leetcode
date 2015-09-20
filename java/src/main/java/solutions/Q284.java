package solutions;

import java.util.Iterator;

/**
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation --
 *  it essentially peek() at the element that will be returned by the next call to next().
 *
 * Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].
 *  Call next() gets you 1, the first element in the list.
 *  Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
 *  You call next() the final time and it returns 3, the last element. Calling hasNext() after that should return false.
 *
 * Follow up: How would you extend your design to be generic and work with all types, not just integer?
 */

public class Q284 extends Solution {

    class PeekingIterator implements Iterator<Integer> {

        private Iterator<Integer> it;
        private Integer elem;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            it = iterator;
            elem = it.hasNext() ? it.next() : null;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return elem;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            int nextElem = elem;
            elem = it.hasNext() ? it.next() : null;
            return nextElem;
        }

        @Override
        public boolean hasNext() {
            return elem != null;
        }

        @Override
        public void remove() {
            it.remove();
        }
    }

}
