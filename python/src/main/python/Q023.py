import heapq

from src.main.python.Solution import Solution
from src.main.python.datastructures.ListNode import ListNode

# Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.


class Q023(Solution):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        heap = []
        for list in lists:
            if list:
                heap.append((list.val, list))
        heapq.heapify(heap)
        head = ListNode(0)
        curr = head
        while heap:
            pop = heapq.heappop(heap)
            curr.next = ListNode(pop[0])
            curr = curr.next
            if pop[1].next:
                heapq.heappush(heap, (pop[1].next.val, pop[1].next))
        return head.next
