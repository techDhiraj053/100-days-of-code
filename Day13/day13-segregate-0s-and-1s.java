/*
Segregate 0s and 1s (Easy)

Given an array arr consisting of only 0's and 1's in random order. Modify the array in-place to segregate 0s onto the left side and 1s onto the right side of the array.
*/

class Solution {
    void segregate0and1(int[] arr) {
        int left = 0;
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                int temp = arr[i];
                arr[i] = arr[left];
                arr[left] = temp;
                left++;
            }
        }
    }
}