package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement the following operations of a stack using queues.
 *  push(x) -- Push element x onto stack.
 *  pop() -- Removes the element on top of the stack.
 *  top() -- Get the top element.
 *  empty() -- Return whether the stack is empty.
 *
 * Notes:
 *  You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 *  Depending on your language, queue may not be supported natively.
 *  You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 *  You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 */

public class Q225 extends Solution {

    class MyStack {
        private List<Integer> l1;
        private List<Integer> l2;

        public MyStack() {
            l1 = new ArrayList<>();
            l2 = new ArrayList<>();
        }

        // Push element x onto stack.
        public void push(int x) {
            l2.add(x);
        }

        // Removes the element on top of the stack.
        public void pop() {
            transfer();
            if (!l2.isEmpty()) {
                l2.remove(0);
            }
            l2 = l1;
            l1 = new ArrayList<>();
        }

        // Get the top element.
        public int top() {
            transfer();
            return !l2.isEmpty() ? l2.get(0) : 0;
        }

        // Return whether the stack is empty.
        public boolean empty() {
            return l1.isEmpty() && l2.isEmpty();
        }

        private void transfer() {
            while (l2.size() > 1) {
                l1.add(l2.remove(0));
            }
        }
    }

}
