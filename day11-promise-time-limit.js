/*
2637. Promise Time Limit (Medium - Day 11)

Given an asynchronous function fn and a time t in milliseconds, return a new time limited version of the input function. fn takes arguments provided to the time limited function.

The time limited function should follow these rules:
- If the fn completes within the time limit of t milliseconds, the time limited function should resolve with the result.
- If the execution of the fn exceeds the time limit, the time limited function should reject with the string "Time Limit Exceeded".

Example 1:
Input: 
fn = async (n) => { 
  await new Promise(res => setTimeout(res, 100)); 
  return n * n; 
}
inputs = [5]
t = 50
Output: {"rejected":"Time Limit Exceeded","time":50}
Explanation: The provided function is set to resolve after 100ms. However, the time limit is set to 50ms. It rejects at t=50ms because the time limit was reached.
*/

/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
var timeLimit = function (fn, t) {
  return async function (...args) {
    const timeoutPromise = new Promise((_, reject) => {
      setTimeout(() => reject("Time Limit Exceeded"), t);
    });

    return Promise.race([fn(...args), timeoutPromise]);
  };
};

/**
 * const limited = timeLimit((t) => new Promise(res => setTimeout(res, t)), 100);
 * limited(150).catch(console.log) // "Time Limit Exceeded" at t=100ms
 */
