package solutions;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q241Test extends TestCase {

    public void testDiffWaysToCompute() throws Exception {
        Q241 solution = new Q241();
        String input = "2-1-1";
        List<Integer> expected = new ArrayList<>(Arrays.asList(2, 0));
        List<Integer> actual = solution.diffWaysToCompute(input);
        assertEquals(expected, actual);

        input = "2*3-4*5";
        expected = new ArrayList<>(Arrays.asList(-34, -10, -14, -10, 10));
        actual = solution.diffWaysToCompute(input);
        assertEquals(expected, actual);

        input = "11";
        expected = new ArrayList<>(Arrays.asList(11));
        actual = solution.diffWaysToCompute(input);
        assertEquals(expected, actual);
    }

}