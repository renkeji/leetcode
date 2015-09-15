package solutions;

import junit.framework.TestCase;
import solutions.datastructures.TreeNode;

public class Q250Test extends TestCase {

    public void testCountUnivalSubtrees() throws Exception {
        Q250 solution = new Q250();

        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(5);

        n1.left = n2;
        n2.left = n3;
        n2.right = n4;
        n1.right = n5;
        n5.right = n6;

        int actual = solution.countUnivalSubtrees(n1);
        assertEquals(4, actual);
    }

}