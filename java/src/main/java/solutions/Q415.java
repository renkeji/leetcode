package solutions;

public class Q415 extends Solution {

    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.isEmpty()) {
            return num2;
        } else if (num2 == null || num2.isEmpty()) {
            return num1;
        } else {
            char[] num1s = num1.toCharArray();
            char[] num2s = num2.toCharArray();
            StringBuilder sb = new StringBuilder();
            int carry = 0;
            for (int i = 0; i < Math.max(num1s.length, num2s.length); ++i) {
                int n1 = i >= num1s.length ? 0 : num1s[num1s.length - i - 1] - '0';
                int n2 = i >= num2s.length ? 0 : num2s[num2s.length - i - 1] - '0';
                int sum = (n1 + n2 + carry) % 10;
                carry = (n1 + n2 + carry) / 10;
                sb.append(sum);
            }
            if (carry == 1) {
                sb.append(1);
            }
            return sb.reverse().toString();
        }
    }

}
