/*
373. Find K Pairs with Smallest Sums (Min-Heap / Virtual Matrix - DAY 164!)

This solution finds the k smallest pairs without computing all possible combinations. 
By treating the pairs as a sorted 2D matrix, we use a Min-Heap to perform a 
Dijkstra-like traversal, achieving O(k log(min(N, k))) time complexity.

Senior Twist: Object-Oriented Encapsulation.
Instead of passing raw `int[]` arrays into the PriorityQueue and relying on 
magic indices (`[0]` and `[1]`), we encapsulate the coordinates in a `Pair` DTO. 
This makes the comparator and the traversal logic strictly typed and self-documenting.
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

    // Lightweight DTO to encapsulate the 2D matrix coordinates
    private static class Pair {
        int index1;
        int index2;

        Pair(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k <= 0) {
            return result;
        }

        // Min-Heap ordered safely by the sum of the actual array values
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(
                nums1[a.index1] + nums2[a.index2],
                nums1[b.index1] + nums2[b.index2]
            )
        );

        // Initialize the heap with the first column of the virtual 2D matrix.
        // We only need at most 'k' rows, because the kth smallest pair cannot be 
        // further down than the kth row.
        int boundary = Math.min(nums1.length, k);
        for (int i = 0; i < boundary; i++) {
            minHeap.offer(new Pair(i, 0));
        }

        // Extract the minimum pair and push its right-neighbor into the heap
        while (k > 0 && !minHeap.isEmpty()) {
            Pair currentMin = minHeap.poll();
            
            result.add(Arrays.asList(nums1[currentMin.index1], nums2[currentMin.index2]));

            // If a right-neighbor exists in the same row, add it to the search frontier
            if (currentMin.index2 + 1 < nums2.length) {
                minHeap.offer(new Pair(currentMin.index1, currentMin.index2 + 1));
            }

            k--;
        }

        return result;
    }
}