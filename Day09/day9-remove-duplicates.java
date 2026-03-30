/*
26. Remove Duplicates from Sorted Array (Easy)
(See JS/CPP file for full problem description)
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        int officer = 0;
        int result = 1;
        int cm = 1;
        while(cm < nums.length){
            if(nums[cm] == nums[cm-1]){
                cm++;
                continue;
            }
            nums[officer+1] = nums[cm];
            result += 1;
            officer++;
            cm++;
        }
        return result;
    }
}