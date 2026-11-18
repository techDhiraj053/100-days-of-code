/*
904. Fruit Into Baskets (Variable Sliding Window - DAY 225!)

This solution finds the longest contiguous subarray with at most 2 unique elements.
Time Complexity: O(N) where N is the number of trees.
Space Complexity: O(N) using a flat array instead of a HashMap.

Senior Twist: Primitive Array Hashing via Constraints.
The problem constraints explicitly state `0 <= fruits[i] < fruits.length`. 
This is a massive hint! Instead of using a `HashMap` which suffers from 
Object autoboxing and hashing overhead, we can use a primitive `int[]` 
frequency array bounded by the input size. Applying the exact same 
"Hire and Fire" sliding window mechanics with this primitive array makes 
the execution blisteringly fast, hitting peak CPU cache efficiency.
*/
class Solution {
    public int totalFruit(int[] fruits) {
        // The constraints guarantee fruit types are strictly less than fruits.length
        int[] fruitCount = new int[fruits.length];
        int uniqueCount = 0;
        
        int low = 0;
        int maxFruits = 0;

        for (int high = 0; high < fruits.length; high++) {
            int currentFruit = fruits[high];
            
            // Hire: Add new fruit to the current window
            if (fruitCount[currentFruit] == 0) {
                uniqueCount++;
            }
            fruitCount[currentFruit]++;

            // Fire: If we have more than 2 distinct fruit types, shrink from the left
            while (uniqueCount > 2) {
                int leftFruit = fruits[low];
                fruitCount[leftFruit]--;
                
                if (fruitCount[leftFruit] == 0) {
                    uniqueCount--;
                }
                low++;
            }

            // The window now strictly contains at most 2 types of fruit
            maxFruits = Math.max(maxFruits, high - low + 1);
        }

        return maxFruits;
    }
}