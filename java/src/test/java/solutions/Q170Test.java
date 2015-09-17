package solutions;

import junit.framework.TestCase;
import solutions.Q170.TwoSum;

public class Q170Test extends TestCase {

    public void testFind() throws Exception {
        TwoSum twoSum = new Q170().new TwoSum();

        twoSum.add(1);
        twoSum.add(3);
        twoSum.add(5);

        boolean isFound = twoSum.find(4);
        assertTrue(isFound);

        isFound = twoSum.find(7);
        assertFalse(isFound);
    }

}