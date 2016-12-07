package solutions;

import junit.framework.TestCase;

import static org.junit.Assert.assertArrayEquals;

public class Q399Test extends TestCase {

    public void testCalcEquation() throws Exception {
        Q399 solution = new Q399();
        String[][] equations = {
            {"a", "b"},
            {"b", "c"}
        };
        double[] values = {2.0, 3.0};
        String[][] queries = {
            {"a", "c"},
            {"b", "a"},
            {"a", "e"},
            {"a", "a"},
            {"x", "x"}
        };
        double[] actual = solution.calcEquation(equations, values, queries);
        double[] expected = {6.0, 0.5, -1.0, 1.0, -1.0};
        assertArrayEquals(expected, actual, Double.MIN_VALUE);
    }

}