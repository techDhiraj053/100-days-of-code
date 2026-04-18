/*
2695. Array Wrapper (Advanced OOP Review - Day 32)

Revisiting this type coercion problem to demonstrate modern JavaScript architecture.
Instead of using ES5 constructor functions and manually modifying the prototype 
chain, this solution utilizes modern ES6 Classes. It safely intercepts JavaScript's 
built-in valueOf() and toString() methods to allow seamless mathematical and 
string operations on object instances.
*/

class ArrayWrapper {
  /**
   * @param {number[]} nums
   */
  constructor(nums) {
    this.nums = nums;
  }

  /**
   * Intercepts math operations (like the + operator)
   * @return {number}
   */
  valueOf() {
    return this.nums.reduce((sum, num) => sum + num, 0);
  }

  /**
   * Intercepts string casting (like String(obj))
   * @return {string}
   */
  toString() {
    return `[${this.nums.join(",")}]`;
  }
}

/**
 * const obj1 = new ArrayWrapper([1,2]);
 * const obj2 = new ArrayWrapper([3,4]);
 * console.log(obj1 + obj2); // 10
 * console.log(String(obj1)); // "[1,2]"
 * console.log(String(obj2)); // "[3,4]"
 */
