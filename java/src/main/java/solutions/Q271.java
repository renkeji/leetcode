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
                StringBuilder sb = new StringBuilder();
                while (i < charArray.length) {
                    if (charArray[i] != '*') {
                        sb.append(charArray[i]);
                        ++i;
                    } else {
                        if (charArray[i+1] == 'n') {
                            ans.add(sb.toString());
                            i += 2;
                            break;
                        } else {
                            sb.append('*');
                            i += 2;
                        }
                    }
                }
            }
            return ans;
        }

    }

}
