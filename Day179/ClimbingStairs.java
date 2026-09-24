/*
70. Climbing Stairs (Dynamic Programming / Math - DAY 179!)

This is the standard O(n) Time, O(1) Space dynamic programming solution 
using a state-tracking sliding window (Fibonacci sequence).

Senior Twist: Binet's Formula for O(1) Time.
If we ever needed this to run in strict constant time without looping, 
we can mathematically calculate the nth term of the Fibonacci sequence 
using the Golden Ratio (phi) and Binet's Formula.
(Commented out below to preserve your excellent DP solution).

public int climbStairsBinet(int n) {
    double sqrt5 = Math.sqrt(5);
    double phi = (1 + sqrt5) / 2;
    // Binet's Formula for the (n+1)th Fibonacci number
    return (int) Math.round(Math.pow(phi, n + 1) / sqrt5);
}
*/
class Solution {
    public int climbStairs(int n) {
        // Fast fail for base cases
        if (n <= 2) {
            return n;
        }

        // Semantic naming for enterprise readability
        int twoStepsBehind = 1;
        int oneStepBehind = 2;

        for (int i = 3; i <= n; i++) {
            int currentStep = oneStepBehind + twoStepsBehind;
            
            // Slide the window forward
            twoStepsBehind = oneStepBehind;
            oneStepBehind = currentStep;
        }

        return oneStepBehind;
    }
}