package solutions;

import java.util.Iterator;
import java.util.List;

public class Q281 extends Solution {

    public class ZigzagIterator {

        private Iterator<Integer> v1;
        private Iterator<Integer> v2;
        private boolean isV1;

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            this.v1 = v1.iterator();
            this.v2 = v2.iterator();
            this.isV1 = true;
        }

        public int next() {
            if (isV1 && v1.hasNext() || !v2.hasNext()) {
                isV1 = false;
                return v1.next();
            } else {    // (isV1 == false || !v1.hasNext()) && v2.hasNext()
                isV1 = true;
                return v2.next();
            }
        }

        public boolean hasNext() {
            return v1.hasNext() || v2.hasNext();
        }

    }

}
