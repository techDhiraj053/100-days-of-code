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

### Day 10: March 27, 2026

**Today's Progress:** Hit double digits! Solved problem #2725: Interval Cancellation.

**Thoughts:** Building on yesterday's timeout logic, today I handled repeating intervals. Because `setInterval` has an initial delay, I had to immediately invoke `fn(...args)` once before setting up the interval. Then, just like yesterday, I returned a closure that executes `clearInterval` to stop the repeating execution.

**Link to work:** [Day 10 - Interval Cancellation](./day10-interval-cancellation.js)

### Day 11: March 28, 2026

**Today's Progress:** Solved a Medium-level problem today! #2637: Promise Time Limit.

**Thoughts:** This was a great opportunity to use the `Promise.race()` method. I created a custom Promise that automatically rejects after `t` milliseconds using `setTimeout`. By passing both the original function execution and my custom timeout Promise into `Promise.race()`, the wrapper function cleanly returns whichever Promise settles first.

**Link to work:** [Day 11 - Promise Time Limit](./day11-promise-time-limit.js)

### Day 12: March 29, 2026

**Today's Progress:** Tackled another Medium-level JavaScript problem! Solved #2622: Cache With Time Limit.

**Thoughts:** I implemented a custom Cache class using a JavaScript `Map`. To handle the time limits, I used a "lazy evaluation" technique. Instead of setting up active timers (`setTimeout`) to delete keys, I calculate the absolute expiration timestamp (`Date.now() + duration`) and store it with the value. Then, whenever `get()` or `count()` is called, I simply compare the current time to the stored expiration time. This avoids the overhead of managing multiple timer IDs!

**Link to work:** [Day 12 - Time Limited Cache](./day12-time-limited-cache.js)

### Day 13: March 30, 2026

**Today's Progress:** An action-packed day! First, I solved a classic frontend interview question, #2627: Debounce (Medium). Then, I solved an algorithmic problem, "Segregate 0s and 1s", in three different languages: Java, C++, and JavaScript.

**Thoughts:**

- **Debounce:** I used a closure and `clearTimeout` to ensure a function only fires after a user has stopped triggering the event for a specified time.
- **Segregate 0s and 1s:** I implemented an efficient $O(n)$ time and $O(1)$ space solution using a single pass. By keeping a `left` pointer to track the boundary of the 0s, I swapped any encountered 0s to the front. It was great practice using different swap techniques across three languages (temp variables in Java, `swap()` in C++, and array destructuring in JS).

**Link to work:**

- [Day 13 - Debounce](./day13-debounce.js)
- [Day 13 - Segregate 0s and 1s (Java)](./day13-segregate-0s-and-1s.java)
- [Day 13 - Segregate 0s and 1s (C++)](./day13-segregate-0s-and-1s.cpp)
- [Day 13 - Segregate 0s and 1s (JS)](./day13-segregate-0s-and-1s.js)
