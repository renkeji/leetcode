from src.main.python.Solution import Solution
from src.main.python.datastructures.TreeNode import TreeNode

# Given a binary tree, flatten it to a linked list in-place.
#
# For example,
# Given
#
#       1
#      / \
#     2   5
#    / \   \
#   3   4   6
#
# The flattened tree should look like:
#
#   1
#    \
#     2
#      \
#       3
#        \
#         4
#          \
#           5
#            \
#             6


class Q114(Solution):
    def flatten(self, root):
        """
        :type root: TreeNode
        :rtype: void Do not return anything, modify root in-place instead.
        """
        def find_node(node):
            if not node.left and not node.right:
                return node
            if node.right:
                return find_node(node.right)
            else:
                return find_node(node.left)

        if root:
            while root.left or root.right:
                if root.left:
                    node = find_node(root.left)
                    node.right = root.right
                    root.right = root.left
                    root.left = None
                root = root.right
