package solutions;

public class Q067 extends Solution {

    public String addBinary(String a, String b) {
        assert a != null && b != null;

        StringBuilder sb = new StringBuilder();
        int aLen = a.length(), bLen = b.length(), carry = 0, limit = Math.max(aLen, bLen);
        for (int i = 0; i < limit; ++i) {
            int aDigit = i >= aLen ? 0 : a.charAt(aLen - i - 1) - '0';
            int bDigit = i >= bLen ? 0 : b.charAt(bLen - i - 1) - '0';
            int sum = aDigit + bDigit + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry == 1) sb.append(1);
        return sb.reverse().toString();
    }

}
