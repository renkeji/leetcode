package solutions;

import junit.framework.TestCase;
import solutions.Q211.WordDictionary;

public class Q211Test extends TestCase {

    public void testWordDictionary() throws Exception {
        Q211 solution = new Q211();
        WordDictionary wordDictionary = solution.new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        assertFalse(wordDictionary.search("pad"));
        assertTrue(wordDictionary.search("bad"));
        assertTrue(wordDictionary.search(".ad"));
        assertTrue(wordDictionary.search("b.."));
    }

}
