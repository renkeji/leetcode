package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 *
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 *
 * Here is an example of version numbers ordering:
 *  0.1 < 1.1 < 1.2 < 13.37
 */

public class Q165 extends Solution {

    public int compareVersion(String version1, String version2) {
        List<String> fields1 = new ArrayList<>(Arrays.asList(version1.split("\\.")));
        List<String> fields2 = new ArrayList<>(Arrays.asList(version2.split("\\.")));
        int size1 = fields1.size();
        int size2 = fields2.size();
        if (size1 < size2) {
            for (int i = 0; i < size2-size1; ++i) {
                fields1.add("0");
            }
        } else if (size1 > size2) {
            for (int i = 0; i < size1-size2; ++i) {
                fields2.add("0");
            }
        }
        for (int i = 0; i < fields1.size(); ++i) {
            if (Integer.parseInt(fields1.get(i)) > Integer.parseInt(fields2.get(i))) {
                return 1;
            } else if (Integer.parseInt(fields1.get(i)) < Integer.parseInt(fields2.get(i))) {
                return -1;
            }
        }
        return 0;
    }

}
