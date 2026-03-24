# 100 Days of Code Journal

### Day 1: March 18, 2026

**Today's Progress:** Started my journey by working on the 30 Days of JavaScript challenge on LeetCode! Today I solved problem #2634: Filter Elements from Array.

**Thoughts:** It was a great exercise in recreating core JavaScript functionality from scratch without relying on the built-in `Array.filter` method. I used a standard `for` loop to evaluate the truthiness of the callback function.

**Link to work:** [Day 1 - Filter Elements](./day1-filter-elements.js).

### Day 2: March 19, 2026

**Today's Progress:** Day 2 of the 30 Days of JavaScript challenge!! I solved problem #2626: Array Reduce Transformation.

**Thoughts:** Recreating the built-in `Array.reduce` method from scratch was a great way to understand how accumulators work. I handled the empty array edge case first, then used a standard `for` loop to continuously update the state using the provided callback function.

**Link to work:** [Day 2 - Array Reduce Transformation](./day2-array-reduce.js)

### Day 3: March 20, 2026

**Today's Progress:** Continued the 30 Days of JavaScript challenge. Solved the "Function Composition" problem.

**Thoughts:** I wrote a function that takes an array of functions and returns a new composite function. I used a reverse `for` loop to evaluate the functions from right to left, passing the result of each function as the input to the next one.

**Link to work:** [Day 3 - Function Composition](./day3-function-composition.js)

### Day 4: March 21, 2026

**Today's Progress:** Day 4 of the 30 Days of JavaScript challenge! Solved the "Return Length of Arguments Passed" problem.

**Thoughts:** This was a great exercise in understanding the ES6 rest parameter syntax (`...args`). It is a very clean way to gather an indefinite number of arguments into a standard array, which let me easily return the array's `.length` property.

**Link to work:** [Day 4 - Arguments Length](./day4-arguments-length.js)

### Day 5: March 22, 2026

**Today's Progress:** Day 5 of the 30 Days of JavaScript challenge! Solved the "Allow One Function Call" problem.

**Thoughts:** This was a perfect exercise in understanding JavaScript closures. I used a boolean flag (`called`) in the outer function, and the inner returned function uses that flag to permanently remember if it has already been executed.

**Link to work:** [Day 5 - Allow One Function Call](./day5-allow-one-function-call.js)

### Day 6: March 23, 2026

**Today's Progress:** Decided to skip ahead in the 30 Days of JavaScript challenge to focus on new concepts. Today I solved problem #2623: Memoize.

**Thoughts:** Memoization is a powerful caching technique. I used a JavaScript `Map()` to store the cached results. By using the rest parameter `...args` and `JSON.stringify()`, I created a unique string key for every combination of arguments passed into the function, allowing me to check if that specific calculation had already been performed.

**Link to work:** [Day 6 - Memoize](./day6-memoize.js)

### Day 7: March 24, 2026

**Today's Progress:** One full week of coding! Today I solved problem #2723: Add Two Promises on LeetCode.

**Thoughts:** This problem was a great way to practice asynchronous JavaScript. I learned that an `async` function automatically wraps its return value in a Promise, so I just needed to `await` the resolution of the two input promises and return their sum.

**Link to work:** [Day 7 - Add Two Promises](./day7-add-two-promises.js)
