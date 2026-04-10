/*
2724. Sort By (Easy - Day 24)

Given an array arr and a function fn, return a sorted array sortedArr. 
You can assume fn only returns numbers and those numbers determine the sort order.
*/

/**
 * @param {Array} arr
 * @param {Function} fn
 * @return {Array}
 */
var sortBy = function (arr, fn) {
  // Approach 1: The Standard Way (Mutates original array)
  // return arr.sort((a, b) => fn(a) - fn(b));

  // Approach 2: The Immutable "Senior" Way
  // By wrapping 'arr' in an array literal with the spread operator [...arr],
  // we create a brand new copy of the array in memory before sorting.
  // This prevents side effects and is crucial for state management in UI frameworks.
  return [...arr].sort((a, b) => fn(a) - fn(b));
};

/**
 * const arr = [{"x": 1}, {"x": 0}, {"x": -1}];
 * const fn = (d) => d.x;
 * console.log(sortBy(arr, fn)); // [{"x": -1}, {"x": 0}, {"x": 1}]
 */
