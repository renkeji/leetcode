package solutions;

import junit.framework.TestCase;
import solutions.datastructures.TreeNode;

public class Q285Test extends TestCase {

    public void testInorderSuccessor() throws Exception {
        Q285 solution = new Q285();
        TreeNode n1 = new TreeNode(10);
        TreeNode p = new TreeNode(8);
        TreeNode expected = n1;
        TreeNode actual = solution.inorderSuccessor(n1, p);
        assertEquals(expected, actual);

        p = new TreeNode(12);
        actual = solution.inorderSuccessor(n1, p);
        assertNull(actual);

        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(8);
        TreeNode n5 = new TreeNode(12);
        TreeNode n6 = new TreeNode(15);

        n1.left = n2;
        n1.right = n5;
        n2.left = n3;
        n2.right = n4;
        n5.right = n6;

        p = new TreeNode(7);
        expected = n4;
        actual = solution.inorderSuccessor(n1, p);
        assertEquals(expected, actual);

        p = new TreeNode(9);
        expected = n1;
        actual = solution.inorderSuccessor(n1, p);
        assertEquals(expected, actual);

        p = new TreeNode(13);
        expected = n6;
        actual = solution.inorderSuccessor(n1, p);
        assertEquals(expected, actual);

        p = new TreeNode(20);
        actual = solution.inorderSuccessor(n1, p);
        assertNull(actual);
    }

}