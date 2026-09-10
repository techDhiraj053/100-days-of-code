/*
295. Find Median from Data Stream (Two-Heap Architecture - DAY 165!)

This class maintains the median of a continuous data stream using a Max-Heap 
for the lower half and a Min-Heap for the upper half. 
Time Complexity: O(log N) for addNum, O(1) for findMedian.

Senior Twist: The Blind Funnel Pattern.
Instead of manually comparing peeks to decide which heap a number belongs in, 
we blindly funnel every new number through the Max-Heap into the Min-Heap. 
We then perform a simple size re-balance. This elegantly guarantees that the 
Max-Heap always holds the smaller half and the Min-Heap holds the larger half 
without requiring any manual conditional threshold checks.
*/
import java.util.PriorityQueue;
import java.util.Collections;

class MedianFinder {
    
    private final PriorityQueue<Integer> smallerHalfMaxHeap;
    private final PriorityQueue<Integer> largerHalfMinHeap;

    public MedianFinder() {
        smallerHalfMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        largerHalfMinHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // Step 1: Blindly funnel the number through the Max-Heap into the Min-Heap.
        // This mathematically guarantees the Min-Heap only receives elements that 
        // are greater than or equal to everything left in the Max-Heap.
        smallerHalfMaxHeap.offer(num);
        largerHalfMinHeap.offer(smallerHalfMaxHeap.poll());
        
        // Step 2: Balance the heaps. 
        // We enforce the rule that smallerHalfMaxHeap is allowed to be exactly 1 element larger.
        if (smallerHalfMaxHeap.size() < largerHalfMinHeap.size()) {
            smallerHalfMaxHeap.offer(largerHalfMinHeap.poll());
        }
    }
    
    public double findMedian() {
        if (smallerHalfMaxHeap.size() > largerHalfMinHeap.size()) {
            return smallerHalfMaxHeap.peek();
        }
        return (smallerHalfMaxHeap.peek() + largerHalfMinHeap.peek()) / 2.0;
    }
}