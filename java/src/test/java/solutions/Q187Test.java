package solutions;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q187Test extends TestCase {

    public void testFindRepeatedDnaSequences() throws Exception {
        Q187 solution = new Q187();
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> expected = new ArrayList<>(Arrays.asList("AAAAACCCCC", "CCCCCAAAAA"));
        List<String> actual = solution.findRepeatedDnaSequences(s);
        assertEquals(expected, actual);

        s = "AAAAAAAAAAAA";
        expected = new ArrayList<>(Arrays.asList("AAAAAAAAAA"));
        actual = solution.findRepeatedDnaSequences(s);
        assertEquals(expected, actual);
    }

}