package solutions;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Example:
 *  Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 *
 * Note:
 *  Each element in the result must be unique.
 *  The result can be in any order.
 */

public class Q349 extends Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        } else {
            Set<Integer> hs1 = new HashSet<>();
            for (int num : nums1.length <= nums2.length ? nums1 : nums2) {
                hs1.add(num);
            }
            Set<Integer> hs2 = new HashSet<>();
            for (int num : nums2.length >= nums1.length ? nums2 : nums1) {
                if (hs1.contains(num)) {
                    hs2.add(num);
                }
            }
            int[] ans = new int[hs2.size()];
            Iterator<Integer> it = hs2.iterator();
            int i = 0;
            while (it.hasNext()) {
                ans[i++] = it.next();
            }
            return ans;
        }
    }

}
