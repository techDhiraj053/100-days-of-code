/*
133. Clone Graph (DFS Memoization & Cycle Handling - DAY 130!)

This solution creates a deep copy of a connected undirected graph 
in O(V + E) time complexity and O(V) auxiliary space.

Senior Twist: Memoized Graph Mapping.
Using a `HashMap<Node, Node>` to map original nodes to their corresponding clones 
before diving into recursive neighbor traversal is the definitive design pattern 
for graph duplication. It gracefully intercepts cyclic references and prevents 
infinite recursion loops.
*/
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    // Memoization map linking original graph nodes to their cloned counterparts
    private Map<Node, Node> clonedNodeMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // If the node has already been cloned, return its cached reference (cycle breaker)
        if (clonedNodeMap.containsKey(node)) {
            return clonedNodeMap.get(node);
        }

        // Instantiate the deep copy of the current node
        Node nodeClone = new Node(node.val);

        // Crucial: Cache the clone in the map BEFORE traversing neighbors 
        // to handle cyclic graph connections correctly.
        clonedNodeMap.put(node, nodeClone);

        // Recursively clone and link all adjacent neighbors
        for (Node neighbor : node.neighbors) {
            nodeClone.neighbors.add(cloneGraph(neighbor));
        }

        return nodeClone;
    }
}