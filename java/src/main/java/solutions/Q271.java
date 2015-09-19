package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.
 *
 * Machine 1 (sender) has the function:
 *
 *  string encode(vector<string> strs) {
 *    // ... your code
 *    return encoded_string;
 *  }
 *
 * Machine 2 (receiver) has the function:
 *
 *  vector<string> decode(string s) {
 *    //... your code
 *    return strs;
 *  }
 *
 * So Machine 1 does:
 *  string encoded_string = encode(strs);
 *
 * and Machine 2 does:
 *  vector<string> strs2 = decode(encoded_string);
 *
 * strs2 in Machine 2 should be the same as strs in Machine 1.
 *
 * Implement the encode and decode methods.
 *
 * Note:
 *  The string may contain any possible characters out of 256 valid ascii characters. Your algorithm should be generalized enough to work on any possible characters.
 *  Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
 *  Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode algorithm.
 */

public class Q271 extends Solution {

    public class Codec {

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            String ans = "";
            for (String str: strs) {
                ans += str.replace("*", "**") + "*n";
            }
            return ans;
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            List<String> ans = new ArrayList<>();
            char[] charArray = s.toCharArray();
            int i = 0;
            while (i < charArray.length) {
                String str = "";
                while (i < charArray.length) {
                    if (charArray[i] != '*') {
                        str += charArray[i];
                        ++i;
                    } else {
                        if (charArray[i+1] == 'n') {
                            ans.add(str);
                            i += 2;
                            break;
                        } else {
                            str += '*';
                            i += 2;
                        }
                    }
                }
            }
            return ans;
        }

    }

}
