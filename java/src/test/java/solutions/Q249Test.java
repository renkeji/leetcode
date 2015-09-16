package solutions;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q249Test extends TestCase {

    public void testGroupStrings() throws Exception {
        Q249 solution = new Q249();

        String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        List<List<String>> expected = new ArrayList<>();
        expected.add(Arrays.asList("a","z"));
        expected.add(Arrays.asList("abc","bcd","xyz"));
        expected.add(Arrays.asList("acef"));
        expected.add(Arrays.asList("az","ba"));
        List<List<String>> actual = solution.groupStrings(strings);
        assertEquals(expected, actual);
    }

}