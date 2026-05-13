/*
12. Integer to Roman (Memory Optimization - Day 57)

This solution utilizes a highly optimal Greedy Algorithm. By iterating through 
the available Roman numeral symbols from largest to smallest, we can repeatedly 
subtract the largest possible value and append its symbol to a StringBuilder, 
achieving O(1) time and space complexity (since the input size is strictly bounded).

Senior Twist: The mapping arrays are extracted outside the method and declared 
as 'private static final'. This prevents Java from reallocating memory for these 
arrays every single time the method is invoked, resulting in better enterprise 
performance and reduced Garbage Collection overhead.
*/

class Solution {
    // Extracting arrays to class-level constants for memory efficiency
    private static final int[] VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] SYMBOLS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        
        for (int i = 0; i < VALUES.length; i++) {
            // Greedily consume the number using the largest possible symbol
            while (num >= VALUES[i]) {
                num -= VALUES[i];
                roman.append(SYMBOLS[i]);
            }
        }
        
        return roman.toString();
    }
}