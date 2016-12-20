package solutions;

import java.util.Stack;

/**
 * Suppose we abstract our file system by a string in the following manner:
 *
 * The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:
 *
 *  dir
 *      subdir1
 *      subdir2
 *          file.ext
 *
 * The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.
 *
 * The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:
 *
 *  dir
 *      subdir1
 *          file1.ext
 *          subsubdir1
 *      subdir2
 *          subsubdir2
 *          file2.ext
 *
 * The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1.
 * subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.
 *
 * We are interested in finding the longest (number of characters) absolute path to a file within our file system. For example,
 * in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).
 *
 * Given a string representing the file system in the above format, return the length of the longest absolute path to file in the abstracted file system. If there is no file in the system, return 0.
 *
 * Note:
 *  1. The name of a file contains at least a . and an extension.
 *  2. The name of a directory or sub-directory will not contain a ..
 *
 * Time complexity required: O(n) where n is the size of the input string.
 *
 * Notice that a/aa/aaa/file1.txt is not the longest file path, if there is another path aaaaaaaaaaaaaaaaaaaaa/sth.png.
 */

public class Q388 extends Solution {

    public int lengthLongestPath(String input) {
        String[] paths = input.split("\n");
        int[] stack = new int[paths.length + 1];
        int maxLen = 0;
        for (String path : paths) {
            int level = path.lastIndexOf("\t") + 1;
            int curLen = stack[level + 1] = stack[level] + path.length() - level + 1;
            if (path.contains(".")) {
                maxLen = Math.max(maxLen, curLen - 1);
            }
        }
        return maxLen;
    }

//    public int lengthLongestPath(String input) {
//        int max = 0;
//        if (input != null && !input.isEmpty()) {
//            int level = 0;
//            char[] inputChars = input.toCharArray();
//            Stack<String> stack = new Stack<>();
//            StringBuilder sb = new StringBuilder();
//            boolean isFile = extractDirOrFileName(inputChars, 0, sb);
//            stack.push(sb.toString());
//            int pathLength = sb.length();
//            if (isFile) {
//                max = pathLength;
//            } else {
//                int i = pathLength;
//                while (i != inputChars.length) {
//                    int currLevel = determineLevel(inputChars, i);
//                    i += currLevel + 1;
//                    sb.setLength(0);
//                    isFile = extractDirOrFileName(inputChars, i, sb);
//                    String name = sb.toString();
//                    while (!stack.isEmpty() && currLevel <= level) {
//                        String top = stack.pop();
//                        level--;
//                        pathLength -= (top.length() + 1);
//                    }
//                    stack.push(name);
//                    pathLength += name.length() + 1;
//                    if (isFile) {
//                        max = Math.max(max, pathLength);
//                    }
//                    level = currLevel;
//                    i += name.length();
//                }
//            }
//        }
//        return max;
//    }
//
//    private boolean extractDirOrFileName(char[] input, int start, StringBuilder sb) {
//        int i = start;
//        boolean isFile = false;
//        while (i != input.length && input[i] != '\n') {
//            char ch = input[i++];
//            if (ch == '.') {
//                isFile = true;
//            }
//            sb.append(ch);
//        }
//        return isFile;
//    }
//
//    private int determineLevel(char[] input, int start) {
//        int level = 0;
//        int i = start;
//        while (i != input.length && (input[i] == '\t' || input[i] == '\n')) {
//            if (input[i++] == '\t') {
//                level++;
//            }
//        }
//        return level;
//    }

}
