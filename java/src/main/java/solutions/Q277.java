package solutions;

public class Q277 extends Solution {

    // mock method
    private boolean knows(int a, int b) {
        return a < b;
    }

    public int findCelebrity(int n) {
        if (n <= 0) {
            return -1;
        }
        int celebrity = 0;
        for (int i = 1; i < n; ++i) {
            if (knows(celebrity, i)) {
                celebrity = i;
            }
        }
        for (int i = 0; i < n; ++i) {
            if ( i != celebrity && (knows(celebrity, i) || !knows(i, celebrity)) ) {
                return -1;
            }
        }
        return celebrity;
    }

}
