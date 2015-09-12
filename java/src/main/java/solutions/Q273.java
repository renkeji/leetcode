package solutions;

public class Q273 extends Solution {

    public String convertThree(int n) {
        String[] ONES = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
        String[] ONE_TENS = {"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] TENS = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String ans = "";
        int hundred = n / 100;
        if (hundred != 0) {
            ans += ONES[hundred-1] + " Hundred";
        }

        int ten = n % 100;
        if (ten >= 11 && ten <= 19) {
            ans += " " + ONE_TENS[ten-11];
        } else if (ten > 19) {
            ans += " " + TENS[ten/10-2];
            if (ten % 10 != 0) {
                ans += " " + ONES[ten%10-1];
            }
        } else if (ten > 0 && ten <= 10) {
            ans += " " + ONES[ten-1];
        }

        return ans.trim();
    }

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        String[] UNITS = {"", "Thousand", "Million", "Billion"};
        String ans = "";
        int i = 9;
        while (num > 0) {
            if (num >= Math.pow(10, i)) {
                int n = num / (int)Math.pow(10, i);
                ans += " " + convertThree(n) + " " + UNITS[i/3];
                num -= n * (int)Math.pow(10, i);
            }
            i -= 3;
        }
        return ans.trim();
    }

}
