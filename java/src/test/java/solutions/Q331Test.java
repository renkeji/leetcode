package solutions;

import junit.framework.TestCase;

public class Q331Test extends TestCase {

    public void testIsValidSerialization() throws Exception {
        Q331 solution = new Q331();
        String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        assertTrue(solution.isValidSerialization(preorder));

        preorder = "1,#";
        assertFalse(solution.isValidSerialization(preorder));

        preorder = "9,#,#,1";
        assertFalse(solution.isValidSerialization(preorder));

        preorder = "9,3,4,#,#,1,#,#,#,2,#,6,#,#";
        assertFalse(solution.isValidSerialization(preorder));
    }

}