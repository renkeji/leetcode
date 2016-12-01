package solutions;

import solutions.datastructures.Reader4;

/**
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
 * By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
 *
 * Note:
 *  The read function will only be called once for each test case.
 */

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */
public class Q157 extends Reader4 {

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
//    public int read(char[] buf, int n) {
//        int cnt = 0;
//        char[] buf4 = new char[4];
//        int readSize = read4(buf4);
//        while (cnt <= n - 4 && readSize == 4) {
//            System.arraycopy(buf4, 0, buf, cnt, 4);
//            cnt += 4;
//            readSize = read4(buf4);
//        }
//        // cnt > n - 4 || readSize < 4
//        if (cnt > n - 4) {
//            int minSize = Math.min(n - cnt, readSize);
//            System.arraycopy(buf4, 0, buf, cnt, minSize);
//            cnt += minSize;
//        } else {    // readSize < 4
//            if (readSize != 0) {
//                System.arraycopy(buf4, 0, buf, cnt, readSize);
//                cnt += readSize;
//            }
//        }
//        return cnt;
//    }

    public int read(char[] buf, int n) {
        char[] buf4 = new char[4];
        int len = 0, len4 = 0;
        for (int i = 0; i < n/4; ++i) {
            len4 = read4(buf4);
            System.arraycopy(buf4, 0, buf, len, len4);
            len += len4;
            if (len4 < 4) {
                return len;
            }
        }
        len4 = Math.min(n % 4, read4(buf4));
        System.arraycopy(buf4, 0, buf, len, len4);
        len += len4;
        return len;
    }

}
