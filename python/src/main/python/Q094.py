from src.main.python.Solution import Solution

# Given a binary tree, return the inorder traversal of its nodes' values.
#
# For example:
#   Given binary tree {1,#,2,3},
#       1
#        \
#         2
#        /
#       3
#
#   return [1,3,2].
#
# Note: Recursive solution is trivial, could you do it iteratively?


class Q094(Solution):
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        ans = []
        if root:
            stack = []
            curr = root
            while stack or curr:
                if curr:
                   stack.append(curr)
                   curr = curr.left
                else:
                    curr = stack.pop()
                    ans.append(curr.val)
                    curr = curr.right
        return ans
