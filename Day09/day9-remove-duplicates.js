/*
26. Remove Duplicates from Sorted Array (Easy)
(See CPP file for full problem description)
*/

/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function (nums) {
  let officer = 0;
  let result = 1;
  let cm = 1;
  while (cm < nums.length) {
    if (nums[cm] === nums[cm - 1]) {
      cm++;
      continue;
    }
    nums[officer + 1] = nums[cm];
    result += 1;
    officer++;
    cm++;
  }
  return result;
};
