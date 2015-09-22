package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * The algorithm should run in linear time and in O(1) space.
 */

public class Q229 extends Solution {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums != null && nums.length != 0) {
            Integer one = null, two = null;
            int countOne = 0, countTwo = 0;
            for (int i : nums) {
                if (one != null && i == one) {
                    countOne++;
                } else if (two != null && i == two) {
                    countTwo++;
                } else if (countOne == 0) {
                    one = i;
                    countOne = 1;
                } else if (countTwo == 0) {
                    two = i;
                    countTwo = 1;
                } else {
                    countOne--;
                    countTwo--;
                }
            }

            countOne = countTwo = 0;
            for (int i : nums) {
                if (one != null && i == one) {
                    countOne++;
                } else if (two != null && i == two) {
                    countTwo++;
                }
            }

            if (countOne > nums.length / 3) {
                ans.add(one);
            }
            if (countTwo > nums.length / 3) {
                ans.add(two);
            }
        }
        return ans;
    }

}
