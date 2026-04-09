/*
2631. Group By (Medium - Day 23)

Write code that enhances all arrays such that you can call the array.groupBy(fn) 
method on any array and it will return a grouped version of the array.
*/

/**
 * @param {Function} fn
 * @return {Object}
 */
Array.prototype.groupBy = function (fn) {
  // We use reduce to iterate over the array (represented by 'this')
  // The accumulator starts as an empty object {}
  return this.reduce((accumulator, currentItem) => {
    // Generate the grouping key using the provided callback function
    const key = fn(currentItem);

    // If this key doesn't exist in our object yet, initialize it as an empty array
    if (!accumulator[key]) {
      accumulator[key] = [];
    }

    // Push the current item into its corresponding group
    accumulator[key].push(currentItem);

    // Return the updated object to the next iteration
    return accumulator;
  }, {}); // {} is the initial value of the accumulator
};

/**
 * const arr = [1, 2, 3];
 * console.log(arr.groupBy(String)); // {"1":[1],"2":[2],"3":[3]}
 */
