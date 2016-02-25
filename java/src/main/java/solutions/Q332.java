package solutions;

import java.util.*;

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
