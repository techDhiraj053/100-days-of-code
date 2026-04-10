# 100 Days of Code Journal

> "Consistency is what transforms average into excellence."

🎯 **Goal:** Complete 100 days of consistent coding, focusing on core JavaScript concepts, data structures, and algorithmic problem-solving.

---

### Day 1: March 18, 2026

**Today's Progress:** Started my journey by working on the 30 Days of JavaScript challenge on LeetCode! Today I solved problem #2634: Filter Elements from Array.

**Thoughts:** It was a great exercise in recreating core JavaScript functionality from scratch without relying on the built-in `Array.filter` method. I used a standard `for` loop to evaluate the truthiness of the callback function.

**Link to work:** [Day 1 - Filter Elements](./Day01/day1-filter-elements.js)

### Day 2: March 19, 2026

**Today's Progress:** Day 2 of the 30 Days of JavaScript challenge!! I solved problem #2626: Array Reduce Transformation.

**Thoughts:** Recreating the built-in `Array.reduce` method from scratch was a great way to understand how accumulators work. I handled the empty array edge case first, then used a standard `for` loop to continuously update the state using the provided callback function.

**Link to work:** [Day 2 - Array Reduce Transformation](./Day02/day2-array-reduce.js)

### Day 3: March 20, 2026

**Today's Progress:** Continued the 30 Days of JavaScript challenge. Solved the "Function Composition" problem.

**Thoughts:** I wrote a function that takes an array of functions and returns a new composite function. I used a reverse `for` loop to evaluate the functions from right to left, passing the result of each function as the input to the next one.

**Link to work:** [Day 3 - Function Composition](./Day03/day3-function-composition.js)

### Day 4: March 21, 2026

**Today's Progress:** Day 4 of the 30 Days of JavaScript challenge! Solved the "Return Length of Arguments Passed" problem.

**Thoughts:** This was a great exercise in understanding the ES6 rest parameter syntax (`...args`). It is a very clean way to gather an indefinite number of arguments into a standard array, which let me easily return the array's `.length` property.

**Link to work:** [Day 4 - Arguments Length](./Day04/day4-arguments-length.js)

### Day 5: March 22, 2026

**Today's Progress:** Day 5 of the 30 Days of JavaScript challenge! Solved the "Allow One Function Call" problem.

**Thoughts:** This was a perfect exercise in understanding JavaScript closures. I used a boolean flag (`called`) in the outer function, and the inner returned function uses that flag to permanently remember if it has already been executed.

**Link to work:** [Day 5 - Allow One Function Call](./Day05/day5-allow-one-function-call.js)

### Day 6: March 23, 2026

**Today's Progress:** Decided to skip ahead in the 30 Days of JavaScript challenge to focus on new concepts. Today I solved problem #2623: Memoize.

**Thoughts:** Memoization is a powerful caching technique. I used a JavaScript `Map()` to store the cached results. By using the rest parameter `...args` and `JSON.stringify()`, I created a unique string key for every combination of arguments passed into the function, allowing me to check if that specific calculation had already been performed.

**Link to work:** [Day 6 - Memoize](./Day06/day6-memoize.js)

### Day 7: March 24, 2026

**Today's Progress:** One full week of coding! Today I solved problem #2723: Add Two Promises on LeetCode.

**Thoughts:** This problem was a great way to practice asynchronous JavaScript. I learned that an `async` function automatically wraps its return value in a Promise, so I just needed to `await` the resolution of the two input promises and return their sum.

**Link to work:** [Day 7 - Add Two Promises](./Day07/day7-add-two-promises.js)

### Day 8: March 25, 2026

**Today's Progress:** Kicking off week two with a double feature! First, I solved problem #2621: Sleep. Then, I tackled a Medium problem, #167: Two Sum II - Input Array Is Sorted, in both JavaScript and Java.

**Thoughts:**

- For the `sleep` function, I learned how to create a custom asynchronous pause using a `Promise` and `setTimeout`.
- For `Two Sum II`, I utilized the Two-Pointer technique. Since the array is sorted, tracking an index at the start and end of the array and shrinking the window inward is a highly efficient `O(n)` solution that requires no extra space.

