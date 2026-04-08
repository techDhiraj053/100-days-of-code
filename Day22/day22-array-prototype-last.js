/*
2619. Array Prototype Last (Easy - Day 22)

Write code that enhances all arrays such that you can call the array.last() 
method on any array and it will return the last element. If there are no 
elements in the array, it should return -1.
*/

/**
 * @return {null|boolean|number|string|Array|Object}
 */
Array.prototype.last = function () {
  // If the array is empty, return -1 as required by the prompt
  if (this.length === 0) {
    return -1;
  }

  // Approach 1: The Classic Way (O(1) time)
  // return this[this.length - 1];

  // Approach 2: The Modern ES2022 Way (O(1) time)
  // The .at() method natively supports negative indexing,
  // making it much cleaner to grab elements from the end of an array.
  return this.at(-1);
};

/**
 * const arr1 = [1, 2, 3];
 * console.log(arr1.last()); // 3
 * * const arr2 = [];
 * console.log(arr2.last()); // -1
 */
