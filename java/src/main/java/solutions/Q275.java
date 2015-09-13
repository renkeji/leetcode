package solutions;

public class Q275 extends Solution {

    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int left = 0, right = citations.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[citations.length - mid - 1] >= mid + 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

}
