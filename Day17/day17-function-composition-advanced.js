/*
2629. Function Composition (Advanced Review - Day 17)

Revisiting this problem to replace the imperative reverse for-loop with a more 
declarative, functional approach. This version utilizes Array.prototype.reduceRight(), 
which is the idiomatic way to compose functions in modern JavaScript.
*/

/**
 * @param {Function[]} functions
 * @return {Function}
 */
var compose = function (functions) {
  return function (x) {
    // reduceRight iterates from right to left automatically.
    // 'acc' (accumulator) starts as the initial value 'x'.
    // 'fn' is the current function being evaluated.
    return functions.reduceRight((acc, fn) => fn(acc), x);
  };
};

/**
 * const fn = compose([x => x + 1, x => 2 * x])
 * fn(4) // 9
 */
