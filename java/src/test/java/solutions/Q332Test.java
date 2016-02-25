package solutions;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q332Test extends TestCase {

    public void testFindItinerary() throws Exception {
        Q332 solution = new Q332();
        String[][] tickets = new String[][] {
            {"MUC", "LHR"},
            {"JFK", "MUC"},
            {"SFO", "SJC"},
            {"LHR", "SFO"}
        };
        List<String> expected = new ArrayList<>(Arrays.asList("JFK", "MUC", "LHR", "SFO", "SJC"));
        List<String> actual = solution.findItinerary(tickets);
        assertEquals(actual, expected);

        tickets = new String[][] {
            {"JFK", "SFO"},
            {"JFK", "ATL"},
            {"SFO", "ATL"},
            {"ATL", "JFK"},
            {"ATL", "SFO"}
        };
        expected = new ArrayList<>(Arrays.asList("JFK", "ATL", "JFK", "SFO", "ATL", "SFO"));
        actual = solution.findItinerary(tickets);
        assertEquals(actual, expected);

        tickets = new String[][] {
            {"JFK", "KUL"},
            {"JFK", "NRT"},
            {"NRT", "JFK"}
        };
        expected = new ArrayList<>(Arrays.asList("JFK", "NRT", "JFK", "KUL"));
        actual = solution.findItinerary(tickets);
        assertEquals(actual, expected);
    }

}