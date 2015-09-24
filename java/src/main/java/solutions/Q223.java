package solutions;

/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 *
 * Each rectangle is defined by its bottom left corner and top right corner.
 *
 * Assume that the total area is never beyond the maximum possible value of int.
 */

public class Q223 extends Solution {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = Math.abs(A - C) * Math.abs(B - D);
        int area2 = Math.abs(E - G) * Math.abs(F - H);
        int ans = area1 + area2;
        if (B < H && F < D && E < C && A < G) {
            int I = A >= E ? A : E;
            int J = B >= F ? B : F;
            int K = C <= G ? C : G;
            int L = D <= H ? D : H;
            int overlapArea = Math.abs(I - K) * Math.abs(J - L);
            ans -= overlapArea;
        }
        return ans;
    }

}
