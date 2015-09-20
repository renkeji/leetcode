package solutions;

import java.util.*;

/**
 * Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators.
 * The valid operators are +, - and *.
 *
 * Example 1
 *  Input: "2-1-1".
 *  ((2-1)-1) = 0
 *  (2-(1-1)) = 2
 *  Output: [0, 2]
 *
 * Example 2
 *  Input: "2*3-4*5"
 *  (2*(3-(4*5))) = -34
 *  ((2*3)-(4*5)) = -14
 *  ((2*(3-4))*5) = -10
 *  (2*((3-4)*5)) = -10
 *  (((2*3)-4)*5) = 10
 *  Output: [-34, -14, -10, -10, 10]
 */

public class Q241 extends Solution {

    public List<Integer> diffWaysToCompute(String input) {
        return diffWaysToCompute(input, new HashMap<String, List<Integer>>());
    }

    private List<Integer> diffWaysToCompute(String input, Map<String, List<Integer>> hm) {
        List<Integer> ans = new ArrayList<>();
        if (input == null || input.isEmpty()) {
            return ans;
        } else {
            for (int i = 0; i < input.length(); ++i) {
                char op = input.charAt(i);
                if (op < '0' || op > '9') {
                    String left = input.substring(0, i);
                    List<Integer> leftValues = hm.get(left);
                    if (leftValues == null) {
                        leftValues = diffWaysToCompute(left, hm);
                    }
                    String right = input.substring(i + 1);
                    List<Integer> rightValues = hm.get(right);
                    if (rightValues == null) {
                        rightValues = diffWaysToCompute(right, hm);
                    }
                    for (int leftValue : leftValues) {
                        for (int rightValue : rightValues) {
                            ans.add(compute(leftValue, rightValue, op));
                        }
                    }
                }
            }
            if (ans.isEmpty()) {
                ans.add(Integer.parseInt(input));
            }
            hm.put(input, ans);
            return ans;
        }
    }

    private int compute(int num1, int num2, char op) {
        switch (op) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            default:
                return 0;
        }
    }

}
