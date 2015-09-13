package solutions;

import java.util.ArrayList;
import java.util.List;

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
