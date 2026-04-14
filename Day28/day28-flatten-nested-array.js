/*
2625. Flatten Deeply Nested Array (Medium - Day 28)

This solution utilizes a recursive Depth-First Search (DFS) approach.
By using an inner closure (helper function) to push elements one by one 
into a shared result array, we avoid the "Maximum call stack size exceeded" 
errors that commonly occur when developers attempt to use the ES6 spread 
operator (...arr) on massive arrays.
*/

/**
 * @param {Array} arr
 * @param {number} depth
 * @return {Array}
 */
var flat = function (arr, n) {
  let result = [];

  function helper(currentArr, currentDepth) {
    for (let item of currentArr) {
      // If the item is an array AND we haven't hit our depth limit, recurse deeper
      if (Array.isArray(item) && currentDepth > 0) {
        helper(item, currentDepth - 1);
      } else {
        // Otherwise, push the raw item to our flattened result
        result.push(item);
      }
    }
  }

  // Kick off the DFS with the initial array and target depth
  helper(arr, n);

  return result;
};

/**
 * const arr = [1, 2, 3, [4, 5, 6], [7, 8, [9, 10, 11], 12], [13, 14, 15]];
 * console.log(flat(arr, 1));
 * // [1, 2, 3, 4, 5, 6, 7, 8, [9, 10, 11], 12, 13, 14, 15]
 */
