from src.main.python.Solution import Solution

# Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
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
#   return
#   [
#     [5,4,11,2],
#     [5,8,4,5]
#   ]


class Q113(Solution):
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """
        def path_sum(root, sum, path, ans):
            if not root:
                return
            remainder = sum - root.val
            path.append(root.val)
            if not root.left and not root.right:
                if remainder == 0:
                    ans.append(path[:])
            else:
                path_sum(root.left, remainder, path, ans)
                path_sum(root.right, remainder, path, ans)
            path.pop()

        ans = []
        if root:
            path_sum(root, sum, [], ans)
        return ans
