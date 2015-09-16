package solutions;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q247Test extends TestCase {

    public void testFindStrobogrammatic() throws Exception {
        Q247 solution = new Q247();

        int n = 1;
        List<String> expected = new ArrayList<>(Arrays.asList("0", "1", "8"));
        List<String> actual = solution.findStrobogrammatic(n);
        assertEquals(expected, actual);

        n = 2;
        expected = new ArrayList<>(Arrays.asList("11", "69", "88", "96"));
        actual = solution.findStrobogrammatic(n);
        assertEquals(expected, actual);
    }

}