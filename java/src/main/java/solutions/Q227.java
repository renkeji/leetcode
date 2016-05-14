package solutions;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
 *
 * The integer division should truncate toward zero.
 *
 * You may assume that the given expression is always valid.
 *
 * Some examples:
 *  "3+2*2" = 7
 *  " 3/2 " = 1
 *  " 3+5 / 2 " = 5
 *
 * Note: Do not use the eval built-in library function.
 */

public class Q227 extends Solution {

    public int calculate(String s) {
        int result = 0, preVal = 0, num = 0;
        char preOp = '+';

        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = 10 * num + (ch - '0');
            }

            if (!Character.isDigit(ch) && (ch != ' ') || i == s.length() - 1) {
                switch (preOp) {
                    case '+':
                        result += num;
                        preVal = num;
                        break;
                    case '-':
                        result -= num;
                        preVal = -num;
                        break;
                    case '*':
                        result = result - preVal + preVal * num;
                        preVal = preVal * num;
                        break;
                    case '/':
                        result = result - preVal + preVal / num;
                        preVal = preVal / num;
                        break;
                    default: break;
                }
                num = 0;
                preOp = ch;
            }
        }

        return result;
    }

}