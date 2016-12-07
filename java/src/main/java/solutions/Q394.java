package solutions;

/**
 * Given an encoded string, return it's decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 *
 * Examples:
 *
 *  s = "3[a]2[bc]", return "aaabcbc".
 *  s = "3[a2[c]]", return "accaccacc".
 *  s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */

public class Q394 extends Solution {

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        if (s != null && !s.isEmpty()) {
            int i = 0;
            while (i < s.length()) {
                char ch = s.charAt(i);
                if (ch >= '0' && ch <= '9') {
                    int repeat = extractNumber(s.substring(i));
                    int repeatLength = String.valueOf(repeat).length();
                    String token = extractToken(s.substring(i + repeatLength));
                    String sub = decodeString(token);
                    for (int j = 0; j < repeat; ++j) {
                        sb.append(sub);
                    }
                    i += repeatLength + token.length() + 2;
                } else {
                    sb.append(ch);
                    i++;
                }
            }
        }
        return sb.toString();
    }

    private int extractNumber(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); ++i) {
            int c = s.charAt(i) - '0';
            if (c >= 0 && c <= 9) {
                num = num == 0 ? c : num * 10 + c;
            } else {
                break;
            }
        }
        return num;
    }

    private String extractToken(String s) {
        StringBuilder sb = new StringBuilder();
        if (s != null && !s.isEmpty() && s.charAt(0) == '[') {
            int left = 0;
            for (int i = 1; i < s.length(); ++i) {
                char ch = s.charAt(i);
                if (ch == '[') {
                    left++;
                } else if (ch == ']') {
                    if (left == 0) {
                        return sb.toString();
                    } else {
                        left--;
                    }
                }
                sb.append(ch);
            }
        }
        return sb.toString();
    }

}
