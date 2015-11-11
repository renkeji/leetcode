from src.main.python.Solution import Solution
from src.main.python.datastructures import TreeNode

# Given an array where elements are sorted in ascending order, convert it to a height balanced BST.


class Q108(Solution):
    def sortedArrayToBST(self, nums):
        """
        :type nums: List[int]
        :rtype: TreeNode
        """
        def sorted_array_to_bst(nums, left, right):
            if left > right:
                return None
            mid = left + (right-left)//2
            node = TreeNode(nums[mid])
            node.left = sorted_array_to_bst(nums, left, mid-1)
            node.right = sorted_array_to_bst(nums, mid+1, right)
            return node

        root = None
        if nums:
            root = sorted_array_to_bst(nums, 0, len(nums)-1)
        return root
