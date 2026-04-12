/*
2665. Counter II (Advanced OOP Review - Day 26)

Revisiting this problem to demonstrate architectural flexibility. 
Instead of using a standard functional closure to manage state, this 
solution utilizes an ES6 Class. This is a common interview follow-up 
to test a developer's understanding of Object-Oriented Programming in JS.
*/

class Counter {
  constructor(init) {
    // Store the initial value so we can reset to it later
    this.initValue = init;
    // Track the current mutating value
    this.currentValue = init;
  }

  increment() {
    this.currentValue += 1;
    return this.currentValue;
  }

  decrement() {
    this.currentValue -= 1;
    return this.currentValue;
  }

  reset() {
    this.currentValue = this.initValue;
    return this.currentValue;
  }
}

/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function (init) {
  // Instantiate and return the class object
  return new Counter(init);
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */
