package solutions;

/**
 * An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel.
 * The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically.
 * Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.
 *
 * For example, given the following image:
 *
 *  [
 *      "0010",
 *      "0110",
 *      "0100"
 *  ]
 *
 *  and x = 0, y = 2,
 *  Return 6.
 */

public class Q302 extends Solution {

    private class Boundary {
        int up;
        int down;
        int left;
        int right;
        Boundary(int up, int down, int left, int right) {
            this.up = up;
            this.down = down;
            this.left = left;
            this.right = right;
        }
    }

    public int minArea(char[][] image, int x, int y) {
        Boundary boundary = getBoundary(image, x, y, new boolean[image.length][image[0].length]);
        int area = 0;
        if (boundary != null) {
            int height = boundary.down - boundary.up + 1;
            int width = boundary.right - boundary.left + 1;
            area = height * width;
        }
        return area;
    }

    private Boundary getBoundary(char[][] image, int x, int y, boolean[][] visited) {
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] != '1' || visited[x][y]) {
            return null;
        } else {
            visited[x][y] = true;
            Boundary boundary = new Boundary(x, x, y, y);
            Boundary upBoundary = getBoundary(image, x-1, y, visited);
            Boundary downBoundary = getBoundary(image, x+1, y, visited);
            Boundary leftBoundary = getBoundary(image, x, y-1, visited);
            Boundary rightBoundary = getBoundary(image, x, y+1, visited);
            if (upBoundary != null) {
                boundary = updateBoundary(upBoundary, boundary);
            }
            if (downBoundary != null) {
                boundary = updateBoundary(downBoundary, boundary);
            }
            if (leftBoundary != null) {
                boundary = updateBoundary(leftBoundary, boundary);
            }
            if (rightBoundary != null) {
                boundary = updateBoundary(rightBoundary, boundary);
            }
            return boundary;
        }
    }

    private Boundary updateBoundary(Boundary b1, Boundary b2) {
        int up = Math.min(b1.up, b2.up);
        int down = Math.max(b1.down, b2.down);
        int left = Math.min(b1.left, b2.left);
        int right = Math.max(b1.right, b2.right);
        return new Boundary(up, down, left, right);
    }

}
