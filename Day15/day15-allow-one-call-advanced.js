/*
2666. Allow One Function Call (Advanced Version - Day 15)

Revisiting this problem to implement a more robust solution that preserves the 'this' context using .apply(), which is a common requirement in senior-level frontend interviews.
*/

/**
 * @param {Function} fn
 * @return {Function}
 */
var once = function (fn) {
  let hasBeenCalled = false;

  return function (...args) {
    if (!hasBeenCalled) {
      hasBeenCalled = true;
      // Using .apply() safely binds the 'this' context to the original function
      return fn.apply(this, args);
    } else {
      return undefined;
    }
  };
};

/**
 * let fn = (a,b,c) => (a + b + c)
 * let onceFn = once(fn)
 *
 * onceFn(1,2,3); // 6
 * onceFn(2,3,6); // returns undefined without calling fn
 */
