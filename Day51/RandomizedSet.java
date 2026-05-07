/*
380. Insert Delete GetRandom O(1) (Encapsulation Review - Day 51)

This solution perfectly satisfies the strict O(1) average time complexity 
requirements by combining the fast lookups of a HashMap with the fast 
indexed access of an ArrayList. When removing, swapping the target element 
with the last element prevents the O(N) shift that usually occurs during 
array deletions.

To make this class enterprise-ready, access modifiers (private) and the 
'final' keyword are added to the class properties. This ensures proper 
encapsulation and prevents accidental reassignment of our core data structures.
*/

import java.util.*;

class RandomizedSet {
    // Senior Twist: Proper encapsulation using 'private' and 'final'
    private final Map<Integer, Integer> indexMap;
    private final List<Integer> elements;
    private final Random random;

    public RandomizedSet() {
        indexMap = new HashMap<>();
        elements = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if (indexMap.containsKey(val)) {
            return false;
        }
        // Add the new element to the end of the list
        elements.add(val);
        // Store its corresponding index in the map
        indexMap.put(val, elements.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        if (!indexMap.containsKey(val)) {
            return false;
        }
        
        // Get the index of the element we want to remove
        int indexToRemove = indexMap.get(val);
        // Get the value of the very last element in the list
        int lastElement = elements.get(elements.size() - 1);
        
        // Swap the last element into the spot we are trying to delete
        elements.set(indexToRemove, lastElement);
        // Update the map to reflect the last element's new index
        indexMap.put(lastElement, indexToRemove);
        
        // Pop the last element off the list (O(1) operation)
        elements.remove(elements.size() - 1);
        // Remove the target value from the map
        indexMap.remove(val);
        
        return true;
    }
    
    public int getRandom() {
        // Fetch a random index and return the element at that index
        int randomIndex = random.nextInt(elements.size());
        return elements.get(randomIndex);
    }
}