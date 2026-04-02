/*
2703. Return Length of Arguments Passed (Advanced Review - Day 16)

Revisiting this introductory problem to explore JavaScript's underlying mechanics. 
Instead of just using the standard ES6 rest parameter, this file demonstrates three 
distinct ways to handle function arguments, which is a common discussion point in interviews.
*/

// Approach 1: The Modern ES6 Way
// Using the rest parameter (...args) to gather arguments into a true array.
var argumentsLengthES6 = function (...args) {
  return args.length;
};

// Approach 2: The Legacy JavaScript Way (ES5)
// Standard functions (but NOT arrow functions) have a hidden, built-in 'arguments' object.
// Interviewers love asking about the difference between the 'arguments' object and ...args!
var argumentsLengthLegacy = function () {
  return arguments.length;
};

// Approach 3: The "No Built-In Properties" Constraint
// If an interviewer says "Solve it without using the .length property",
// you can manually iterate through the array to prove your algorithmic logic.
var argumentsLengthManual = function (...args) {
  let count = 0;
  for (let item of args) {
    count++;
  }
  return count;
};

/**
 * argumentsLengthES6(1, 2, 3); // 3
 * argumentsLengthLegacy(1, 2, 3); // 3
 * argumentsLengthManual(1, 2, 3); // 3
 */
