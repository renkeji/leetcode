from src.main.python.Solution import Solution

# Two elements of a binary search tree (BST) are swapped by mistake.
#
# Recover the tree without changing its structure.
#
# Note:
#   A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?


class Q099(Solution):
    def recoverTree(self, root):
        """
        :type root: TreeNode
        :rtype: void Do not return anything, modify root in-place instead.
        """
        __class = self.__class__

        def recover_tree(root):
            if not root or __class.cnt == 2:
                return
            recover_tree(root.left)
            if __class.prev is not None and __class.prev.val > root.val:
                if __class.cnt == 0:
                    __class.n1 = __class.prev
                __class.n2 = root
                __class.cnt += 1
            __class.prev = root
            recover_tree(root.right)

        __class.prev, __class.n1, __class.n2, __class.cnt = None, None, None, 0
        recover_tree(root)
        __class.n1.val, __class.n2.val = __class.n2.val, __class.n1.val
