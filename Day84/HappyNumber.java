/*
202. Happy Number (Floyd's Cycle Detection - Day 84)

The HashSet approach correctly identifies cycles, but it requires O(log N) 
auxiliary space to store the history of the sequence.

Senior Twist: Floyd's Tortoise and Hare Algorithm.
We can treat the sequence of numbers as a virtual Linked List! By using a 
slow pointer (moves 1 step) and a fast pointer (moves 2 steps), we can detect 
a cycle without storing any historical data in memory. If there is a cycle, 
the fast pointer will eventually catch the slow pointer. If the number is happy, 
the fast pointer will simply hit 1. This reduces the space complexity to a 
strict O(1)!
*/

class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);

        // While the fast pointer hasn't reached 1 (happy), 
        // and the pointers haven't met (which indicates an infinite cycle)
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);                // Tortoise: Moves 1 step
            fast = getNext(getNext(fast));       // Hare: Moves 2 steps
        }

        // If the loop broke because fast reached 1, it's a happy number!
        return fast == 1;
    }

    private int getNext(int n) {
        int sum = 0;
        
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        
        return sum;
    }
}