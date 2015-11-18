package solutions;

import java.util.*;

/**
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 *
 * Note: The input string may contain letters other than the parentheses ( and ).
 *
 * Examples:
 *  "()())()" -> ["()()()", "(())()"]
 *  "(a)())()" -> ["(a)()()", "(a())()"]
 *  ")(" -> [""]
 */

public class Q301 extends Solution {
    // BFS
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        if (s != null) {
            Set<String> visited = new HashSet<>();
            Queue<String> queue = new LinkedList<>();

            queue.add(s);
            visited.add(s);

            boolean found = false;

            while (!queue.isEmpty()) {
                s = queue.poll();

                if (isValid(s)) {
                    ans.add(s);
                    found = true;
                }

                if (!found) {
                    for (int i = 0; i < s.length(); ++i) {
                        if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                            String t = s.substring(0, i) + s.substring(i + 1);
                            if (!visited.contains(t)) {
                                queue.add(t);
                                visited.add(t);
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }

    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            }
            if (c == ')' && count-- == 0) {
                return false;
            }
        }
        return count == 0;
    }

    // DFS
//    public List<String> removeInvalidParentheses(String s) {
//        List<String> ans = new ArrayList<>();
//        if (s != null) {
//
//        }
//        return ans;
//    }

}
