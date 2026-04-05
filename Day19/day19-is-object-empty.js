/*
2727. Is Object Empty (Easy - Day 19)

Given an object or an array, return if it is empty.
*/

/**
 * Approach 1: The Standard O(n) Approach
 * This is the cleanest, most readable way for everyday production code.
 * However, Object.keys() is O(n) because it creates an array of all keys in memory.
 * * @param {Object|Array} obj
 * @return {boolean}
 */
var isEmptyStandard = function (obj) {
  return Array.isArray(obj) ? obj.length === 0 : Object.keys(obj).length === 0;
};

/**
 * Approach 2: The Optimal O(1) Approach
 * This directly answers the prompt's follow-up: "Can you solve it in O(1) time?"
 * By using a for...in loop, we check if the object/array has at least one property.
 * If it does, we instantly return false on the first iteration (O(1)).
 * If it doesn't, the loop skips and returns true (O(1)).
 * * @param {Object|Array} obj
 * @return {boolean}
 */
var isEmpty = function (obj) {
  for (const _ in obj) {
    return false;
  }
  return true;
};
