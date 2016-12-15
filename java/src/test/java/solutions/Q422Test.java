package solutions;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.List;

public class Q422Test extends TestCase {

    public void testValidWordSquare() throws Exception {
        Q422 solution = new Q422();
        List<String> words = Arrays.asList("abcd", "bnrt", "crmy", "dtye");
        assertTrue(solution.validWordSquare(words));

        words = Arrays.asList("abcd", "bnrt", "crm", "dt");
        assertTrue(solution.validWordSquare(words));

        words = Arrays.asList("ball", "area", "read", "lady");
        assertFalse(solution.validWordSquare(words));
    }

}