/*
1722. Minimize Hamming Distance After Swap Operations (Day 35)

This solution utilizes an optimized Union-Find (Disjoint Set) algorithm to 
group indices that can be freely swapped into connected components. 
It implements both Path Compression and Union-by-Rank to guarantee 
optimal O(α(N)) nearly-constant time complexity for graph operations.
*/

import java.util.*;

class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        UnionFind uf = new UnionFind(n);

        // Step 1: Build connected components (groups of swappable indices)
        for (int[] swap : allowedSwaps) {
            uf.union(swap[0], swap[1]);
        }

        // Step 2: Map each group's root to its list of indices
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }

        int result = 0;

        // Step 3: Process each isolated component
        for (List<Integer> group : groups.values()) {
            Map<Integer, Integer> count = new HashMap<>();

            // Tally the available numbers in the source for this group
            for (int idx : group) {
                count.put(source[idx], count.getOrDefault(source[idx], 0) + 1);
            }

            // Attempt to match them with the required numbers in the target
            for (int idx : group) {
                int val = target[idx];
                if (count.getOrDefault(val, 0) > 0) {
                    count.put(val, count.get(val) - 1); // Match found, decrement availability
                } else {
                    result++; // No match available, Hamming distance increases
                }
            }
        }

        return result;
    }

    // Senior Twist: Static inner class prevents implicit outer-class memory leaks
    static class UnionFind {
        int[] parent;
        int[] rank; // Tracks tree depth to optimize unions

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1; // Initial rank is 1
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            if (rootA != rootB) {
                // Union by Rank: Attach smaller tree under larger tree
                if (rank[rootA] > rank[rootB]) {
                    parent[rootB] = rootA;
                } else if (rank[rootA] < rank[rootB]) {
                    parent[rootA] = rootB;
                } else {
                    parent[rootB] = rootA;
                    rank[rootA]++; // If ranks are equal, promote the new root
                }
            }
        }
    }
}