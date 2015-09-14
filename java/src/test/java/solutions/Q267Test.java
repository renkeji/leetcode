package solutions;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q267Test extends TestCase {

    public void testGeneratePalindromes() throws Exception {
        Q267 solution = new Q267();

        String t1 = "aabb";
        List<String> expected = new ArrayList<>(Arrays.asList("abba", "baab"));
        List<String> actual = solution.generatePalindromes(t1);
        assertEquals(expected, actual);

        String t2 = "abc";
        expected = Collections.emptyList();
        actual = solution.generatePalindromes(t2);
        assertEquals(expected, actual);

        String t3 = "a";
        expected = new ArrayList<>(Arrays.asList("a"));
        actual = solution.generatePalindromes(t3);
        assertEquals(expected, actual);
    }

}