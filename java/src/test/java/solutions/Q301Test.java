package solutions;

import junit.framework.TestCase;

import java.util.*;

public class Q301Test extends TestCase {

    public void testRemoveInvalidParentheses() throws Exception {
        Q301 solution = new Q301();
        String s = "()())()";
        List<String> expected = new ArrayList<>(Arrays.asList("(())()", "()()()"));
        List<String> actual = solution.removeInvalidParentheses(s);
        assertEquals(expected, actual);

        s = "(a)())()";
        expected = new ArrayList<>(Arrays.asList("(a())()", "(a)()()"));
        actual = solution.removeInvalidParentheses(s);
        assertEquals(expected, actual);

        s = ")(";
        expected = new ArrayList<>(Arrays.asList(""));
        actual = solution.removeInvalidParentheses(s);
        assertEquals(expected, actual);
    }

}