**Link to work:**

- [Day 8 - Sleep](./Day08/day8-sleep.js)
- [Day 8 - Two Sum II (JS)](./Day08/day8-two-sum-ii.js)
- [Day 8 - Two Sum II (Java)](./Day08/day8-two-sum-ii.java)

### Day 9: March 26, 2026

**Today's Progress:** A massive day! First, I solved problem #2715: Timeout Cancellation in JavaScript. Then, I solved #26: Remove Duplicates from Sorted Array in three different languages: C++, Java, and JavaScript!

**Thoughts:**

- For `Timeout Cancellation`, I learned how to manage and clean up timers using a closure and `clearTimeout`.
- For `Remove Duplicates`, I implemented an efficient Two-Pointer algorithm (`officer` and `cm`). By keeping track of the last unique element's position, I could overwrite duplicates in-place, achieving an optimal `O(n)` time and `O(1)` space complexity without needing a secondary array.

**Link to work:**

- [Day 9 - Timeout Cancellation](./Day09/day9-timeout-cancellation.js)
- [Day 9 - Remove Duplicates (C++)](./Day09/day9-remove-duplicates.cpp)
- [Day 9 - Remove Duplicates (Java)](./Day09/day9-remove-duplicates.java)
- [Day 9 - Remove Duplicates (JS)](./Day09/day9-remove-duplicates.js)

### Day 10: March 27, 2026

**Today's Progress:** Hit double digits! Solved problem #2725: Interval Cancellation.

**Thoughts:** Building on yesterday's timeout logic, today I handled repeating intervals. Because `setInterval` has an initial delay, I had to immediately invoke `fn(...args)` once before setting up the interval. Then, just like yesterday, I returned a closure that executes `clearInterval` to stop the repeating execution.

**Link to work:** [Day 10 - Interval Cancellation](./Day10/day10-interval-cancellation.js)

### Day 11: March 28, 2026

**Today's Progress:** Solved a Medium-level problem today! #2637: Promise Time Limit.

**Thoughts:** This was a great opportunity to use the `Promise.race()` method. I created a custom Promise that automatically rejects after `t` milliseconds using `setTimeout`. By passing both the original function execution and my custom timeout Promise into `Promise.race()`, the wrapper function cleanly returns whichever Promise settles first.

**Link to work:** [Day 11 - Promise Time Limit](./Day11/day11-promise-time-limit.js)

### Day 12: March 29, 2026

**Today's Progress:** Tackled another Medium-level JavaScript problem! Solved #2622: Cache With Time Limit.

**Thoughts:** I implemented a custom Cache class using a JavaScript `Map`. To handle the time limits, I used a "lazy evaluation" technique. Instead of setting up active timers (`setTimeout`) to delete keys, I calculate the absolute expiration timestamp (`Date.now() + duration`) and store it with the value. Then, whenever `get()` or `count()` is called, I simply compare the current time to the stored expiration time. This avoids the overhead of managing multiple timer IDs!

**Link to work:** [Day 12 - Time Limited Cache](./Day12/day12-time-limited-cache.js)

### Day 13: March 30, 2026

**Today's Progress:** An action-packed day! First, I solved a classic frontend interview question, #2627: Debounce (Medium). Then, I solved an algorithmic problem, "Segregate 0s and 1s", in three different languages: Java, C++, and JavaScript.

**Thoughts:**

- **Debounce:** I used a closure and `clearTimeout` to ensure a function only fires after a user has stopped triggering the event for a specified time.
- **Segregate 0s and 1s:** I implemented an efficient `O(n)` time and `O(1)` space solution using a single pass. By keeping a `left` pointer to track the boundary of the 0s, I swapped any encountered 0s to the front. It was great practice using different swap techniques across three languages (temp variables in Java, `swap()` in C++, and array destructuring in JS).

**Link to work:**

