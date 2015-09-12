package solutions;

public class Q268 extends Solution {

    // TODO: need to consider the overflow case
    public int missingNumber(int[] nums) {
        int expectedSum = (nums.length + 1) * nums.length / 2;
        int actualSum = 0;
        for (int i : nums) {
            actualSum += i;
        }
        return expectedSum - actualSum;
    }

}
