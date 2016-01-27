package solutions;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * The update(i, val) function modifies nums by updating the element at index i to val.
 *
 * Example:
 *  Given nums = [1, 3, 5]
 *
 *  sumRange(0, 2) -> 9
 *  update(1, 2)
 *  sumRange(0, 2) -> 8
 *
 * Note:
 *  The array is only modifiable by the update function.
 *  You may assume the number of calls to update and sumRange function is distributed evenly.
 */

public class Q307 extends Solution {

    public class NumArray {

        private class SegmentTreeNode {
            int start, end;
            int sum;
            SegmentTreeNode left, right;

            public SegmentTreeNode(int start, int end) {
                this(start, end, 0);
            }

            public SegmentTreeNode(int start, int end, int sum) {
                this.start = start;
                this.end = end;
                this.sum = sum;
            }

        }

        private SegmentTreeNode root;

        public NumArray(int[] nums) {
            if (nums == null || nums.length == 0) {
                return;
            }
            root = buildSegmentTree(nums, 0, nums.length - 1);
        }

        public void update(int i, int val) {
            update(root, i, val);
        }

        private void update(SegmentTreeNode root, int i, int val) {
            if (root == null) {
                return;
            }

            int mid = root.start + (root.end - root.start) / 2;

            if (i <= mid) {
                update(root.left, i, val);
            } else {
                update(root.right, i, val);
            }

            if (root.start == root.end && root.start == i) {
                root.sum = val;
                return;
            }

            root.sum = root.left.sum + root.right.sum;
        }

        public int sumRange(int i, int j) {
            return sumRange(root, i, j);
        }

        private int sumRange(SegmentTreeNode root, int start, int end) {
            if (root == null || end < root.start || start > root.end || start > end) {
                return 0;
            }

            if (start <= root.start && end >= root.end) {
                return root.sum;
            }

            int mid = root.start + (root.end - root.start) / 2;

            return sumRange(root.left, start, Math.min(end, mid)) + sumRange(root.right, Math.max(mid + 1, start), end);
        }

        private SegmentTreeNode buildSegmentTree(int[] nums, int start, int end) {
            if (nums == null || nums.length == 0 || start > end) {
                return null;
            }

            if (start == end) {
                return new SegmentTreeNode(start, end, nums[start]);
            }

            SegmentTreeNode root = new SegmentTreeNode(start, end);
            int mid = start + (end - start) / 2;
            root.left = buildSegmentTree(nums, start, mid);
            root.right = buildSegmentTree(nums, mid + 1, end);

            root.sum = root.left.sum + root.right.sum;

            return root;
        }

    }

}
