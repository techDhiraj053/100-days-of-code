/*
28. Find the Index of the First Occurrence in a String (Framework Optimization - Day 62)

While manually implementing a Sliding Window or KMP algorithm is great for 
learning the mechanics of substring search, in a production Java environment, 
the built-in .indexOf() method is the absolute optimal choice. 

Senior Twist: Framework Mastery. Unlike .split(), which is a memory trap, 
.indexOf() operates in strict O(1) space. Furthermore, modern JVMs replace 
this specific method call with "Intrinsic Functions"—highly optimized, 
hardware-level C++ and SIMD CPU instructions that drastically outperform 
any manual nested loop written in pure Java.
*/

class Solution {
    public int strStr(String haystack, String needle) {
        // Let the hardware-accelerated JVM Intrinsics do the heavy lifting!
        return haystack.indexOf(needle);
    }
}