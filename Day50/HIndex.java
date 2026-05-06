/*
274. H-Index (O(N) Bucket Sort Optimization - Day 50!)

While sorting the array takes O(N log N) time, this solution utilizes a 
highly optimal Bucket/Counting Sort approach to achieve strict O(N) time. 
Because the maximum possible H-Index is bounded by the total number of 
papers (N), any paper with citations >= N can be grouped into a single 
"N" bucket. By traversing these buckets from right to left, we can calculate 
the exact H-Index without ever needing to perform a heavy Arrays.sort().
*/

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        // Create buckets to count paper frequencies. 
        // Size is n + 1 so we have an index for exactly 'n' citations.
        int[] buckets = new int[n + 1];

        // Step 1: Distribute papers into their respective buckets
        for (int c : citations) {
            if (c >= n) {
                // If citations exceed the number of papers, cap it at bucket 'n'
                buckets[n]++;
            } else {
                buckets[c]++;
            }
        }

        // Step 2: Iterate backwards to find the highest valid H-Index
        int papersFound = 0;
        for (int i = n; i >= 0; i--) {
            papersFound += buckets[i];
            
            // If the number of papers we've found is >= the current index (citations),
            // we have mathematically found our H-Index!
            if (papersFound >= i) {
                return i;
            }
        }
        
        return 0;
    }
}