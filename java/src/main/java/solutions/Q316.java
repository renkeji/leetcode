package solutions;

import java.util.Stack;

/**
 * Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and
 * only once. You must make sure your result is the smallest in lexicographical order among all possible results.
 *
 * Example:
 *  Given "bcabc"
 *  Return "abc"
 *
 *  Given "cbacdcbc"
 *  Return "acdb"
 */

public class Q316 extends Solution {

    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            count[c-'a']++;
        }
        for (char c : s.toCharArray()) {
            int i = c - 'a';
            count[i]--;
            if (visited[i]) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c && count[stack.peek()-'a'] != 0) {
                visited[stack.pop()-'a'] = false;
            }
            stack.push(c);
            visited[i] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

}
