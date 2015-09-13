package solutions;

import junit.framework.TestCase;

import solutions.Q271.Codec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q271Test extends TestCase {

    public void testCodec() throws Exception {
        Codec codec = new Q271().new Codec();
        List<String> strs = new ArrayList<>(Arrays.asList(
            "This is a test",
            "With * chars."
        ));
        List<String> ans = codec.decode(codec.encode(strs));
        assertEquals(strs, ans);
    }

}
