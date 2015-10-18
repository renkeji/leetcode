package solutions;

import junit.framework.TestCase;

public class Q166Test extends TestCase {

    public void testFractionToDecimal() throws Exception {
        Q166 solution = new Q166();
        int numerator = 10;
        int denominator = 3;
        String expected = "3.(3)";
        String actual = solution.fractionToDecimal(numerator, denominator);
        assertEquals(expected, actual);

        numerator = 1;
        denominator = 2;
        expected = "0.5";
        actual = solution.fractionToDecimal(numerator, denominator);
        assertEquals(expected, actual);

        numerator = 2;
        denominator = 1;
        expected = "2";
        actual = solution.fractionToDecimal(numerator, denominator);
        assertEquals(expected, actual);

        numerator = 2;
        denominator = 3;
        expected = "0.(6)";
        actual = solution.fractionToDecimal(numerator, denominator);
        assertEquals(expected, actual);

        numerator = 37;
        denominator = 99;
        expected = "0.(37)";
        actual = solution.fractionToDecimal(numerator, denominator);
        assertEquals(expected, actual);

        numerator = 1;
        denominator = 99;
        expected = "0.(01)";
        actual = solution.fractionToDecimal(numerator, denominator);
        assertEquals(expected, actual);

        numerator = -1;
        denominator = -2147483648;
        expected = "0.0000000004656612873077392578125";
        actual = solution.fractionToDecimal(numerator, denominator);
        assertEquals(expected, actual);

        numerator = -2147483648;
        denominator = -1;
        expected = "2147483648";
        actual = solution.fractionToDecimal(numerator, denominator);
        assertEquals(expected, actual);

        numerator = -50;
        denominator = 8;
        expected = "-6.25";
        actual = solution.fractionToDecimal(numerator, denominator);
        assertEquals(expected, actual);
    }

}