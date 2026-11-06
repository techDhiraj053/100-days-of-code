/*
209. Minimum Size Subarray Sum (Variable Sliding Window - DAY 215!)

Time Complexity: O(N) because each element is added and removed at most once.
Space Complexity: O(1).

Senior Twist: The Acquire and Release (Hire/Fire) Pattern.
Converted the outer `while` loop into a `for` loop to manage the `high` 
pointer automatically. The logic remains purely based on the beautiful 
"Hire/Fire" concept: we aggressively expand the window (hire) until we hit 
the target, and then strictly shrink the window from the left (fire) to 
find the absolute minimal length possible!
*/
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int low = 0;
        int res = Integer.MAX_VALUE;
        
        for (int high = 0; high < nums.length; high++) {
            // Hire: Expand the window by adding the current element
            sum += nums[high];
            
            // Fire: Shrink the window from the left as long as the condition is met
            while (sum >= target) {
                res = Math.min(res, high - low + 1);
                sum -= nums[low];
                low++;
            }
        }
        
        // If res never changed, no valid subarray was found
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}