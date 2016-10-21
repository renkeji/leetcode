package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 *
 * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
 *
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 *
 * Example 1:
 *  Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3
 *  Return: [1,2],[1,4],[1,6]
 *  The first 3 pairs are returned from the sequence:
 *  [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 *
 * Example 2:
 *  Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2
 *  Return: [1,1],[1,1]
 *  The first 2 pairs are returned from the sequence:
 *  [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 *
 * Example 3:
 *  Given nums1 = [1,2], nums2 = [3],  k = 3
 *  Return: [1,3],[2,3]
 *  All possible pairs are returned from the sequence:
 *  [1,3],[2,3]
 */

public class Q373 extends Solution {

    private class Pair implements Comparable<Pair> {
        int idx;
        int num1;
        int num2;

        Pair(int num1, int num2, int idx) {
            this.num1 = num1;
            this.num2 = num2;
            this.idx = idx;
        }

        int getSum() {
            return num1 + num2;
        }

        @Override
        public int compareTo(Pair o) {
            return this.getSum() - o.getSum();
        }
    }

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> ans = new ArrayList<>();

        if (nums1 != null && nums2 != null && nums1.length != 0 && nums2.length != 0) {
            Queue<Pair> pq = new PriorityQueue<>(k);

            for (int i = 0; i < Math.min(k, nums1.length); ++i) {
                pq.offer(new Pair(nums1[i], nums2[0], 0));
            }

            for (int i = 0; i < k && !pq.isEmpty(); ++i) {
                Pair p = pq.poll();
                ans.add(new int[]{p.num1, p.num2});
                if (p.idx < nums2.length - 1) {
                    int j = p.idx + 1;
                    pq.offer(new Pair(p.num1, nums2[j], j));
                }
            }
        }

        return ans;
    }

}
