/*
2626. Array Reduce Transformation (Advanced Recursive Review - Day 18)

Revisiting this problem to demonstrate a different algorithmic approach.
Instead of using a standard iterative 'for' loop, this solution uses recursion. 
This is a common interview follow-up to test understanding of the call stack 
and functional programming principles (solving without loops).
*/

/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = function (nums, fn, init) {
  // We use an inner helper function to keep track of our current index
  // without needing to slice or mutate the original array.
  function execute(index, currentVal) {
    // Base Case: If we have reached the end of the array, return the final value.
    if (index === nums.length) {
      return currentVal;
    }

    // Recursive Step: Process the current element, increment the index,
    // and call the function again.
    const nextVal = fn(currentVal, nums[index]);
    return execute(index + 1, nextVal);
  }

  // Kick off the recursion starting at index 0 with the initial value
  return execute(0, init);
};

/**
 * const nums = [1, 2, 3, 4];
 * const fn = function sum(accum, curr) { return accum + curr; }
 * const init = 0;
 * console.log(reduce(nums, fn, init)); // 10
 */
