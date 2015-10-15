package solutions;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.List;

public class Q293Test extends TestCase {

    public void testGeneratePossibleNextMoves() throws Exception {
        Q293 solution = new Q293();
        String s = "++++";
        List<String> expected = Arrays.asList("--++", "+--+", "++--");
        List<String> actual = solution.generatePossibleNextMoves(s);
        assertEquals(expected, actual);
    }

}