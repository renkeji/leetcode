package solutions;

import junit.framework.TestCase;

public class Q273Test extends TestCase {

    private Q273 solution;

    public void setUp() {
        solution = new Q273();
    }

    public void testConvertThree() throws Exception {
        int n1 = 123;
        String s1 = solution.convertThree(n1);
        assertEquals("One Hundred Twenty Three", s1);

        int n2 = 345;
        String s2 = solution.convertThree(n2);
        assertEquals("Three Hundred Forty Five", s2);

        int n3 = 20;
        String s3 = solution.convertThree(n3);
        assertEquals("Twenty", s3);

        int n4 = 100;
        String s4 = solution.convertThree(n4);
        assertEquals("One Hundred", s4);
    }

    public void testNumberToWords() throws Exception {
        int n1 = 123;
        String s1 = solution.numberToWords(n1);
        assertEquals("One Hundred Twenty Three", s1);

        int n2 = 12345;
        String s2 = solution.numberToWords(n2);
        assertEquals("Twelve Thousand Three Hundred Forty Five", s2);

        int n3 = 1234567;
        String s3 = solution.numberToWords(n3);
        assertEquals("One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven", s3);
    }
}