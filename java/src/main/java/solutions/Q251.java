package solutions;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Implement an iterator to flatten a 2d vector.
 *
 * For example,
 *      Given 2d vector =
 *      [
 *          [1,2],
 *          [3],
 *          [4,5,6]
 *      ]
 *
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].
 */

public class Q251 extends Solution {

    public class Vector2D {

        private Iterator<List<Integer>> outer;
        private Iterator<Integer> inner;

        public Vector2D(List<List<Integer>> vec2d) {
            this.outer = (vec2d != null && !vec2d.isEmpty()) ? vec2d.iterator() : Collections.emptyIterator();
            this.inner = outer.hasNext() ? outer.next().iterator() : Collections.emptyIterator();
        }

        public int next() {
            return inner.next();
        }

        public boolean hasNext() {
            while (!inner.hasNext()) {
                if (!outer.hasNext()) {
                    return false;
                }
                inner = outer.next().iterator();
            }
            return true;
        }

    }

}
