package solutions;

import java.util.*;

/**
 * Equations are given in the format A / B = k, where A and B are variables represented as strings,
 * and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.
 *
 * Example:
 *  Given a / b = 2.0, b / c = 3.0.
 *  queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 *  return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 *
 * The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries ,
 * where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.
 *
 * According to the example above:
 *  equations = [ ["a", "b"], ["b", "c"] ],
 *  values = [2.0, 3.0],
 *  queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 *
 * The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
 */

public class Q399 extends Solution {

    private class Relation {
        String variable;
        double value;
        Relation(String variable, double value) {
            this.variable = variable;
            this.value = value;
        }
    }

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        if (equations != null && values != null && queries != null && equations.length == values.length) {
            double[] ans = new double[queries.length];
            Map<String, List<Relation>> hm = constructRelations(equations, values);
            for (int i = 0; i < queries.length; ++i) {
                String[] query = queries[i];
                ans[i] = findRelation(hm, query[0], query[1], 1.0, new HashSet<>());
            }
            return ans;
        } else {
            return null;
        }
    }

    private Map<String, List<Relation>> constructRelations(String[][] equations, double[] values) {
        Map<String, List<Relation>> hm = new HashMap<>();
        for (int i = 0; i < equations.length; ++i) {
            String[] equation = equations[i];
            double value = values[i];
            if (!hm.containsKey(equation[0])) {
                hm.put(equation[0], new ArrayList<>());
            }
            hm.get(equation[0]).add(new Relation(equation[1], value));
            if (!hm.containsKey(equation[1])) {
                hm.put(equation[1], new ArrayList<>());
            }
            hm.get(equation[1]).add(new Relation(equation[0], 1/value));
        }
        return hm;
    }

    private double findRelation(Map<String, List<Relation>> hm, String start, String end, double value, Set<String> visited) {
        if (hm.containsKey(start)) {
            if (start.equals(end)) {
                return 1.0;
            } else {
                visited.add(start);
                for (Relation r : hm.get(start)) {
                    if (!visited.contains(r.variable)) {
                        if (end.equals(r.variable)) {
                            return value * r.value;
                        } else {
                            double v = findRelation(hm, r.variable, end, value * r.value, visited);
                            if (v != -1.0) {
                                return v;
                            }
                        }
                    }
                }
            }
        }
        return -1.0;
    }

}
