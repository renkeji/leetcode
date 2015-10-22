package solutions;

import junit.framework.TestCase;
import solutions.Q208.Trie;

public class Q208Test extends TestCase {

    public void testTrie() throws Exception {
        Q208 solution = new Q208();
        Trie trie = solution.new Trie();
        trie.insert("abc");
        assertTrue(trie.search("abc"));
        assertFalse(trie.search("a"));
        trie.insert("ab");
        assertTrue(trie.search("ab"));
        trie.insert("ab");
        assertTrue(trie.search("ab"));
    }

}