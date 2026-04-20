/*
2726. Calculator with Method Chaining (Advanced OOP Encapsulation - Day 34)

This solution implements a "Fluent Interface" design pattern by returning 'this' 
to allow for method chaining. Furthermore, it utilizes modern JavaScript (ES2022) 
private class fields (#) to strictly encapsulate the internal state, preventing 
unintended external mutations.
*/

class Calculator {
  // Declare a private field using the '#' prefix
  #result;

  /** * @param {number} value
   */
  constructor(value) {
    this.#result = value;
  }

  /** * @param {number} value
   * @return {Calculator}
   */
  add(value) {
    this.#result += value;
    return this; // Return the instance to allow chaining
  }

  /** * @param {number} value
   * @return {Calculator}
   */
  subtract(value) {
    this.#result -= value;
    return this;
  }

  /** * @param {number} value
   * @return {Calculator}
   */
  multiply(value) {
    this.#result *= value;
    return this;
  }

  /** * @param {number} value
   * @return {Calculator}
   */
  divide(value) {
    if (value === 0) {
      throw new Error("Division by zero is not allowed");
    }
    this.#result /= value;
    return this;
  }

  /** * @param {number} value
   * @return {Calculator}
   */
  power(value) {
    this.#result **= value; // Using the modern exponentiation assignment operator
    return this;
  }

  /** * @return {number}
   */
  getResult() {
    return this.#result;
  }
}

/**
 * const calc = new Calculator(10);
 * console.log(calc.add(5).subtract(7).getResult()); // 8
 */
