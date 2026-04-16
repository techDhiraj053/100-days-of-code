/*
2620. Counter (Advanced Generators Review - Day 30)

Revisiting this introductory closure problem to demonstrate advanced 
JavaScript control flow. Instead of a standard functional closure, this 
solution utilizes an ES6 Generator Function (function*) and the 'yield' 
keyword to lazily evaluate and maintain the state of an infinite sequence.
*/

/**
 * @param {number} n
 * @return {Function} counter
 */
var createCounter = function (n) {
  // Define a generator function that creates an infinite loop
  function* numberGenerator() {
    while (true) {
      // 'yield' pauses the function execution, returns the current value of n,
      // and increments n for the next time it is called.
      yield n++;
    }
  }

  // Instantiate the generator
  const gen = numberGenerator();

  // Return a function that calls .next() on our generator object
  return function () {
    return gen.next().value;
  };
};

/** * const counter = createCounter(10)
 * console.log(counter()); // 10
 * console.log(counter()); // 11
 * console.log(counter()); // 12
 */
