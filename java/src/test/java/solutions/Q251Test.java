package solutions;

import junit.framework.TestCase;
import solutions.Q251.Vector2D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q251Test extends TestCase {

    public void testMinMeetingRooms() throws Exception {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>(Arrays.asList(1, 2)));
        lists.add(new ArrayList<>(Arrays.asList(3)));
        lists.add(new ArrayList<>(Arrays.asList(4, 5, 6)));
        Vector2D vector2D = new Q251().new Vector2D(lists);
        List<Integer> actual = new ArrayList<>(6);
        while (vector2D.hasNext()) {
            actual.add(vector2D.next());
        }
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertEquals(expected, actual);

        lists.clear();
        lists.add(new ArrayList<>(Arrays.asList(1)));
        lists.add(Collections.<Integer>emptyList());
        vector2D = new Q251().new Vector2D(lists);
        actual = new ArrayList<>(1);
        while (vector2D.hasNext()) {
            actual.add(vector2D.next());
        }
        expected = new ArrayList<>(Arrays.asList(1));
        assertEquals(expected, actual);

        lists.clear();
        lists.add(new ArrayList<>(Arrays.asList(1, 2)));
        lists.add(Collections.<Integer>emptyList());
        lists.add(new ArrayList<>(Arrays.asList(3, 4)));
        vector2D = new Q251().new Vector2D(lists);
        actual = new ArrayList<>(1);
        while (vector2D.hasNext()) {
            actual.add(vector2D.next());
        }
        expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        assertEquals(expected, actual);
    }

}