/*
26. Remove Duplicates from Sorted Array (Easy)

Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.
Return the number of unique elements k.
*/

#include <vector>
using namespace std;

class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int officer = 0;
        int result = 1;
        int cm = 1;
        while(cm < nums.size()){
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
};