package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Example:
 *  Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 *
 * Note:
 *  Each element in the result should appear as many times as it shows in both arrays.
 *  The result can be in any order.
 *
 * Follow up:
 *  What if the given array is already sorted? How would you optimize your algorithm?
 *  What if nums1's size is small compared to nums2's size? Which algorithm is better?
 *  What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */

public class Q350 extends Solution {

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        } else {
            Map<Integer, Integer> hm = new HashMap<>();
            for (int num : nums1.length <= nums2.length ? nums1 : nums2) {
                if (!hm.containsKey(num)) {
                    hm.put(num, 0);
                }
                hm.put(num, hm.get(num)+1);
            }
            List<Integer> list = new ArrayList<>();
            for (int num : nums2.length >= nums1.length ? nums2 : nums1) {
                if (hm.containsKey(num)) {
                    list.add(num);
                    if (hm.get(num) == 1) {
                        hm.remove(num);
                    } else {
                        hm.put(num, hm.get(num)-1);
                    }
                }
            }
            int[] ans = new int[list.size()];
            for (int i = 0; i < ans.length; ++i) {
                ans[i] = list.get(i);
            }
            return ans;
        }
    }

}
