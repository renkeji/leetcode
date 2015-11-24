from src.main.python.Solution import Solution

# Given a binary tree
#
# struct TreeLinkNode {
#   TreeLinkNode *left;
#   TreeLinkNode *right;
#   TreeLinkNode *next;
# }
#
# Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
#
# Initially, all next pointers are set to NULL.
#
# Note:
#
#   You may only use constant extra space.
#   You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
#
# For example,
#   Given the following binary tree,
#       1
#      / \
#     2   3
#    / \   \
#   4   5   7
#   After calling your function, the tree should look like:
#       1 -> NULL
#      / \
#     2 ->3 -> NULL
#    / \   \
#   4-> 5 ->7 -> NULL


class Q116(Solution):
    def connect(self, root):
        """
        :type root: TreeLinkNode
        :rtype: nothing
        """
        def find_next_right(p):
            if not p.next:
                return None
            p = p.next
            while p:
                if p.left:
                    return p.left
                elif p.right:
                    return p.right
                p = p.next
            return None

        if root:
            p = root
            p.next = None
            while p:
                q = p
                while p:
                    if p.left:
                        if p.right:
                            p.left.next = p.right
                        else:
                            p.left.next = find_next_right(p)
                    if p.right:
                        p.right.next = find_next_right(p)
                    p = p.next
                if q.left:
                    p = q.left
                elif q.right:
                    p = q.right
                else:
                    p = find_next_right(q)
