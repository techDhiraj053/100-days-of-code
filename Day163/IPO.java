/*
502. IPO (Greedy Max-Heap - DAY 163!)

This solution maximizes capital by using a two-phase greedy approach: 
a sorted array to track affordability, and a Max-Heap to execute the most 
profitable available project. Time Complexity: O(N log N).

Senior Twist: Object-Oriented Data Transfer Objects (DTOs).
Instead of passing around a 2D integer array with magic indices `[0]` and `[1]`, 
we define a static `Project` class. This encapsulates the domain logic, making 
the sorting comparator (`Comparator.comparingInt`) and the heap operations 
highly readable and immune to index-swapping bugs.
*/
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    
    // Encapsulate the domain entity
    private static class Project {
        int requiredCapital;
        int profit;

        Project(int requiredCapital, int profit) {
            this.requiredCapital = requiredCapital;
            this.profit = profit;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Project[] projects = new Project[n];

        for (int i = 0; i < n; i++) {
            projects[i] = new Project(capital[i], profits[i]);
        }

        // Sort projects strictly by their required capital (ascending)
        Arrays.sort(projects, Comparator.comparingInt(p -> p.requiredCapital));

        // Max-heap to dynamically track the highest available profits
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(Collections.reverseOrder());

        int projectPointer = 0;

        for (int i = 0; i < k; i++) {
            
            // Unlock all projects we can afford with our current capital
            while (projectPointer < n && projects[projectPointer].requiredCapital <= w) {
                maxProfitHeap.offer(projects[projectPointer].profit);
                projectPointer++;
            }

            // If we can't afford any more projects and the heap is empty, we are done
            if (maxProfitHeap.isEmpty()) {
                break;
            }

            // Greedily execute the single most profitable unlocked project
            w += maxProfitHeap.poll();
        }

        return w;
    }
}