- [Day 13 - Debounce](./Day13/day13-debounce.js)
- [Day 13 - Segregate 0s and 1s (Java)](./Day13/day13-segregate-0s-and-1s.java)
- [Day 13 - Segregate 0s and 1s (C++)](./Day13/day13-segregate-0s-and-1s.cpp)
- [Day 13 - Segregate 0s and 1s (JS)](./Day13/day13-segregate-0s-and-1s.js)

### Day 14: March 31, 2026

**Today's Progress:** Solved a core JavaScript concurrency problem! #2721: Execute Asynchronous Functions in Parallel (Medium).

**Thoughts:** Recreating the built-in `Promise.all()` method from scratch was a great way to deeply understand parallel execution in JS. I created a custom Promise that iterates through the input functions. By using the array `index` inside the `.forEach` loop, I ensured the results were stored in the exact same order as the input, regardless of which promise resolved first. A counter (`completed`) keeps track of when to finally resolve the outer promise, while a `.catch` ensures it rejects immediately upon any failure.

**Link to work:** [Day 14 - Execute Async Functions](./Day14/day14-execute-async-functions.js)

### Day 15: April 1, 2026

**Today's Progress:** It was an incredibly busy day, so I utilized "spaced repetition" to review a core concept! I re-solved problem #2666: Allow One Function Call, but this time, I upgraded my approach.

**Thoughts:** Consistency is key. Even on busy days, keeping the streak alive is important. Since I had already solved the basic version of this closure problem in the past, I challenged myself to write a more robust "Senior" version today. I updated the closure to use `fn.apply(this, args)` instead of just `fn(...args)`. This ensures that if the returned function is used as a method on an object, it won't lose its proper `this` binding context—a crucial detail for real-world production code!

**Link to work:** [Day 15 - Allow One Call (Advanced)](./Day15/day15-allow-one-call-advanced.js)

### Day 16: April 2, 2026

**Today's Progress:** Kept the streak alive on a very busy day by revisiting the "Return Length of Arguments Passed" problem (#2703). Instead of just submitting the basic solution, I explored three different ways to interact with function arguments in JavaScript.

**Thoughts:** I used today to dive deeper into JS fundamentals. I wrote three variations of the solution:

1. The modern ES6 approach using the rest parameter (`...args`).
2. The legacy ES5 approach using the hidden, array-like `arguments` object (which is a great piece of trivia for interviews).
3. A manual algorithmic approach that counts the arguments without relying on the built-in `.length` property.
   It was a great way to turn a simple problem into a deeper learning moment!

**Link to work:** [Day 16 - Arguments Length (Advanced)](./Day16/day16-arguments-length-advanced.js)

### Day 17: April 3, 2026

**Today's Progress:** Kept the momentum going on a packed day! I utilized spaced repetition to re-solve problem #2629: Function Composition, upgrading my approach to a more advanced, declarative syntax.

**Thoughts:** When I first solved this problem, I used a standard reverse `for` loop to evaluate the functions from right to left. Today, I challenged myself to write cleaner, more idiomatic JavaScript. I refactored the solution to use `Array.prototype.reduceRight()`. Passing the initial input `x` as the starting accumulator allows `reduceRight` to cleanly pass the output of one function directly into the next without needing any mutable external variables. It turns a multi-line loop into a clean one-liner!

**Link to work:** [Day 17 - Function Composition (Advanced)](./Day17/day17-function-composition-advanced.js)

### Day 18: April 4, 2026

**Today's Progress:** Pushed through a very busy day to maintain the streak! I revisited problem #2626: Array Reduce Transformation, but I completely changed my algorithmic approach to use Recursion instead of Iteration.

**Thoughts:** Solving a problem with a `for` loop is straightforward, but I wanted to challenge myself to solve this without using any loops at all. I implemented a recursive helper function that tracks the current index and the accumulated value. This approach requires a solid understanding of base cases and the JavaScript call stack. It is a fantastic way to practice functional programming concepts and prepare for technical interview follow-up questions!

**Link to work:** [Day 18 - Array Reduce (Recursive)](./Day18/day18-array-reduce-recursive.js)

### Day 19: April 5, 2026

