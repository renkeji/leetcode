from src.main.python.Solution import Solution

# Given a binary tree, find the maximum path sum.
#
# For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along
# the parent-child connections. The path does not need to go through the root.
#
# For example:
#   Given the below binary tree,
#
#       1
#      / \
#     2   3
#   Return 6.


class Q124(Solution):
    def maxPathSum(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        min_value = -(1 << 31)

        def max_path_sum(root):
            if not root:
                return min_value, min_value
            left, max_left = max_path_sum(root.left)
            right, max_right = max_path_sum(root.right)
            max_sub = max(left, right)
            max_sum = max(max_left, max_right, max_sub, root.val, left+root.val+right, left+root.val, right+root.val)
            return (root.val, max_sum) if max_sub <= 0 else (max_sub + root.val, max_sum)

        return max_path_sum(root)[1]
