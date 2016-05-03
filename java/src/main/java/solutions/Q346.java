package solutions;

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 *
 * For example,
 *  MovingAverage m = new MovingAverage(3);
 *  m.next(1) = 1
 *  m.next(10) = (1 + 10) / 2
 *  m.next(3) = (1 + 10 + 3) / 3
 *  m.next(5) = (10 + 3 + 5) / 3
 */

public class Q346 extends Solution {

    public class MovingAverage {

        private int[] buffer;
        private int sum;
        private int size;
        private int index;

        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            buffer = new int[size];
            sum = 0;
            size = 0;
            index = 0;
        }

        public double next(int val) {
            size = size < buffer.length ? size++ : size;
            sum = sum - buffer[index] + val;
            buffer[index] = val;
            index = (index + 1) % buffer.length;
            return sum * 1.0 / size;
        }
    }

}
