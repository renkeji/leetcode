package solutions;

import java.util.LinkedList;

/**
 * Design a hit counter which counts the number of hits received in the past 5 minutes.
 *
 * Each function accepts a timestamp parameter (in seconds granularity) and you may assume that calls are being made to
 * the system in chronological order (ie, the timestamp is monotonically increasing).
 *
 * You may assume that the earliest timestamp starts at 1.
 *
 * It is possible that several hits arrive roughly at the same time.
 *
 * Example:
 *  HitCounter counter = new HitCounter();
 *
 *  // hit at timestamp 1.
 *  counter.hit(1);
 *
 *  // hit at timestamp 2.
 *  counter.hit(2);
 *
 *  // hit at timestamp 3.
 *  counter.hit(3);
 *
 *  // get hits at timestamp 4, should return 3.
 *  counter.getHits(4);
 *
 *  // hit at timestamp 300.
 *  counter.hit(300);
 *
 *  // get hits at timestamp 300, should return 4.
 *  counter.getHits(300);
 *
 *  // get hits at timestamp 301, should return 3.
 *  counter.getHits(301);
 *
 * Follow up:
 *  What if the number of hits per second could be very large? Does your design scale?
 */

public class Q362 extends Solution {

    /**
     * Your HitCounter object will be instantiated and called as such:
     * HitCounter obj = new HitCounter();
     * obj.hit(timestamp);
     * int param_2 = obj.getHits(timestamp);
     */
    public class HitCounter {

        private LinkedList<Integer> counter;
        private int hits;

        /** Initialize your data structure here. */
        public HitCounter() {
            counter = new LinkedList<>();
            hits = 0;
        }

        /** Record a hit.
         @param timestamp - The current timestamp (in seconds granularity). */
        public void hit(int timestamp) {
            counter.addFirst(timestamp);
            hits++;
        }

        /** Return the number of hits in the past 5 minutes.
         @param timestamp - The current timestamp (in seconds granularity). */
        public int getHits(int timestamp) {
            cleanup(timestamp);
            return hits;
        }

        private void cleanup(int timestamp) {
            while (!counter.isEmpty() && timestamp - counter.getLast() >= 300) {
                counter.removeLast();
                hits--;
            }
        }
    }

}
