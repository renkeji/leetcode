package solutions;

import junit.framework.TestCase;
import solutions.Q288.ValidWordAbbr;

public class Q288Test extends TestCase {

    public void testIsUnique() throws Exception {
        String[] dictionary = {"deer", "door", "cake", "card"};
        ValidWordAbbr validWordAbbr = (new Q288()).new ValidWordAbbr(dictionary);
        assertFalse(validWordAbbr.isUnique("dear"));
        assertTrue(validWordAbbr.isUnique("cart"));
        assertFalse(validWordAbbr.isUnique("cane"));
        assertTrue(validWordAbbr.isUnique("make"));
    }

}
