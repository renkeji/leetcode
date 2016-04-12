package solutions;

import java.util.Collections;
import java.util.PriorityQueue;

public class Q295 extends Solution {

    public class MedianFinder {

        private PriorityQueue<Double> minHeap, maxHeap;

        public MedianFinder() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(10, Collections.reverseOrder());
        }

        // Adds a number into the data structure.
        public void addNum(int num) {
            int minSize = minHeap.size(), maxSize = maxHeap.size();
            if (maxSize == minSize) {
                if (!minHeap.isEmpty() && num > minHeap.peek()) {
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer((double)num);
                } else {
                    maxHeap.offer((double)num);
                }
            } else {
                if (num < maxHeap.peek()) {
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer((double)num);
                } else {
                    minHeap.offer((double)num);
                }
            }
        }

        // Returns the median of current data stream
        public double findMedian() {
            if (minHeap.size() == maxHeap.size()) {
                return (minHeap.peek() + maxHeap.peek()) / 2;
            } else {
                return maxHeap.peek();
            }
        }

    }

}
