/*
167. Two Sum II - Input Array Is Sorted (Medium)

Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
Return the indices of the two numbers index1 and index2, each incremented by one, as an integer array [index1, index2] of length 2.
The tests are generated such that there is exactly one solution. You may not use the same element twice.
Your solution must use only constant extra space.
*/

/**
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function (numbers, target) {
  let arr = numbers;
  let i = 0;
  let j = numbers.length - 1;
  while (i < j) {
    let sum = arr[i] + arr[j];
    if (sum === target) {
      return [i + 1, j + 1];
    }
    if (sum < target) {
      i++;
    } else if (sum > target) {
      j--;
    }
  }
  return [-1, -1];
};