**Today's Progress:** Tackled problem #2727: Is Object Empty.

**Thoughts:** I initially solved this using a clean ternary operator with `Object.keys()`. However, the prompt challenged me to find an `O(1)` time complexity solution. I learned that `Object.keys()` is actually an `O(n)` operation because it has to iterate through the entire object to build an array of keys in memory. To achieve true `O(1)` time, I used a `for...in` loop. If the object or array has even a single item, the loop executes once, instantly returns `false`, and exits. If it's empty, the loop skips and returns `true`. Efficient and clever!

**Link to work:** [Day 19 - Is Object Empty](./Day19/day19-is-object-empty.js)

### Day 20: April 6, 2026

**Today's Progress:** Reached the 20-day milestone! Solved problem #2677: Chunk Array.

**Thoughts:** To recreate the behavior of Lodash's `_.chunk` method, I used a `for` loop but modified the incrementer to step forward by the target `size` instead of just `1`. Inside the loop, using `Array.prototype.slice(i, i + size)` safely extracts the exact chunk needed. One of the great things about `slice()` is that it naturally handles the edge case where the remaining elements are fewer than the chunk size—it just grabs whatever is left until the end of the array without throwing an out-of-bounds error.

**Link to work:** [Day 20 - Chunk Array](./Day20/day20-chunk-array.js)

### Day 21: April 7, 2026

**Today's Progress:** Pushed through a very busy day to keep the streak alive! I utilized spaced repetition to revisit problem #2634: Filter Elements from Array, but I implemented a completely different functional approach.

**Thoughts:** Writing a basic `for` loop to filter an array is easy, so I challenged myself to build a `filter` polyfill using `Array.prototype.reduce()`. It is a great exercise in functional programming. By passing an empty array `[]` as the initial value to the reducer, I can conditionally `push` items into the accumulator only if they pass the callback function `fn`. It proves that `reduce` is the ultimate "Swiss Army Knife" of JavaScript array methods!

**Link to work:** [Day 21 - Filter Elements (Advanced)](./Day21/day21-filter-elements-advanced.js)

### Day 22: April 8, 2026

**Today's Progress:** Solved problem #2619: Array Prototype Last.

**Thoughts:** This was a great exercise in extending JavaScript's built-in objects by modifying the prototype chain (`Array.prototype`). I learned that inside a prototype method, the `this` keyword refers to the specific instance of the array calling the method. While the classic `this[this.length - 1]` approach works perfectly, I implemented a cleaner, more modern version using the ES2022 `Array.prototype.at()` method, which natively supports negative indexing!

**Link to work:** [Day 22 - Array Prototype Last](./Day22/day22-array-prototype-last.js)

### Day 23: April 9, 2026

**Today's Progress:** Solved a Medium-level problem today! #2631: Group By.

**Thoughts:** I was tasked with writing a polyfill for a `groupBy` method on the `Array.prototype`. My initial logic used a standard `for` loop to build out an object dictionary. However, I decided to refactor this into a purely functional approach using `Array.prototype.reduce()`. It was a massive "aha!" moment to realize that the `reduce` accumulator doesn't just have to be a number or an array—it can be an entirely new Object! By starting with an empty object `{}`, I dynamically generated keys using the callback function `fn` and pushed the items into their respective arrays, returning the object on each iteration.

**Link to work:** [Day 23 - Group By](./Day23/day23-group-by.js)

### Day 24: April 10, 2026

**Today's Progress:** Solved problem #2724: Sort By.

**Thoughts:** Writing the custom comparator function `(a, b) => fn(a) - fn(b)` to sort an array of objects based on a callback's mathematical output was straightforward. However, I used this problem to review the concept of **Immutability**. The native `Array.prototype.sort()` method sorts elements in place, mutating the original array. Since unpredictable mutations can cause major bugs in modern UI state management, I upgraded my solution to use the ES6 spread operator (`[...arr].sort(...)`). This guarantees my function remains pure and returns a brand new sorted array without altering the original input!

**Link to work:** [Day 24 - Sort By](./Day24/day24-sort-by.js)
