package solutions;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 *
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */

public class Q179 extends Solution {

    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        Integer[] numbers = new Integer[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            numbers[i] = nums[i];
        }
        Arrays.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);
                return (s2+s1).compareTo(s1+s2);
            }
        });
        for (int i : numbers) {
            sb.append(String.valueOf(i));
        }
        String ans = sb.toString();
        return !ans.isEmpty() && ans.charAt(0) == '0' ? "0" : ans;
    }

}
