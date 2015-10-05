package solutions;

import junit.framework.TestCase;
import solutions.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q199Test extends TestCase {

    public void testRightSideView() throws Exception {
        Q199 solution = new Q199();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n2.right= n5;
        n3.right = n4;

        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 3, 4));
        List<Integer> actual = solution.rightSideView(n1);
        assertEquals(expected, actual);
    }

}