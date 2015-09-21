package solutions;

import junit.framework.TestCase;
import solutions.datastructures.TreeNode;

public class Q236Test extends TestCase {

    public void testLowestCommonAncestor() throws Exception {
        Q236 solution = new Q236();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;

        TreeNode p = node2;
        TreeNode q = node3;

        TreeNode expected = node1;
        TreeNode actual = solution.lowestCommonAncestor(node1, p, q);
        assertEquals(expected, actual);
    }

}