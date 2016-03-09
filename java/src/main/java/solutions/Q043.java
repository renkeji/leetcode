package solutions;

/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 *
 * Note: The numbers can be arbitrarily large and are non-negative.
 */

public class Q043 extends Solution {

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2))
            return "0";
        StringBuilder sb1 = new StringBuilder(num1).reverse();
        StringBuilder sb2 = new StringBuilder(num2).reverse();
        StringBuilder ans = new StringBuilder("0");
        int offset = 0, carry;
        for (int i = 0; i < sb1.length(); ++i) {
            carry = 0;
            int n1 = sb1.charAt(i) - '0';
            for (int j = 0; j < sb2.length(); ++j) {
                int n2 = sb2.charAt(j) - '0';
                int digit = offset + j < ans.length() ? ans.charAt(offset + j) - '0' : 0;
                int sum = (n1 * n2 + carry + digit) % 10;
                carry = (n1 * n2 + carry + digit) / 10;
                if (offset + j < ans.length()) {
                    ans.setCharAt(offset + j, (char)(sum + '0'));
                } else {
                    ans.append((char)(sum+'0'));
                }
            }
            if (carry != 0) ans.append((char)(carry + '0'));
            offset++;
        }
        return ans.reverse().toString();
    }

}
