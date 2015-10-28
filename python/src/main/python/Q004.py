from src.main.python.Solution import Solution

# There are two sorted arrays nums1 and nums2 of size m and n respectively.
# Find the median of the two sorted arrays.
# The overall run time complexity should be O(log (m+n)).


class Q004(Solution):
    def get_kth(self, A, B, k):
        len_a, len_b = len(A), len(B)
        if len_a > len_b:
            return self.get_kth(B, A, k)
        if len_a == 0:
            return B[k - 1]
        if k == 1:
            return min(A[0], B[0])
        pa = min(k/2, len_a)
        pb = k - pa
        if A[pa - 1] <= B[pb - 1]:
            return self.get_kth(A[pa:], B, pb)
        else:
            return self.get_kth(A, B[pb:], pa)


    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        len_a, len_b = len(nums1), len(nums2)
        if (len_a + len_b) % 2 == 1:
            return self.get_kth(nums1, nums2, (len_a + len_b)/2 + 1)
        else:
            return 0.5 * (self.get_kth(nums1, nums2, (len_a + len_b)/2) +
                          self.get_kth(nums1, nums2, (len_a + len_b)/2 + 1))
