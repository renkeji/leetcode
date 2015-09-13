package solutions;

import junit.framework.TestCase;

import static org.junit.Assert.assertArrayEquals;

import static solutions.utils.Utils.*;

public class Q280Test extends TestCase {

    public void testWiggleSort() throws Exception {
        Q280 solution = new Q280();
        int[] t1 = {3, 5, 2, 1, 6, 4};
        solution.wiggleSort(t1);
        printArray(t1);
        assertArrayEquals(new int[] {1,3,2,5,4,6}, t1);
    }

}