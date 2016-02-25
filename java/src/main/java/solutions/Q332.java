package solutions;

import java.util.*;

/**
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to],
 * reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 *
 * Note:
 *  1. If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.
 *     For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 *  2. All airports are represented by three capital letters (IATA code).
 *  3. You may assume all tickets form at least one valid itinerary.
 *
 * Example 1:
 *  tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 *  Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
 *
 * Example 2:
 *  tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 *  Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
 *  Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
 */

public class Q332 extends Solution {

    public List<String> findItinerary(String[][] tickets) {
        List<String> ans = new ArrayList<>();
        if (tickets != null && tickets.length != 0 && tickets[0].length != 0) {
            Map<String, List<Pair>> hm = buildMap(tickets);
            String from = "JFK";
            ans.add("JFK");
            int numTickets = tickets.length;
            canFormTrip(numTickets, from, hm, ans);
        }
        return ans;
    }

    private class Pair {
        String name;
        boolean visited;
        public Pair(String name) {
            this.name = name;
            visited = false;
        }
    }

    private Map<String, List<Pair>> buildMap(String[][] tickets) {
        Map<String, List<Pair>> hm = new HashMap<>();
        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];
            if (!hm.containsKey(from)) {
                hm.put(from, new ArrayList<Pair>());
            }
            hm.get(from).add(new Pair(to));
        }
        for (Map.Entry<String, List<Pair>> entry : hm.entrySet()) {
            Collections.sort(entry.getValue(), new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    return o1.name.compareTo(o2.name);
                }
            });
        }
        return hm;
    }

    private boolean canFormTrip(int numTickets, String from, Map<String, List<Pair>> hm, List<String> ans) {
        if (numTickets == 0) {
            return true;
        } else if (!hm.containsKey(from)) {
            return false;
        } else {
            for (Pair to : hm.get(from)) {
                if (!to.visited) {
                    to.visited = true;
                    ans.add(to.name);
                    if (canFormTrip(numTickets-1, to.name, hm, ans)) {
                        return true;
                    }
                    to.visited = false;
                    ans.remove(ans.size()-1);
                }
            }
            return false;
        }
    }

}
