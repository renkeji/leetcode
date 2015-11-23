from src.main.python.Solution import Solution

# Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along
# the path equals the given sum.
#
# For example:
#   Given the below binary tree and sum = 22,
#           5
#          / \
#         4   8
#        /   / \
#       11  13  4
#      /  \      \
#     7    2      1
#   return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.


class Q112(Solution):
    def hasPathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: bool
        """
        if not root:
            return False
        remainder = sum - root.val
        if not root.left and not root.right:
            return remainder == 0
        else:
            return self.hasPathSum(root.left, remainder) or self.hasPathSum(root.right, remainder)
