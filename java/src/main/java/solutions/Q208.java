package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Note:
 *  You may assume that all inputs are consist of lowercase letters a-z
 */

public class Q208 extends Solution {

    class TrieNode {
        // Initialize your data structure here.
        Map<Character, TrieNode> children;
        boolean isEnd;
        public TrieNode() {
            children = new HashMap<>();
            isEnd = false;
        }
    }

    public class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            if (word != null && !word.isEmpty()) {
                TrieNode node = root;
                for (int i = 0; i < word.length(); ++i) {
                    char c = word.charAt(i);
                    TrieNode child = node.children.get(c);
                    if (child == null) {
                        child = new TrieNode();
                        node.children.put(c, child);
                    }
                    if (i == word.length() - 1) {
                        child.isEnd = true;
                    }
                    node = child;
                }
            }
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            if (word != null && !word.isEmpty()) {
                TrieNode node = root;
                for (int i = 0; i < word.length(); ++i) {
                    char c = word.charAt(i);
                    if (!node.children.containsKey(c)) {
                        return false;
                    } else if (i == word.length() - 1) {
                        return node.children.get(c).isEnd;
                    } else {
                        node = node.children.get(c);
                    }
                }
            }
            return false;
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            if (prefix == null || prefix.isEmpty()) {
                return true;
            } else {
                TrieNode node = root;
                for (char c : prefix.toCharArray()) {
                    if (!node.children.containsKey(c)) {
                        return false;
                    } else {
                        node = node.children.get(c);
                    }
                }
                return true;
            }
        }
    }

}
