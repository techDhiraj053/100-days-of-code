/*
399. Evaluate Division (Weighted Graph DFS Traversal - DAY 131!)

This solution evaluates division queries by modeling variables as nodes 
and equations as weighted directed edges in O(Q * (V + E)) time.

Senior Twist: Weighted Adjacency Mapping.
By representing equations as bidirectional weighted edges ($A \rightarrow B$ with weight $w$, 
and $B \rightarrow A$ with weight $1/w$), path evaluation reduces to cumulative 
multiplication along a DFS traversal route.
*/
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Build weighted adjacency list graph: graph.get(dividend).put(divisor, ratio)
        Map<String, Map<String, Double>> divisionGraph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);
            double ratio = values[i];

            divisionGraph.putIfAbsent(dividend, new HashMap<>());
            divisionGraph.putIfAbsent(divisor, new HashMap<>());

            divisionGraph.get(dividend).put(divisor, ratio);
            divisionGraph.get(divisor).put(dividend, 1.0 / ratio);
        }

        double[] queryResults = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String sourceNode = queries.get(i).get(0);
            String targetNode = queries.get(i).get(1);

            // Guard: If either variable is missing from the graph, answer cannot be determined
            if (!divisionGraph.containsKey(sourceNode) || !divisionGraph.containsKey(targetNode)) {
                queryResults[i] = -1.0;
            } else if (sourceNode.equals(targetNode)) {
                queryResults[i] = 1.0; // Self-division is always 1.0 (assuming valid variable)
            } else {
                queryResults[i] = dfsEvaluate(sourceNode, targetNode, divisionGraph, new HashSet<>());
            }
        }

        return queryResults;
    }

    private double dfsEvaluate(String currentNode, String targetNode,
                               Map<String, Map<String, Double>> graph,
                               Set<String> visitedNodes) {
        // Base case: destination reached
        if (currentNode.equals(targetNode)) {
            return 1.0;
        }

        visitedNodes.add(currentNode);

        for (Map.Entry<String, Double> neighborEntry : graph.get(currentNode).entrySet()) {
            String nextNode = neighborEntry.getKey();
            double edgeWeight = neighborEntry.getValue();

            if (visitedNodes.contains(nextNode)) {
                continue;
            }

            double subPathResult = dfsEvaluate(nextNode, targetNode, graph, visitedNodes);

            // If a valid path leads to the target, multiply along the chain
            if (subPathResult != -1.0) {
                return edgeWeight * subPathResult;
            }
        }

        return -1.0; // No valid path found
    }
}