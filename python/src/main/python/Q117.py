from src.main.python.Solution import Solution

# Follow up for problem "Populating Next Right Pointers in Each Node".
#
# What if the given tree could be any binary tree? Would your previous solution still work?
#
# Note:
#
#   You may only use constant extra space.
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


class Q117(Solution):
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
