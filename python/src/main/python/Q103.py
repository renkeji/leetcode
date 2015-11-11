from src.main.python.Solution import Solution

# Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right,
# then right to left for the next level and alternate between).
#
# For example:
#   Given binary tree {3,9,20,#,#,15,7},
#       3
#      / \
#     9  20
#        / \
#      15   7
#
#   return its zigzag level order traversal as:
#   [
#     [3],
#     [20,9],
#     [15,7]
#   ]


class Q103(Solution):
    def zigzagLevelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        ans = []
        if root:
            curr, next = [root], []
            left_to_right = True
            while curr:
                level = []
                while curr:
                    node = curr.pop()
                    level.append(node.val)
                    if left_to_right:
                        if node.left:
                            next.append(node.left)
                        if node.right:
                            next.append(node.right)
                    else:
                        if node.right:
                            next.append(node.right)
                        if node.left:
                            next.append(node.left)
                ans.append(level)
                curr, next = next, []
                left_to_right = not left_to_right
        return ans
