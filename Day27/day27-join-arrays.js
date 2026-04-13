/*
2722. Join Two Arrays by ID (Medium - Day 27)

This solution implements a dictionary (Hash Map) approach to merge two arrays.
By using a standard Object {} instead of an Array [] for the map, we prevent 
potential memory leaks caused by "sparse arrays" if the IDs have large numerical gaps.
*/

/**
 * @param {Array} arr1
 * @param {Array} arr2
 * @return {Array}
 */
var join = function (arr1, arr2) {
  // Use an object {} instead of an array [] to avoid sparse array memory issues
  const map = {};

  // Initialize the dictionary with arr1
  for (let obj of arr1) {
    map[obj.id] = obj;
  }

  // Merge arr2 into the dictionary
  for (let obj of arr2) {
    if (map[obj.id]) {
      // If ID exists, merge properties. The spread operator processes left-to-right,
      // meaning properties from 'obj' (arr2) will safely overwrite map[obj.id] (arr1).
      map[obj.id] = { ...map[obj.id], ...obj };
    } else {
      // If ID is new, just add it
      map[obj.id] = obj;
    }
  }

  // Extract the final merged objects and sort them ascending by ID
  return Object.values(map).sort((a, b) => a.id - b.id);
};

/**
 * const arr1 = [{"id": 1, "x": 1}, {"id": 2, "x": 9}];
 * const arr2 = [{"id": 3, "x": 5}];
 * console.log(join(arr1, arr2));
 * // [{"id": 1, "x": 1}, {"id": 2, "x": 9}, {"id": 3, "x": 5}]
 */
