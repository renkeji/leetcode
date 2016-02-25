package solutions;

import junit.framework.TestCase;
import solutions.datastructures.TreeNode;

public class Q333Test extends TestCase {

    public void testLargestBSTSubtree() throws Exception {
        Q333 solution = new Q333();
        TreeNode root = new TreeNode(1);
        assertEquals(1 , solution.largestBSTSubtree(root));
    }

}