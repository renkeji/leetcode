package solutions;

import solutions.datastructures.Reader4;

/**
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
 * By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
 *
 * Note:
 *  The read function may be called multiple times.
 */

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */
public class Q158 extends Reader4 {

//    private char[] buf4 = new char[4];
//    private int currIndex = 0;
//    private int lastReadSize = 0;

//    /**
//     * @param buf Destination buffer
//     * @param n   Maximum number of characters to read
//     * @return    The number of characters read
//     */
//    public int read(char[] buf, int n) {
//        int cnt = 0;
//        while (cnt < n) {
//            if (currIndex == lastReadSize) {
//                lastReadSize = read4(buf4);
//                currIndex = 0;
//            }
//            if (lastReadSize == 0) {
//                break;
//            } else {
//                int len = lastReadSize - currIndex;
//                if (n - cnt < 4 || lastReadSize < 4) {
//                    len = Math.min(lastReadSize - currIndex, n - cnt);
//                }
//                System.arraycopy(buf4, currIndex, buf, cnt, len);
//                currIndex += len;
//                cnt += len;
//            }
//        }
//        return cnt;
//    }

    private char[] buf4 = new char[4];
    private int len4 = 0;
    private int index4 = 0;

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int len = 0;
        while (n != 0) {
            if (len4 == 0) {
                len4 = read4(buf4);
                index4 = 0;
            }
            int size = Math.min(n, len4);
            if (size == 0) {
                return len;
            } else {
                System.arraycopy(buf4, index4, buf, len, size);
                n -= size;
                len4 -= size;
                len += size;
                index4 += size;
            }
        }
        return len;
    }

}
