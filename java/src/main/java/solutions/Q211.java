package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Design a data structure that supports the following two operations:
 *
 *  void addWord(word)
 *  bool search(word)
 *
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 *
 * For example:
 *  addWord("bad")
 *  addWord("dad")
 *  addWord("mad")
 *  search("pad") -> false
 *  search("bad") -> true
 *  search(".ad") -> true
 *  search("b..") -> true
 *
 * Note:
 *  You may assume that all words are consist of lowercase letters a-z.
 */

public class Q211 extends Solution {

    public class WordDictionary {

        private class TrieNode {
            Map<Character, TrieNode> children;
            boolean isEnd;
            TrieNode() {
                children = new HashMap<>();
            }
        }

        private TrieNode root;

        public WordDictionary() {
            root = new TrieNode();
        }

        // Adds a word into the data structure.
        public void addWord(String word) {
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

        // Returns if the word is in the data structure. A word could
        // contain the dot character '.' to represent any one letter.
        public boolean search(String word) {
            return word != null && !word.isEmpty() && search(root, word);
        }

        private boolean search(TrieNode node, String word) {
            if (word.isEmpty()) {
                return node.isEnd;
            } else {
                char c = word.charAt(0);
                if (c == '.') {
                    for (TrieNode child : node.children.values()) {
                        if (search(child, word.substring(1))) {
                            return true;
                        }
                    }
                    return false;
                } else {
                    return node.children.containsKey(c) && search(node.children.get(c), word.substring(1));
                }
            }
        }

    }

}
