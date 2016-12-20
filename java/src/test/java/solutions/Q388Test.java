package solutions;

import junit.framework.TestCase;

public class Q388Test extends TestCase {

    public void testLengthLongestPath() throws Exception {
        Q388 solution = new Q388();
        String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        int actual = solution.lengthLongestPath(input);
        assertEquals(32, actual);

        input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        actual = solution.lengthLongestPath(input);
        assertEquals(20, actual);
    }

}