from src.main.python.Solution import Solution
from src.main.python.datastructures.TreeNode import TreeNode

# Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.


class Q109(Solution):
    def sortedListToBST(self, head):
        """
        :type head: ListNode
        :rtype: TreeNode
        """
        def count_nodes(head):
            cnt = 0
            while head:
                cnt += 1
                head = head.next
            return cnt

        def sorted_list_to_bst(left, right):
            if left > right:
                return None
            mid = left + (right-left)//2
            left_node = sorted_list_to_bst(left, mid-1)
            new_node = TreeNode(self.head.val)
            new_node.left = left_node
            self.head = self.head.next
            new_node.right = sorted_list_to_bst(mid+1, right)
            return new_node

        root = None
        if head:
            self.head = head
            cnt = count_nodes(head)
            root = sorted_list_to_bst(0, cnt-1)
        return root
