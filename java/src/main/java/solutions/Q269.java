package solutions;

import java.util.*;

/**
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you.
 * You receive a list of words from the dictionary, where words are sorted lexicographically by the rules of this new language.
 * Derive the order of letters in this language.
 *
 * For example,
 *  Given the following words in dictionary,
 *  [
 *      "wrt",
 *      "wrf",
 *      "er",
 *      "ett",
 *      "rftt"
 *  ]
 *
 *  The correct order is: "wertf".
 *
 * Note:
 *  You may assume all letters are in lowercase.
 *  If the order is invalid, return an empty string.
 *  There may be multiple valid order of letters, return any one of them is fine.
 */

public class Q269 extends Solution {

    private final int N = 26;

    public String alienOrder(String[] words) {
        boolean[][] adj = new boolean[N][N];
        int[] visited = new int[N];
        buildGraph(words, adj, visited);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; ++i) {
            if (visited[i] == 0) {                 // unvisited
                if (!dfs(adj, visited, sb, i)) return "";
            }
        }
        return sb.reverse().toString();
    }

    public boolean dfs(boolean[][] adj, int[] visited, StringBuilder sb, int i) {
        visited[i] = 1;                            // 1 = visiting
        for (int j = 0; j < N; ++j) {
            if (adj[i][j]) {                        // connected
                if (visited[j] == 1) return false;  // 1 => 1, cycle
                if (visited[j] == 0) {              // 0 = unvisited
                    if (!dfs(adj, visited, sb, j)) return false;
                }
            }
        }
        visited[i] = 2;                           // 2 = visited
        sb.append((char) (i + 'a'));
        return true;
    }

    public void buildGraph(String[] words, boolean[][] adj, int[] visited) {
        Arrays.fill(visited, -1);                 // -1 = not even existed
        for (int i = 0; i < words.length; ++i) {
            for (char c : words[i].toCharArray()) visited[c - 'a'] = 0;
            if (i > 0) {
                String w1 = words[i - 1], w2 = words[i];
                int len = Math.min(w1.length(), w2.length());
                for (int j = 0; j < len; ++j) {
                    char c1 = w1.charAt(j), c2 = w2.charAt(j);
                    if (c1 != c2) {
                        adj[c1 - 'a'][c2 - 'a'] = true;
                        break;
                    }
                }
            }
        }
    }

}
