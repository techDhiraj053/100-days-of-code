/*
2634. Filter Elements from Array (Advanced Functional Review - Day 21)

Revisiting this introductory problem to demonstrate functional programming mastery.
Instead of using an imperative 'for' loop, this solution implements a 'filter' 
polyfill using the built-in Array.prototype.reduce() method. This is a classic 
senior-level interview technique to show a deep understanding of array transformations.
*/

/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function (arr, fn) {
  // reduce() iterates through the array, passing the accumulated result forward.
  // We start with an empty array [] as our initial accumulator.
  return arr.reduce((accumulator, currentValue, index) => {
    // If the current value passes the test function, add it to our accumulator
    if (fn(currentValue, index)) {
      accumulator.push(currentValue);
    }
    // Always return the accumulator so the next iteration has access to it
    return accumulator;
  }, []);
};

/**
 * const arr = [0, 10, 20, 30];
 * const fn = function greaterThan10(n) { return n > 10; };
 * console.log(filter(arr, fn)); // [20, 30]
 */
