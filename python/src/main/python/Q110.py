from src.main.python.Solution import Solution

# Given a binary tree, determine if it is height-balanced.
#
# For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees
# of every node never differ by more than 1.


class Q110(Solution):
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        def get_height(node):
            if not node:
                return 0

            left = get_height(node.left)
            if left == -1:
                return -1

            right = get_height(node.right)
            if right == -1:
                return -1

            if abs(left - right) > 1:
                return -1

            return max(left, right) + 1

        return get_height(root) != -1