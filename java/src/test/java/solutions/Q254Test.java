package solutions;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q254Test extends TestCase {

    public void testGetFactors() throws Exception {
        Q254 solution = new Q254();

        int n = 12;
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(Arrays.asList(2, 2, 3)));
        expected.add(new ArrayList<>(Arrays.asList(2, 6)));
        expected.add(new ArrayList<>(Arrays.asList(3, 4)));
        List<List<Integer>> actual = solution.getFactors(n);
        assertEquals(expected, actual);

        n = 32;
        expected.clear();
        expected.add(new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2)));
        expected.add(new ArrayList<>(Arrays.asList(2, 2, 2, 4)));
        expected.add(new ArrayList<>(Arrays.asList(2, 2, 8)));
        expected.add(new ArrayList<>(Arrays.asList(2, 4, 4)));
        expected.add(new ArrayList<>(Arrays.asList(2, 16)));
        expected.add(new ArrayList<>(Arrays.asList(4, 8)));
        actual = solution.getFactors(n);
        assertEquals(expected, actual);
    }

}