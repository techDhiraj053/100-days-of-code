/*
210. Course Schedule II (Kahn's Topological Sort - DAY 136!)

This solution computes a valid course ordering in O(V + E) time complexity 
and O(V + E) auxiliary space, where V is numCourses and E is prerequisites.

Senior Twist: Dependency-Based Sorting.
Kahn's algorithm is the definitive approach for topological sorting in 
Directed Acyclic Graphs (DAGs). By maintaining the `indegree` (count of 
unsatisfied prerequisites) for each node, we greedily resolve courses 
whose requirements are fully met, effectively linearizing the dependency tree.
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> dependencyGraph = new ArrayList<>();
        int[] indegreeCount = new int[numCourses];

        // Initialize adjacency list for the dependency graph
        for (int i = 0; i < numCourses; i++) {
            dependencyGraph.add(new ArrayList<>());
        }

        // Build graph: prerequisite -> dependentCourse
        for (int[] prerequisitePair : prerequisites) {
            int dependentCourse = prerequisitePair[0];
            int prerequisiteCourse = prerequisitePair[1];

            dependencyGraph.get(prerequisiteCourse).add(dependentCourse);
            indegreeCount[dependentCourse]++;
        }

        // Queue holds courses with zero remaining prerequisites
        Queue<Integer> readyToTakeQueue = new LinkedList<>();
        for (int course = 0; course < numCourses; course++) {
            if (indegreeCount[course] == 0) {
                readyToTakeQueue.offer(course);
            }
        }

        int[] completionOrder = new int[numCourses];
        int processedCourseCount = 0;

        // Execute topological sort using Kahn's Algorithm (BFS)
        while (!readyToTakeQueue.isEmpty()) {
            int currentCourse = readyToTakeQueue.poll();
            completionOrder[processedCourseCount++] = currentCourse;

            // Fulfill the course and update the dependency status of its followers
            for (int subsequentCourse : dependencyGraph.get(currentCourse)) {
                indegreeCount[subsequentCourse]--;
                
                // If all prerequisites are satisfied, queue the course for processing
                if (indegreeCount[subsequentCourse] == 0) {
                    readyToTakeQueue.offer(subsequentCourse);
                }
            }
        }

        // If processed count < numCourses, a cycle exists (impossible to finish)
        return (processedCourseCount == numCourses) ? completionOrder : new int[0];
    }
}