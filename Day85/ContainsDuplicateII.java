/*
219. Contains Duplicate II (Sliding Window & Set Trick - Day 85)

The standard HashMap approach perfectly achieves O(N) time complexity, but 
it requires O(N) auxiliary space because it stores every element in the array.

Senior Twist: Bounded Sliding Window & Idiomatic Set Insertion.
Since we only care about elements within a distance of 'k', we can maintain 
a HashSet with a strictly bounded maximum size of 'k'. As we iterate, we remove 
the oldest element that falls outside our window. This drops our space complexity 
from O(N) to a highly efficient O(min(N, K)).

Furthermore, we utilize the fact that `Set.add()` returns a boolean. It returns 
`false` if the item is already present, allowing us to combine the "contains" 
check and the "insert" operation into a single elegant statement!
*/

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Fast-fail: If k is 0 or negative, it's impossible to have distinct indices
        if (k <= 0) {
            return false;
        }

        Set<Integer> window = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            
            // Set.add() returns false if the item is already in the set!
            // If it's already in our window, we found a duplicate within distance 'k'
            if (!window.add(nums[i])) {
                return true;
            }

            // Keep the window size strictly bounded to 'k'.
            // If the set size exceeds k, remove the element that just slid out of range.
            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }

        return false;
    }
}