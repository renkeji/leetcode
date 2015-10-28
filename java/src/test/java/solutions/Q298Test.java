package solutions;

import junit.framework.TestCase;
import solutions.datastructures.TreeNode;

public class Q298Test extends TestCase {

    public void testLongestConsecutive() throws Exception {
        Q298 solution = new Q298();

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(5);

        n1.right = n2;
        n2.right = n3;
        n2.left = n4;
        n3.right = n5;

        int expected = 3;
        int actual = solution.longestConsecutive(n1);
        assertEquals(expected, actual);

        n1 = new TreeNode(2);
        n2 = new TreeNode(3);
        n3 = new TreeNode(2);
        n4 = new TreeNode(1);

        n1.right = n2;
        n2.left = n3;
        n3.left = n4;

        expected = 2;
        actual = solution.longestConsecutive(n1);
        assertEquals(expected, actual);
    }

}