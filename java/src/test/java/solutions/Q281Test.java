package solutions;

import junit.framework.TestCase;
import solutions.Q281.ZigzagIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class Q281Test extends TestCase {

    public void testZigzagIterator() throws Exception {
        List<Integer> v1 = new ArrayList<Integer>(Arrays.asList(1, 2));
        List<Integer> v2 = new ArrayList<Integer>(Arrays.asList(3, 4, 5, 6));
        ZigzagIterator zigzagIterator = new Q281().new ZigzagIterator(v1, v2);
        int[] s1 = new int[v1.size() + v2.size()];
        int i = 0;
        while (zigzagIterator.hasNext()) {
            s1[i++] = zigzagIterator.next();
        }
        assertArrayEquals(new int[] {1, 3, 2, 4, 5, 6}, s1);
    }

}