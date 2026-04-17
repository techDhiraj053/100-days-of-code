/*
2705. Compact Object (Advanced Functional Review - Day 31)

Revisiting this recursive object manipulation problem to demonstrate 
declarative functional programming. By leveraging built-in array methods 
like .map(), .filter(), and .reduce(), we can achieve the exact same 
results as imperative 'for' loops but with much cleaner, more readable code.
*/

/**
 * @param {Object|Array} obj
 * @return {Object|Array}
 */
var compactObject = function (obj) {
  // Base case: If it is a primitive value or null, return it directly
  if (obj === null || typeof obj !== "object") {
    return obj;
  }

  // Array Case: Recursively compact every item, then filter out the falsy results
  // Passing 'Boolean' directly to filter is a senior-level shorthand for (val => Boolean(val))
  if (Array.isArray(obj)) {
    return obj.map(compactObject).filter(Boolean);
  }

  // Object Case: Use reduce to build a brand new object without falsy keys
  return Object.keys(obj).reduce((accumulator, key) => {
    const compactedValue = compactObject(obj[key]);

    // Only append the key to our accumulator if the compacted value is truthy
    if (Boolean(compactedValue)) {
      accumulator[key] = compactedValue;
    }

    return accumulator;
  }, {});
};

/**
 * const obj = [null, 0, 5, [0], [false, 16]];
 * console.log(compactObject(obj)); // [5, [], [16]]
 */
