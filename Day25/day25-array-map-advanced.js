/*
2635. Apply Transform Over Each Element in Array (Advanced Functional Review - Day 25)

Revisiting this map polyfill to demonstrate how to implement map() using the 
highly versatile Array.prototype.reduce() method. Building array methods out of 
other array methods is a common senior-level interview technique to test deep 
understanding of functional programming concepts.
*/

/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function (arr, fn) {
  // We use reduce to iterate through the array.
  // We initialize the accumulator as an empty array [].
  return arr.reduce((accumulator, currentValue, index) => {
    // Apply the transformation function and push the result into our accumulator
    accumulator.push(fn(currentValue, index));

    // Return the accumulator for the next iteration
    return accumulator;
  }, []);
};

/**
 * const arr = [1, 2, 3];
 * const fn = function plusone(n) { return n + 1; };
 * console.log(map(arr, fn)); // [2, 3, 4]
 */
