/*
238. Product of Array Except Self (O(1) Space Optimization - Day 52)

This solution satisfies both the O(N) time complexity requirement and the 
strict O(1) auxiliary space follow-up. Instead of allocating separate O(N) 
arrays for the left and right prefix/suffix products, we calculate the left 
products directly into the output 'answer' array. Then, we use a single 
running 'rightProduct' variable to multiply the suffix values on the fly 
during a reverse iteration. 
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Step 1: Calculate left (prefix) products directly into the answer array
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Step 2: Calculate right (suffix) products on the fly and multiply them in
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            // Multiply the existing prefix product by the running suffix product
            answer[i] = answer[i] * rightProduct;
            
            // Update the running suffix product for the next iteration
            rightProduct *= nums[i];
        }

        return answer;
    }
}