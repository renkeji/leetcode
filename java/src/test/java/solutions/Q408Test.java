package solutions;

import junit.framework.TestCase;

public class Q408Test extends TestCase {

    public void testValidWordAbbreviation() throws Exception {
        Q408 solution = new Q408();
        String word = "internationalization";
        String abbr = "i12iz4n";
        assertTrue(solution.validWordAbbreviation(word, abbr));

        word = "apple";
        abbr = "a2e";
        assertFalse(solution.validWordAbbreviation(word, abbr));

        word = "apple";
        abbr = "ap3";
        assertTrue(solution.validWordAbbreviation(word, abbr));
    }

}