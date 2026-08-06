/*
207. Course Schedule (3-State Directed Cycle Detection - DAY 132!)

This solution determines if all courses can be finished by detecting cycles 
in a directed graph in O(V + E) time and O(V + E) space.

Senior Twist: Three-State Graph Coloring Architecture.
Using explicit states (`UNVISITED = 0`, `VISITING = 1`, `VISITED = 2`) 
distinguishes between nodes currently on the active recursion stack 
(indicating a circular dependency) and fully validated safe nodes, 
avoiding false positives common in simple boolean visited arrays.
*/
import java.util.List;
import java.util.ArrayList;

class Solution {
    private static final int UNVISITED = 0;
    private static final int VISITING = 1; // Currently in the active recursion path (back-edge)
    private static final int VISITED = 2;   // Fully processed and confirmed cycle-free

    private List<Integer>[] adjacencyList;
    private int[] courseStates;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adjacencyList = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        // Build directed graph: prerequisite b must be taken before course a (b -> a)
        for (int[] pair : prerequisites) {
            int targetCourse = pair[0];
            int prerequisiteCourse = pair[1];
            adjacencyList[prerequisiteCourse].add(targetCourse);
        }

        courseStates = new int[numCourses];

        // Validate each course node using DFS cycle detection
        for (int course = 0; course < numCourses; course++) {
            if (courseStates[course] == UNVISITED) {
                if (hasCycleDFS(course)) {
                    return false; // Cycle detected: impossible to finish courses
                }
            }
        }

        return true; // No cycles detected across any component
    }

    private boolean hasCycleDFS(int currentCourse) {
        // If the course is currently being visited in the active path, a cycle exists
        if (courseStates[currentCourse] == VISITING) {
            return true;
        }

        // If the course has already been fully checked, skip further exploration
        if (courseStates[currentCourse] == VISITED) {
            return false;
        }

        // Mark current node as active on the recursion path
        courseStates[currentCourse] = VISITING;

        for (int neighborCourse : adjacencyList[currentCourse]) {
            if (hasCycleDFS(neighborCourse)) {
                return true;
            }
        }

        // Mark current node as fully processed and safe
        courseStates[currentCourse] = VISITED;

        return false;
    }
}