/*
2704. To Be Or Not To Be (Advanced OOP Review - Day 29)

Revisiting this foundational testing problem to demonstrate architectural 
growth. Instead of using a standard closure, this solution utilizes an ES6 
Class to instantiate an expectation object. This mirrors how professional 
testing libraries (like Jest or Mocha) handle test assertions under the hood.
*/

class Assertion {
  constructor(val) {
    this.val = val;
  }

  toBe(otherVal) {
    if (this.val === otherVal) return true;
    throw new Error("Not Equal");
  }

  notToBe(otherVal) {
    if (this.val !== otherVal) return true;
    throw new Error("Equal");
  }
}

/**
 * @param {any} val
 * @return {Object}
 */
var expect = function (val) {
  // Return a new instance of our OOP Assertion class
  return new Assertion(val);
};

/**
 * expect(5).toBe(5); // true
 * expect(5).notToBe(5); // throws "Equal"
 */
