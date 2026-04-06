/*
2677. Chunk Array (Easy - Day 20)

Given an array arr and a chunk size size, return a chunked array.
A chunked array contains the original elements in arr, but consists of subarrays each of length size. The length of the last subarray may be less than size if arr.length is not evenly divisible by size.
*/

/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array}
 */
var chunk = function (arr, size) {
  let result = [];

  // Jump the loop forward by 'size' on each iteration
  for (let i = 0; i < arr.length; i += size) {
    // slice() safely extracts the chunk without mutating the original array.
    // If i + size exceeds the array bounds, slice just stops at the end.
    result.push(arr.slice(i, i + size));
  }

  return result;
};

/**
 * console.log(chunk([1,9,6,3,2], 3)); // [[1,9,6],[3,2]]
 * console.log(chunk([8,5,3,2,6], 6)); // [[8,5,3,2,6]]
 * console.log(chunk([], 1)); // []
 */
