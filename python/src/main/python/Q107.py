from src.main.python.Solution import Solution

# Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right,
# level by level from leaf to root).
#
# For example:
#   Given binary tree {3,9,20,#,#,15,7},
#       3
#      / \
#     9  20
#        / \
#      15   7
#
#   return its bottom-up level order traversal as:
#   [
#     [15,7],
#     [9,20],
#     [3]
#   ]


class Q107(Solution):
    def levelOrderBottom(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        def level_order_bottom(curr_level):
            if not curr_level:
                return []
            next_level, one = [], []
            for node in curr_level:
                one.append(node.val)
                if node.left:
                    next_level.append(node.left)
                if node.right:
                    next_level.append(node.right)
            ans = level_order_bottom(next_level)
            ans.append(one)
            return ans

        ans = []
        if root:
            ans = level_order_bottom([root])
        return ans
