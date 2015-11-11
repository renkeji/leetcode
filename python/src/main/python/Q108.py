from src.main.python.Solution import Solution
from src.main.python.datastructures.TreeNode import TreeNode

# Given an array where elements are sorted in ascending order, convert it to a height balanced BST.


class Q108(Solution):
    def sortedArrayToBST(self, nums):
        """
        :type nums: List[int]
        :rtype: TreeNode
        """
        if not nums:
            return None
        mid = len(nums)//2
        node = TreeNode(nums[mid])
        node.left = self.sortedArrayToBST(nums[:mid])
        node.right = self.sortedArrayToBST(nums[mid+1:])
        return node
