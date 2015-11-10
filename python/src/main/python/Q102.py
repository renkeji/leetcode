from src.main.python.Solution import Solution

# Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
#
# For example:
# Given binary tree {3,9,20,#,#,15,7},
#       3
#      / \
#     9  20
#        / \
#      15   7
#
# return its level order traversal as:
#   [
#     [3],
#     [9,20],
#     [15,7]
#   ]


class Q102(Solution):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        def populate_next(node, next):
            if node.left:
                next.append(node.left)
            if node.right:
                next.append(node.right)
            return node.val

        ans = []
        if root:
            curr, next = [root], []
            while curr:
                level = [populate_next(node, next) for node in curr if node]
                ans.append(level)
                curr, next = next, []
        return ans
