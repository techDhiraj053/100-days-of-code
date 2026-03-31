/*
2721. Execute Asynchronous Functions in Parallel (Medium - Day 14)

Given an array of asynchronous functions functions, return a new promise promise. Each function in the array accepts no arguments and returns a promise. All the promises should be executed in parallel.

promise resolves:
When all the promises returned from functions were resolved successfully in parallel. The resolved value of promise should be an array of all the resolved values of promises in the same order as they were in the functions.

promise rejects:
When any of the promises returned from functions were rejected. promise should also reject with the reason of the first rejection.

Please solve it without using the built-in Promise.all function.
*/

/**
 * @param {Array<Function>} functions
 * @return {Promise<any>}
 */
var promiseAll = function (functions) {
  return new Promise((resolve, reject) => {
    let results = new Array(functions.length);
    let completed = 0;

    if (functions.length === 0) {
      resolve([]);
    }

    functions.forEach((fn, index) => {
      fn()
        .then((value) => {
          results[index] = value;
          completed++;

          if (completed === functions.length) {
            resolve(results);
          }
        })
        .catch((error) => {
          reject(error); // reject immediately on first failure
        });
    });
  });
};

/**
 * const promise = promiseAll([() => new Promise(res => res(42))])
 * promise.then(console.log); // [42]
 */
