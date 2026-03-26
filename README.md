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

### Day 8: March 25, 2026

**Today's Progress:** Kicking off week two with a double feature! First, I solved problem #2621: Sleep. Then, I tackled a Medium problem, #167: Two Sum II - Input Array Is Sorted, in both JavaScript and Java.

**Thoughts:**

- For the `sleep` function, I learned how to create a custom asynchronous pause using a `Promise` and `setTimeout`.
- For `Two Sum II`, I utilized the Two-Pointer technique. Since the array is sorted, tracking an index at the start and end of the array and shrinking the window inward is a highly efficient `O(n)` solution that requires no extra space.

**Link to work:**

- [Day 8 - Sleep](./day8-sleep.js)
- [Day 8 - Two Sum II (JS)](./day8-two-sum-ii.js)
- [Day 8 - Two Sum II (Java)](./day8-two-sum-ii.java)

### Day 9: March 26, 2026

**Today's Progress:** A massive day! First, I solved problem #2715: Timeout Cancellation in JavaScript. Then, I solved #26: Remove Duplicates from Sorted Array in three different languages: C++, Java, and JavaScript!

**Thoughts:**

- For `Timeout Cancellation`, I learned how to manage and clean up timers using a closure and `clearTimeout`.
- For `Remove Duplicates`, I implemented an efficient Two-Pointer algorithm (`officer` and `cm`). By keeping track of the last unique element's position, I could overwrite duplicates in-place, achieving an optimal `O(n)` time and `O(1)` space complexity without needing a secondary array.

**Link to work:**

- [Day 9 - Timeout Cancellation](./day9-timeout-cancellation.js)
- [Day 9 - Remove Duplicates (C++)](./day9-remove-duplicates.cpp)
- [Day 9 - Remove Duplicates (Java)](./day9-remove-duplicates.java)
- [Day 9 - Remove Duplicates (JS)](./day9-remove-duplicates.js)
