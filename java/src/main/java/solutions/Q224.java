package solutions;

import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 *
 * You may assume that the given expression is always valid.
 *
 * Some examples:
 *  "1 + 1" = 2
 *  " 2-1 + 2 " = 3
 *  "(1+(4+5+2)-3)+(6+8)" = 23
 *
 * Note: Do not use the eval built-in library function.
 */

public class Q224 extends Solution {

    public int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        s = "(" + s + ")";
        int[] p = {0};
        return eval(s, p);
    }

    // calculate value between parentheses
    private int eval(String s, int[] p) {
        int val = 0;
        int i = p[0];
        int op = 1; //1:+ -1:-
        int num = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            switch (c) {
                case '+': val = val + op * num; num = 0; op = 1; i++; break;            // end of number and set operator
                case '-': val = val + op * num; num = 0; op = -1; i++; break;           // end of number and set operator
                case '(': p[0] = i + 1; val = val + op * eval(s, p); i = p[0]; break;   // start a new eval
                case ')': p[0] = i + 1; return val + op * num;                          // end current eval and return. Note that we need to deal with the last num
                case ' ': i++; continue;
                default : num = num * 10 + c - '0'; i++;
            }
        }
        return val;
    }

}
