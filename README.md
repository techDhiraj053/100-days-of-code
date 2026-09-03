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

### Day 25: April 11, 2026

**Today's Progress:** Hit the quarter-century mark! Day 25. I revisited problem #2635: Apply Transform Over Each Element in Array.

**Thoughts:** I initially solved this map polyfill using a standard imperative `for` loop. Today, I wanted to challenge myself to write a purely functional solution. I implemented the custom `.map()` method by leveraging `Array.prototype.reduce()`. By passing an empty array as the initial value to the reducer, I was able to sequentially transform each item and push it into the accumulated array. It's a great exercise that proves `reduce` really is the foundational building block for almost all other array transformations in JavaScript!

**Link to work:** [Day 25 - Array Map (Advanced)](./Day25/day25-array-map-advanced.js)

### Day 26: April 12, 2026

**Today's Progress:** Pushed through despite feeling pretty under the weather to keep the streak alive! I revisited problem #2665: Counter II, upgrading the architecture from functional closures to Object-Oriented Programming.

**Thoughts:** My original solution to this problem relied on JavaScript closures to hide and maintain the `current` state inside a returned object. Today, I challenged myself to rewrite it using ES6 Classes. I created a `Counter` class with a `constructor` to manage the `initValue` and `currentValue` states, and attached the methods directly to the class. It is a great exercise in understanding how different paradigms (Functional vs OOP) can be used to solve the exact same state-management problems in modern JavaScript!

**Link to work:** [Day 26 - Counter II (OOP)](./Day26/day26-counter-ii-oop.js)

### Day 27: April 13, 2026

**Today's Progress:** Still recovering, but managed to solve a Medium-level problem! #2722: Join Two Arrays by ID.

**Thoughts:** This problem was a great test of dictionary mapping and object merging. I iterated through the arrays and used the `id` as a key in a Hash Map dictionary. To merge objects with identical IDs, I used the ES6 spread operator (`{ ...obj1, ...obj2 }`). Because the spread operator evaluates from left to right, any overlapping properties from the second array seamlessly overwrite the first. I also learned about the "Sparse Array Trap"—making sure to initialize my map as an Object `{}` rather than an Array `[]` to prevent memory bloat if the numerical IDs have massive gaps between them!

**Link to work:** [Day 27 - Join Two Arrays](./Day27/day27-join-arrays.js)

### Day 28: April 14, 2026

**Today's Progress:** Solved a Medium-level data structure problem! #2625: Flatten Deeply Nested Array.

**Thoughts:** I needed to write a polyfill for `Array.prototype.flat()`, but with a specific depth constraint. I implemented a Depth-First Search (DFS) algorithm using a recursive `helper` function. By iterating through the arrays and checking `Array.isArray(item) && depth > 0`, I could carefully control how many layers deep the flattening goes. Using a closure to hold the `result` array and pushing items one-by-one is highly optimal—it prevents the call stack overflow errors that can happen when using the ES6 spread operator on massive, highly-nested datasets.

**Link to work:** [Day 28 - Flatten Array](./Day28/day28-flatten-nested-array.js)

### Day 29: April 15, 2026

**Today's Progress:** Still fighting off a fever, but kept the streak alive! Revisited problem #2704: To Be Or Not To Be, and upgraded the underlying architecture.

**Thoughts:** This problem asks you to build a mini assertion library. When I first solved it, I used a basic functional closure. Today, to show progression, I refactored it using Object-Oriented Programming (ES6 Classes). By creating an `Assertion` class, the `expect` wrapper function simply returns a new instance of that class. This is a much closer representation of how professional testing frameworks like Jest actually operate under the hood!

**Link to work:** [Day 29 - To Be Or Not To Be (OOP)](./Day29/day29-to-be-or-not-to-be-oop.js)

### Day 30: April 16, 2026

**Today's Progress:** I hit the 30-Day Milestone! 🎉 Even though I have been fighting off a fever for the last week, I refused to break the streak. Today I revisited problem #2620: Counter, but completely overhauled the underlying architecture.

**Thoughts:** My original solution to this problem relied on a basic lexical closure to store and increment the state of `n`. To challenge myself and celebrate Day 30, I rewrote the solution using an **ES6 Generator Function** (`function*`). By setting up a `while(true)` loop and using the `yield` keyword, the generator pauses execution after returning a value and remembers its state for the next call. It is incredibly satisfying to use advanced concepts like lazy evaluation to solve state-management problems!

**Link to work:** [Day 30 - Counter (Generators)](./Day30/day30-counter-generator.js)

### Day 31: April 17, 2026

**Today's Progress:** Officially starting Month 2! Still recovering from this prolonged fever, but I knocked out problem #2705: Compact Object.

**Thoughts:** I initially solved this using a standard recursive Depth-First Search with imperative `for...of` and `for...in` loops. To celebrate hitting Day 31, I refactored the logic to use a purely functional approach. I utilized `obj.map(compactObject).filter(Boolean)` for the array handling, which is incredibly elegant. For the object handling, I brought back my trusty friend `Array.prototype.reduce()` to iterate through the object keys and conditionally build a brand new, compacted object. This declarative style is much cleaner and highly readable!

**Link to work:** [Day 31 - Compact Object](./Day31/day31-compact-object.js)

### Day 32: April 18, 2026

**Today's Progress:** Solved problem #2695: Array Wrapper.

**Thoughts:** This problem was a fascinating dive into JavaScript's implicit type coercion. When you try to add two objects together with the `+` operator, JS automatically looks for a `valueOf()` method. I initially solved this using ES5 prototype mutation, but I refactored it into a clean ES6 `class` to reflect modern standards. Inside the class, overriding `valueOf()` with a `.reduce()` sum, and overriding `toString()` with a template literal and `.join(',')` allowed my custom objects to behave exactly like native primitives!

**Link to work:** [Day 32 - Array Wrapper (ES6 Class)](./Day32/day32-array-wrapper-class.js)

### Day 33: April 19, 2026

**Today's Progress:** Solved a Medium-level systems design problem! #2694: Event Emitter.

**Thoughts:** Today I built a custom Publisher/Subscriber (Pub/Sub) class, similar to Node.js's `EventEmitter` or the DOM's Event Target interface. My initial instinct was to use a standard JavaScript object dictionary with arrays to hold the callbacks, and `Array.filter()` to handle unsubscribing. However, `filter()` is an $O(n)$ operation. To make this class production-ready for thousands of listeners, I refactored it to use a `Map` for the event dictionary and `Set`s for the callbacks. This brilliant optimization drops the time complexity of the `unsubscribe` method down to $O(1)$!

**Link to work:** [Day 33 - Event Emitter](./Day33/day33-event-emitter.js)

### Day 34: April 20, 2026

**Today's Progress:** Double feature today! Solved problem #2726: Calculator with Method Chaining in JavaScript, and then switched gears to solve problem #2078: Two Furthest Houses With Different Colors in Java.

**Thoughts:** 1. **Calculator:** Built a "Fluent Interface" using ES2022 private class fields (`#result`) to encapsulate state and allow method chaining. 2. **Furthest Houses:** It felt great to jump into some Java! Instead of a brute-force $O(N^2)$ nested loop, I used a greedy approach. The maximum distance will always be bounded by either the first house or the last house. By doing two linear passes, I brought the time complexity down to $O(N)$. I also focused heavily on "Clean Code" principles, ensuring my variable names (`firstHouse`, `lastHouse`) were entirely self-documenting!

**Link to work:** \* [Calculator Chaining](./Day34/day34-calculator-chaining.js)

- [Two Furthest Houses](./Day34/TwoFurthestHouses.java)

### Day 35: April 21, 2026

**Today's Progress:** Tackled graph theory and connected components! Solved problem #1722: Minimize Hamming Distance After Swap Operations.

**Thoughts:** This Medium problem essentially asks you to find isolated groups of indices that can be freely swapped with one another. I recognized this as a classic use-case for the **Union-Find (Disjoint Set)** algorithm. After mapping out the connected components, I tallied the source values and matched them against the target values. To make my Java solution production-ready, I implemented **Union by Rank** alongside Path Compression in my Union-Find class, ensuring the tree never skews and graph operations remain $O(\alpha(N))$. I also made the `UnionFind` helper a `static class` to prevent implicit memory references to the outer class!

**Link to work:** [Day 35 - Minimize Hamming Distance](./Day35/MinimizeHammingDistance.java)

### Day 36: April 22, 2026

**Today's Progress:** Solved a string manipulation problem! #2452: Words Within Two Edits of Dictionary.

**Thoughts:** This problem asked us to compare a list of query words against a dictionary to find which ones could match with a maximum of 2 character replacements. My core helper function utilized an early-exit loop, abandoning the comparison the second a 3rd mismatch was detected to save CPU cycles. However, the real focus today was upgrading the overall architecture. I replaced my nested imperative `for` loops with the **Java Streams API**. By using `Arrays.stream(queries).filter(...)` combined with an inner `.anyMatch(...)`, I was able to write highly declarative code that perfectly mirrors the functional programming patterns I mastered in JavaScript!

**Link to work:** [Day 36 - Words Within Two Edits](./Day36/WordsWithinTwoEdits.java)

### Day 37: April 23, 2026

**Today's Progress:** Solved a math-heavy Medium problem! #2615: Sum of Distances.

**Thoughts:** To avoid an $O(N^2)$ Time Limit Exceeded error, I used a Hash Map to group the indices of identical elements together. From there, I utilized a mathematical prefix-sum trick. To make my solution production-ready, I implemented a **Running Sum Space Optimization**. Instead of allocating a brand new prefix array for every single group in memory, I kept track of the data using `leftSum` and `rightSum` pointer variables. As I iterated through the list, I dynamically shifted the values from right to left, allowing me to calculate the absolute distances mathematically without the extra garbage collection overhead!

**Link to work:** [Day 37 - Sum of Distances](./Day37/SumOfDistances.java)

### Day 38: April 24, 2026

**Today's Progress:** Solved a greedy math string problem! #2833: Furthest Point From Origin.

**Thoughts:** This problem was a great exercise in algorithmic simplification. Instead of simulating actual movements, I used a greedy mathematical approach. I counted the occurrences of 'L', 'R', and `_`. By letting the L's and R's cancel each other out, I could just add the count of `_` blanks to the absolute difference of the forced moves. To make this code as performant as possible, I focused on memory optimization. I swapped out my original `moves.toCharArray()` loop for a standard `moves.charAt(i)` loop. This simple change prevents Java from allocating a brand new character array in memory, dropping the space complexity down to absolute $O(1)$!

**Link to work:** [Day 38 - Furthest Point From Origin](./Day38/FurthestPointFromOrigin.java)

### Day 39: April 25, 2026

**Today's Progress:** Solved a LEETCODE HARD! 🎉 #3464: Maximize the Distance Between Points on a Square.

**Thoughts:** Solving a Hard problem this early in the 100-day challenge feels incredible. To solve this, I completely reimagined the geometry. Instead of dealing with 2D coordinates on a square, I "unfolded" the perimeter into a 1D line and duplicated the array to simulate circular wrap-around. From there, I utilized **Binary Search on Answer**. By guessing the maximum distance (`mid`), I ran a greedy algorithm (using a secondary binary search `lowerBound`) to verify if `k` points could be placed at that specific distance. Today's focus was heavily on enterprise-level documentation—adding detailed architectural comments so anyone reading the code instantly understands the three-phase logic!

**Link to work:** [Day 39 - Maximize Distance on Square](./Day39/MaximizeDistanceOnSquare.java)

### Day 40: April 26, 2026

**Today's Progress:** Hit the Day 40 milestone! Solved problem #88: Merge Sorted Array.

**Thoughts:** This is a classic array manipulation problem. The easiest approach is to dump the second array into the first and run a built-in sort function, but that is inefficient ($O(K \log K)$). Instead, I implemented an optimal **Reverse Three-Pointer** strategy. Because `nums1` has empty buffer space at the end, I started my pointers at the _back_ of both arrays and merged them in descending order. This guarantees we never overwrite un-processed elements, giving an optimal $O(m+n)$ time complexity and $O(1)$ space complexity. Today's focus was on "Clean Code"—ensuring my pointer variables (`p1`, `p2`, `pMerge`) were perfectly descriptive for code reviews!

**Link to work:** [Day 40 - Merge Sorted Array](./Day40/MergeSortedArray.java)

### Day 41: April 27, 2026

**Today's Progress:** Knocked out problem #27: Remove Element.

**Thoughts:** Today I implemented a highly efficient in-place array modification using the Two-Pointer technique. The problem asks us to remove all occurrences of a specific value without allocating any extra memory for a new array. By using a standard `for` loop, I treated `i` as my "reader" pointer and `k` as my "writer" pointer. Every time the reader found a value that we wanted to keep, it overwrote the element at the writer's index and incremented `k`. This resulting code is mathematically optimal with $O(N)$ time and $O(1)$ space!

**Link to work:** [Day 41 - Remove Element](./Day41/RemoveElement.java)

### Day 42: April 28, 2026

**Today's Progress:** Solved problem #26: Remove Duplicates from Sorted Array.

**Thoughts:** Back-to-back Two-Pointer array problems! Since the input array was already sorted in non-decreasing order, I knew any duplicate values would be sitting right next to each other. I used a fast pointer to scan through the array and compare each element to the one immediately before it. If they were different, it meant I found a new unique number. I then used a slow pointer (`insertIndex`) to overwrite the array in-place. By refactoring my initial `while` loop into a sleek `for` loop, I was able to eliminate redundant counter variables, keeping the solution strictly at $O(N)$ time and $O(1)$ space!

**Link to work:** [Day 42 - Remove Duplicates](./Day42/RemoveDuplicates.java)

### Day 43: April 29, 2026

**Today's Progress:** Solved a Medium array problem! #80: Remove Duplicates from Sorted Array II.

**Thoughts:** A fantastic step up from yesterday's problem! This time, we were allowed to keep up to _two_ duplicates of each number. Instead of complicating the logic with tracking variables and hash maps, I stuck to the Two-Pointer technique. Because the array is sorted, I simply checked if my current reading pointer was pointing to a number different from the number sitting exactly two spaces behind my writing pointer (`nums[i] != nums[insertIndex - 2]`). This elegant comparison automatically handles the pair limit, allowing me to modify the array in-place with an optimal $O(N)$ time and $O(1)$ space complexity!

**Link to work:** [Day 43 - Remove Duplicates II](./Day43/RemoveDuplicatesII.java)

### Day 44: April 30, 2026

**Today's Progress:** Conquered a classic algorithmic problem! #169: Majority Element.

**Thoughts:** This problem challenges you to find the element that appears more than `⌊n / 2⌋` times. While a HashMap ($O(N)$ space) or sorting the array ($O(N \log N)$ time) works, the prompt included a strict follow-up to solve it in $O(N)$ time and $O(1)$ space. To achieve this, I implemented the **Boyer-Moore Voting Algorithm**. I maintained a `candidate` variable and a `count`. By iterating through the array and adding a vote when encountering the candidate (and subtracting a vote when encountering a different number), the true majority element is mathematically guaranteed to survive. I refactored the logic using a `for-each` loop and a ternary operator for maximum readability!

**Link to work:** [Day 44 - Majority Element](./Day44/MajorityElement.java)

### Day 45: May 1, 2026

**Today's Progress:** Conquered problem #189: Rotate Array.

**Thoughts:** To satisfy the strict follow-up constraint of using $O(1)$ extra space, I implemented the classic "Triple Reverse" algorithm. Instead of trying to shift elements individually (which would take $O(N^2)$ time) or creating a secondary array (which would take $O(N)$ space), I used a mathematical trick. By reversing the entire array, then reversing the first `k` elements, and finally reversing the remaining elements, the array magically shifts into the perfect rotated position! I also added an enterprise-grade "Fail-Fast Guard Clause" at the beginning of the function to immediately return if `k % n == 0` or if the array length is 1, saving unnecessary CPU cycles.

**Link to work:** [Day 45 - Rotate Array](./Day45/RotateArray.java)

### Day 46: May 2, 2026

**Today's Progress:** Tackled a legendary interview problem! #121: Best Time to Buy and Sell Stock.

**Thoughts:** This is a classic problem that tests whether you can optimize an O(N²) brute-force solution into a single O(N) pass. I used a greedy approach to solve it. By iterating through the timeline just once, I continuously updated the `minPrice` to reflect the absolute cheapest day to buy that I had seen so far. At every step, I calculated the potential profit if I were to sell on that current day (`price - minPrice`) and checked if it beat my running `maxProfit` record. To make my code production-ready, I swapped my standard `for` loop for an enhanced `for-each` loop, making the logic incredibly clean and completely avoiding unnecessary index lookups!

**Link to work:** [Day 46 - Best Time to Buy and Sell Stock](./Day46/BestTimeToBuyAndSellStock.java)

### Day 47: May 3, 2026

**Today's Progress:** Solved the sequel! #122: Best Time to Buy and Sell Stock II.

**Thoughts:** Building on yesterday's stock problem, this variation allows us to buy and sell multiple times. The trap here is overcomplicating it with complex peak/valley tracking. Instead, I used a Greedy approach. By looking at every adjacent pair of days, I simply captured the profit of any upward movement. If the price tomorrow is higher than today, I "buy" today and "sell" tomorrow. By accumulating all these positive deltas, I naturally capture the maximum possible profit. To polish the code, I implemented **Branchless Programming**, replacing the `if` condition with `Math.max(0, prices[i] - prices[i-1])`. This keeps the Time Complexity at $O(N)$ and Space at $O(1)$ while reducing cyclomatic complexity!

**Link to work:** [Day 47 - Best Time to Buy and Sell Stock II](./Day47/BestTimeToBuyAndSellStockII.java)

### Day 48: May 4, 2026

**Today's Progress:** Conquered a classic Array problem! #55: Jump Game.

**Thoughts:** This problem is famous for tricking people into using heavy Dynamic Programming solutions. Instead, I used a highly efficient Greedy Algorithm. By iterating through the array and continuously updating a `maxReach` variable, I could verify if every subsequent index was actually reachable. If my loop ever reached an index greater than `maxReach`, it meant I was trapped, returning `false`. To make this algorithm production-grade, I implemented an **Early Exit Optimization**. I added a check to verify if `maxReach >= nums.length - 1`. The second this condition becomes true, the function immediately terminates and returns `true`, completely bypassing any remaining loop iterations!

**Link to work:** [Day 48 - Jump Game](./Day48/JumpGame.java)

### Day 49: May 5, 2026

**Today's Progress:** Solved the sequel! #45: Jump Game II.

**Thoughts:** Building on the logic from yesterday's Jump Game, this variation asks for the _minimum_ number of jumps to reach the end. I stuck with a Greedy algorithm. Instead of just tracking `maxReach`, I introduced a `currentJumpWindowEnd` variable. As I iterate through a "window" of reachable indices, I constantly update the farthest possible reach. The moment my loop reaches the end of the current window, I increment my jump counter and start a new window. To optimize the code for production, I added an **Aggressive Early Exit**. If the `farthestReach` ever meets or exceeds the last index of the array, I immediately return `jumps + 1`, completely short-circuiting the rest of the iterations!

**Link to work:** [Day 49 - Jump Game II](./Day49/JumpGameII.java)

### Day 50: May 6, 2026 🎉 HALFWAY MILESTONE! 🎉

**Today's Progress:** Hit the official halfway point of the challenge! Solved #274: H-Index.

**Thoughts:** I cannot believe I've made it to Day 50! For today's problem, my initial logic was to sort the array and iterate backwards to increment my H-Index, which gave a solid $O(N \log N)$ time. However, to celebrate Day 50, I pushed for the absolute optimal solution: **$O(N)$ Time Complexity using Bucket Sort**. I realized the H-Index can never exceed the total number of papers ($N$). Therefore, I created an array of buckets from $0$ to $N$. Any paper with massive citations got capped and tossed into the $N$ bucket. By scanning the buckets backwards and keeping a running total, I bypassed the heavy sorting algorithm entirely! Here is to the next 50 days! 🚀

**Link to work:** [Day 50 - H-Index](./Day50/HIndex.java)

### Day 51: May 7, 2026

**Today's Progress:** Kicked off the second half of the challenge! Solved #380: Insert Delete GetRandom O(1).

**Thoughts:** This was a fantastic system design problem. Achieving an average O(1) time complexity across all three operations requires combining two different data structures: a `HashMap` (for fast lookups and deletes) and an `ArrayList` (for fast random access). The major hurdle is that deleting from the middle of an `ArrayList` normally takes O(N) time because elements have to shift. I solved this using the **"Swap and Pop"** algorithm. By swapping the element I wanted to delete with the very last element in the array, I could simply pop the end of the array off in O(1) time! To make the class enterprise-ready, I utilized `private` and `final` access modifiers to strictly encapsulate the internal data structures.

**Link to work:** [Day 51 - Randomized Set](./Day51/RandomizedSet.java)

### Day 52: May 8, 2026

**Today's Progress:** Conquered a legendary array problem! #238: Product of Array Except Self.

**Thoughts:** This problem has a clever trick: you must find the product of all elements except the current one, but you are _not_ allowed to use division! My initial logic was to create two separate arrays to store the prefix (left) products and suffix (right) products, and then multiply them together, giving me an $O(N)$ time solution. However, to conquer the strict follow-up challenge of using $O(1)$ extra space, I optimized the architecture. I stored the left products directly inside the final `answer` array. Then, instead of building a right array, I iterated backwards using a single `rightProduct` integer variable, calculating the suffix on the fly and multiplying it directly into the `answer` array!

**Link to work:** [Day 52 - Product of Array Except Self](./Day52/ProductOfArrayExceptSelf.java)

### Day 53: May 9, 2026

**Today's Progress:** Conquered a classic Greedy algorithm! #134: Gas Station.

**Thoughts:** This problem is a brilliant test of algorithmic intuition. A brute-force approach trying to complete a circuit from every index would result in a Time Limit Exceeded $O(N^2)$ penalty. Instead, I used a Greedy $O(N)$ approach. I kept a running total of the `netGas` (`gas[i] - cost[i]`). If my local tank ever dropped below zero, it proved that my current starting station (and any station I had visited along the way) was invalid. I immediately reset my tank and shifted my starting candidate to the next station (`i + 1`). I also tracked the `totalSurplus` across the entire array; if the final total surplus is $\ge 0$, my current starting candidate is mathematically guaranteed to be the unique solution!

**Link to work:** [Day 53 - Gas Station](./Day53/GasStation.java)

### Day 54: May 10, 2026

**Today's Progress:** Solved a LeetCode HARD! 🍬 #135: Candy.

**Thoughts:** This problem is a brilliant test of Greedy algorithms. The rules dictate that children with higher ratings than their neighbors must receive more candy. Trying to calculate this in a single pass usually leads to messy edge cases when dealing with descending ratings (valleys). I bypassed this completely by using the **Two-Pass Greedy Algorithm**. First, I swept left-to-right to satisfy the left-neighbor condition. Then, I swept right-to-left using `Math.max()` to satisfy the right-neighbor condition while preserving the previous logic. To optimize my solution for production, I used **Loop Fusion**. Instead of looping a third time to sum up the array, I accumulated the total directly during the right-to-left pass, eliminating an entire $O(N)$ operation!

**Link to work:** [Day 54 - Candy](./Day54/Candy.java)

### Day 55: May 11, 2026

**Today's Progress:** Another LeetCode Hard secured! 🌧️ #42: Trapping Rain Water.

**Thoughts:** This is one of the most famous array problems out there. My initial approach was Dynamic Programming: I created two arrays (`leftMax` and `rightMax`) to store the highest peaks to the left and right of every index. By finding the minimum of those two peaks and subtracting the ground height, I accurately calculated the trapped water in $O(N)$ time. However, to level up my code, I refactored it to use the **Two-Pointer Approach**, slashing the space complexity to absolute $O(1)$! By starting pointers at opposite ends of the array and selectively moving the shorter pointer inward, I was able to maintain running `leftMax` and `rightMax` variables, filling the valleys with water in a single, highly-optimized pass!

**Link to work:** [Day 55 - Trapping Rain Water](./Day55/TrappingRainWater.java)

### Day 56: May 12, 2026

**Today's Progress:** Solved a classic parsing problem! #13: Roman to Integer.

**Thoughts:** This problem is a great test of algorithmic string parsing. The main trick is handling the subtraction instances (like IV for 4 or IX for 9). My initial intuition was to read left-to-right, looking ahead to the next character. If the current character was smaller than the next, I subtracted it; otherwise, I added it. While this worked perfectly, I had to stop the loop early to avoid out-of-bounds errors and manually process the last character. To level up my code, I refactored the logic to use a **Right-to-Left Traversal**. By starting at the end of the string and moving backwards, I only needed to compare my current value against a running `prevValue`. This allowed me to process the entire string inside a single, clean loop! I also swapped my `if` chain for a cleaner `switch` statement.

**Link to work:** [Day 56 - Roman to Integer](./Day56/RomanToInteger.java)

### Day 57: May 13, 2026

**Today's Progress:** Solved the reverse of yesterday! #12: Integer to Roman.

**Thoughts:** To convert an integer to a Roman numeral, I implemented a **Greedy Algorithm**. Because Roman numerals are written largest to smallest, I created two parallel arrays matching values to their corresponding symbols (including the subtraction edge cases like 900 for "CM"). I looped through these arrays, using a `while` loop to repeatedly subtract the largest possible value from my number and append the symbol to a `StringBuilder`. To make this code enterprise-grade, I pulled the arrays outside of the method and declared them as `private static final` constants. This memory optimization ensures the arrays are only allocated once, rather than every time the function is called!

**Link to work:** [Day 57 - Integer to Roman](./Day57/IntegerToRoman.java)

### Day 58: May 14, 2026

**Today's Progress:** Conquered string parsing! #58: Length of Last Word.

**Thoughts:** This problem is a great test of avoiding "built-in method" traps. Using `s.trim().split(" ")` is tempting, but it allocates unnecessary arrays and strings in memory, pushing the space complexity to $O(N)$. To keep my solution at an optimal $O(1)$ space, I wrote a manual pointer traversal. I started from the right side of the string and moved left. To make the code as clean as possible, I used **Loop Consolidation**. Inside a single `for` loop, I checked if the current character was a letter or a space. If it was a space and my word count was still 0, I ignored it (handling trailing spaces). If it was a space and my count was $> 0$, it meant I had finished reading the last word and could instantly `break` the loop!

**Link to work:** [Day 58 - Length of Last Word](./Day58/LengthOfLastWord.java)

### Day 59: May 15, 2026

**Today's Progress:** Solved a classic string comparison problem! #14: Longest Common Prefix.

**Thoughts:** This problem is a great exercise in string traversal. I used the **Horizontal Scanning** approach. I started by taking the entire first string and assuming it was the common prefix. Then, I iterated through the rest of the array. For each string, I used a `while` loop to check if it started with my current prefix. If it didn't, I chopped off the last character of my prefix using `.substring()` and checked again. This efficiently whittles down the prefix to the correct length! To make my code production-ready, I added a fail-fast guard clause for empty arrays and replaced the `.indexOf() != 0` check with Java's idiomatic `.startsWith()` method, which makes the logic incredibly easy to read.

**Link to work:** [Day 59 - Longest Common Prefix](./Day59/LongestCommonPrefix.java)

### Day 60: May 16, 2026

**Today's Progress:** Hit Day 60! Conquered #151: Reverse Words in a String.

**Thoughts:** My initial approach for this was highly readable: I used `s.trim()` to clean the edges and `s.split("\\s+")` to break the string into an array of words, filtering out multiple spaces using regex. Then, I just iterated backward and appended them to a `StringBuilder`. While it worked perfectly, I wanted to optimize it further. Calling `.split()` invokes Java's Regex engine and allocates a secondary array in memory. To make the code leaner, I eliminated the regex entirely. Building on the string traversal logic I used a few days ago, I implemented a manual **Right-to-Left Two-Pointer** approach. By skipping spaces manually and tracking the start and end indices of each word, I could extract and append the words directly to my `StringBuilder`, saving CPU cycles and memory!

**Link to work:** [Day 60 - Reverse Words in a String](./Day60/ReverseWordsInAString.java)

### Day 61: May 17, 2026

**Today's Progress:** Kicked off a new phase of the challenge with #6: Zigzag Conversion.

**Thoughts:** This problem challenges you to route a string's characters across multiple rows in a zigzag pattern. Instead of mapping a complex 2D array, I used a **Boolean State Machine**. I instantiated an array of `StringBuilder` objects—one for each row. As I looped through the characters, I simply dropped each one into the `currentRow` and checked my `goingDown` boolean to decide whether to increment or decrement my row pointer. If I hit the top or bottom boundary, I flipped the boolean! To make this code enterprise-grade, I focused on **Memory Pre-allocation**. I gave my row `StringBuilder`s an estimated initial capacity and gave my final `ans` StringBuilder the exact capacity of `s.length()`, completely preventing Java from having to re-allocate arrays internally during runtime!

**Link to work:** [Day 61 - Zigzag Conversion](./Day61/ZigzagConversion.java)

### Day 62: May 18, 2026

**Today's Progress:** Conquered #28: Find the Index of the First Occurrence in a String.

**Thoughts:** This is the classic "Haystack and Needle" substring search problem. My first instinct was to write a manual **Sliding Window** algorithm: using an outer `for` loop to anchor my position in the haystack, and an inner `for` loop to check if the needle's characters matched one by one. While this $O(N \times M)$ approach works perfectly and proves I understand the underlying mechanics, I took a step back for my final solution. I learned that in Enterprise Java, the built-in `.indexOf()` method uses **JVM Intrinsics**—meaning it executes highly optimized, hardware-level instructions that are vastly faster than manual Java loops, all while maintaining strict $O(1)$ space complexity. Part of being a senior developer is knowing when to write the algorithm yourself, and when to let the framework do the heavy lifting!

**Link to work:** [Day 62 - Find Index of First Occurrence](./Day62/FindIndexFirstOccurrence.java)

### Day 63: May 19, 2026

**Today's Progress:** Conquered an infamous LeetCode Hard! #68: Text Justification.

**Thoughts:** This problem is notorious for its tedious edge cases. You have to pack strings into lines of exactly `maxWidth`, distribute spaces evenly, give leftover spaces to the leftmost gaps, and handle the final line completely differently! I tackled this using a **Greedy Algorithm**. First, I used a `while` loop to pack as many words into the current line as mathematically possible. Then, I split my logic into two cases: normal lines and the final line. For normal lines, I used division (`totalSpaces / gaps`) to apply the base spaces and modulo arithmetic (`totalSpaces % gaps`) to perfectly distribute the remainder to the left gaps. To make my solution enterprise-ready, I applied **Memory Pre-allocation**. Because every line must strictly equal `maxWidth`, I initialized my `StringBuilder` with `new StringBuilder(maxWidth)`, completely bypassing any internal array resizing operations!

**Link to work:** [Day 63 - Text Justification](./Day63/TextJustification.java)

### Day 64: May 20, 2026

**Today's Progress:** Conquered a classic string problem! #125: Valid Palindrome.

**Thoughts:** The trap with this problem is using Regex (like `s.replaceAll("[^a-zA-Z0-9]", "")`) or `StringBuilder.reverse()`. While those built-in methods are easy to write, they allocate new objects in memory, resulting in an $O(N)$ space complexity penalty. To keep it strictly at $O(1)$ space, I implemented a **Two-Pointer** approach. By placing pointers at both ends of the string and walking them inward, I used `Character.isLetterOrDigit()` to simply step over any spaces or punctuation. If the pointers landed on characters that didn't match (using `.toLowerCase()` to ensure case-insensitivity), I immediately returned false. To polish the code, I used descriptive variable names (`left` and `right`) and added a fast-failing guard clause!

**Link to work:** [Day 64 - Valid Palindrome](./Day64/ValidPalindrome.java)

### Day 65: May 21, 2026

**Today's Progress:** Conquered #392: Is Subsequence.

**Thoughts:** This problem is a brilliant test of the **Two-Pointer** technique. By setting up one pointer to track the required characters in `s` and a second pointer to scan through `t`, I was able to verify the subsequence in a single $O(N)$ pass using $O(1)$ space. However, the real meat of this problem is the Follow-Up question: how do you handle a billion incoming `s` strings? I documented the enterprise system design answer: **Precomputation and Binary Search**. By mapping every character in `t` to a list of its index positions, you can process incoming `s` strings in $O(|s| \log |t|)$ time by binary searching for the next valid index! For the actual code, I added a micro-optimization by converting the strings to `char[]` arrays, avoiding the slight overhead of bounds-checking inherent to Java's `.charAt()` method inside loops.

**Link to work:** [Day 65 - Is Subsequence](./Day65/IsSubsequence.java)

### Day 66: May 22, 2026

**Today's Progress:** Solved a classic variation! #167: Two Sum II - Input Array Is Sorted.

**Thoughts:** Standard "Two Sum" usually requires a HashMap to get an $O(N)$ time complexity, which costs $O(N)$ space. Because this variation guarantees the input array is already sorted, I was able to optimize the space complexity down to $O(1)$ by using the **Two-Pointer** technique! I placed pointers at both ends of the array. Since it's sorted, if my current sum was greater than the target, I decremented the right pointer to get a smaller value. If the sum was less than the target, I incremented the left pointer to get a larger value. To make this code production-ready, I focused on **Defensive Programming**. Because the problem constraints guarantee exactly one solution, I replaced the default return statement with an `IllegalArgumentException` to instantly alert the system if invalid data ever breached the function!

**Link to work:** [Day 66 - Two Sum II](./Day66/TwoSumII.java)

### Day 67: May 23, 2026

**Today's Progress:** Conquered a legendary Two-Pointer problem! #11: Container With Most Water.

**Thoughts:** The brute-force trap here is checking every possible pair of lines, which yields an `O(N²)` Time Limit Exceeded error. Instead, I used a **Two-Pointer** approach. By placing pointers at the far left and right, I started with the maximum possible width. Since the water level is bottlenecked by the shorter line, I calculated the area, then moved the pointer with the shorter line inward, hoping to find a taller boundary. To supercharge this algorithm, I implemented **Bypass Pruning**. Because moving inward reduces the width, any new line that isn't taller than my previous line is mathematically useless. I added inner `while` loops to rapidly skip past these shorter lines, bypassing redundant `Math.max()` calculations and resulting in a blazing-fast `O(N)` time complexity!

**Link to work:** [Day 67 - Container With Most Water](./Day67/ContainerWithMostWater.java)

### Day 68: May 24, 2026

**Today's Progress:** Solved a legendary interview problem! #15: 3Sum.

**Thoughts:** To avoid the disastrous $O(N^3)$ brute-force approach, I scaled up the logic I used for "Two Sum II". By sorting the array first ($O(N \log N)$), I could iterate through the array, anchor one number (`i`), and then use a standard **Two-Pointer** search (`left` and `right`) to find the remaining two numbers that sum to 0. This brings the time complexity down to a highly optimal $O(N^2)$. To ensure I didn't return duplicate triplets, I manually skipped duplicate values for all three pointers, which avoids the memory overhead of relying on a `HashSet`. To further optimize the code, I implemented **Early Exit Pruning**. Since the array is sorted, the moment my anchor number `nums[i]` becomes greater than `0`, it is mathematically impossible to reach a sum of `0` with the remaining positive numbers, allowing me to instantly break the loop!

**Link to work:** [Day 68 - 3Sum](./Day68/ThreeSum.java)

### Day 69: May 25, 2026

**Today's Progress:** Mastered dynamic sub-arrays! #209: Minimum Size Subarray Sum.

**Thoughts:** I initially solved this using the highly optimal **Sliding Window** technique. By expanding the `right` pointer to find a valid sum, and then shrinking the `left` pointer to find the minimal length, I achieved an $O(N)$ time complexity. However, to truly master the problem, I tackled the explicit LeetCode Follow-up question: designing an $O(N \log N)$ algorithm. Because the array only contains positive numbers, a **Prefix Sum** array will be strictly increasing (sorted). This allowed me to iterate through the array and use **Binary Search** (`Arrays.binarySearch`) to instantly look up the exact ending index required to meet the target sum. Being able to pivot from Sliding Window to Binary Search proves a deep understanding of algorithmic bounds!

**Link to work:** [Day 69 - Minimum Size Subarray Sum](./Day69/MinimumSizeSubarraySum.java)

### Day 70: May 26, 2026

**Today's Progress:** Hit Day 70 with a classic! #3: Longest Substring Without Repeating Characters.

**Thoughts:** This problem is the ultimate test of the **Sliding Window** pattern. My initial approach used a `HashSet` to track the characters inside my window. When my `right` pointer hit a duplicate, I used a `while` loop to slowly increment my `left` pointer and remove characters from the set until the duplicate was gone. While this worked well, I wanted absolute maximum efficiency. I swapped the `HashSet` for an **ASCII Direct-Access Array** (`int[128]`). Instead of storing booleans, I stored the _index_ where each character was last seen. By doing this, when I encountered a duplicate, I didn't need a `while` loop at all! I could instantly "jump" my `left` pointer to the index right after the duplicate (`left = charIndexMap[currentChar] + 1`). This optimization guarantees every single character is processed exactly once, yielding a strict single-pass $O(N)$ algorithm!

**Link to work:** [Day 70 - Longest Substring](./Day70/LongestSubstring.java)

### Day 71: May 27, 2026

**Today's Progress:** Took down a LeetCode Hard! #30: Substring with Concatenation of All Words.

**Thoughts:** This problem is a massive test of combining data structures and algorithms. You have to find substrings composed of a specific set of words. The core trick is that every target word is the _exact same length_. This means you don't need a sliding window that moves by 1 character checking every index. You just need a **Multi-Offset Sliding Window**. I ran a loop from $0$ to `wordLen - 1`. Inside that loop, my sliding window pointers jumped by `wordLen` chunks! I used two HashMaps: one to track the target word frequencies, and one to track the words `seen` in the current window. If I saw too many of a word, I shrunk the `left` pointer. If I saw a completely invalid word, I cleared the `seen` map and reset the window. To make this enterprise-ready, I allocated the `seen` HashMap exactly once outside of all the loops, relying on `.clear()` instead of `new HashMap<>()` to prevent massive Garbage Collection overhead!

**Link to work:** [Day 71 - Substring with Concatenation](./Day71/SubstringConcatenationAllWords.java)

### Day 72: May 28, 2026

**Today's Progress:** Solved the quintessential Sliding Window problem! #76: Minimum Window Substring.

**Thoughts:** This LeetCode Hard forces you to dynamically track state as a window expands and contracts. My initial approach used two HashMaps: one for the target string frequencies, and one for the current window. To make the validation step $O(1)$, I used a clever `have` and `required` variable pair to track when unique character conditions were met. To push this into enterprise-grade performance, I refactored the data structures. Because we are dealing with standard characters, I swapped the HashMaps for a direct-access ASCII array (`int[128]`). Then, instead of tracking unique character matches, I tracked the _raw total_ of required characters. As the right pointer expanded, if I found a needed character, I decremented `required`. When `required == 0`, the window was valid, and I could pull my left pointer in to shrink it! This easily satisfied the $O(m + n)$ time follow-up.

**Link to work:** [Day 72 - Minimum Window Substring](./Day72/MinimumWindowSubstring.java)

### Day 73: May 29, 2026

**Today's Progress:** Validated matrix structures! #36: Valid Sudoku.

**Thoughts:** Validating the rows and columns of a Sudoku board is easy, but mapping the 3x3 sub-boxes is the real challenge. I bypassed messy nested loops by using the mathematical formula `(r / 3) * 3 + (c / 3)`. This perfectly flattened the 2D grid coordinates into a 1D array index (0-8), allowing me to validate the entire board in a single $O(1)$ pass! To level up my code for an enterprise environment, I implemented **Bit Manipulation (Bitmasking)**. Instead of using `boolean[][]` arrays to track seen numbers, I used a `1D` array of integers. Because a standard integer has 32 bits, I used the first 9 bits to represent the digits 1-9. Using the bitwise AND operator (`&`) to check for duplicates and the bitwise OR operator (`|`) to log seen digits reduced my memory footprint significantly and leveraged ultra-fast hardware-level calculations!

**Link to work:** [Day 73 - Valid Sudoku](./Day73/ValidSudoku.java)

### Day 74: May 30, 2026

**Today's Progress:** Mastered the 2D grid! #54: Spiral Matrix.

**Thoughts:** Matrix traversals can easily turn into spaghetti code if you aren't careful with bounds checking. To solve this cleanly, I used the **4-Pointer Boundary** method. I established `top`, `bottom`, `left`, and `right` variables to act as "walls". I used `for` loops to walk along the walls in a spiral pattern, pushing the boundaries inward after every edge was completed. Crucially, I added inner `if` checks for the bottom and left traversals to ensure I didn't double-count cells when dealing with non-square rectangles! To make this enterprise-ready, I brought back **Memory Pre-allocation**. Because the exact size of a matrix is strictly `rows * cols`, I passed that value directly into my `ArrayList` constructor to ensure the underlying array never had to dynamically resize itself, achieving optimal $O(M \times N)$ execution!

**Link to work:** [Day 74 - Spiral Matrix](./Day74/SpiralMatrix.java)

### Day 75: May 31, 2026 🎉 75% MILESTONE! 🎉

**Today's Progress:** Hit the 3/4 mark of the challenge! Solved #48: Rotate Image.

**Thoughts:** I initially solved this using standard Linear Algebra operations: a Transpose followed by a Reverse. It's incredibly readable and satisfies the $O(1)$ space requirement. However, it requires traversing the matrix twice. To push my algorithmic limits, I implemented a **Single-Pass 4-Way Swap**. Building on the boundary logic from yesterday's "Spiral Matrix", I processed the grid layer by layer. Within each layer, I used a single temporary variable to simultaneously swap 4 coordinating cells (the four corners/edges) 90 degrees clockwise. This cut the runtime operations completely in half, showing a deep understanding of pointer math and in-place memory manipulation!

**Link to work:** [Day 75 - Rotate Image](./Day75/RotateImage.java)

### Day 76: June 1, 2026

**Today's Progress:** Kicked off the final quarter of the challenge! Solved #73: Set Matrix Zeroes.

**Thoughts:** This problem has a great follow-up: can you solve it in $O(1)$ constant space? I avoided allocating extra memory arrays by using the matrix's own first row and first column as "memory markers" to track which rows and columns needed to be zeroed out. To level up my code, I applied **State Variable Reduction**. Instead of using two separate boolean flags for the first row and column, I used `matrix[0][0]` to track the row and a single `col0` boolean to track the column. Furthermore, by traversing the matrix **backwards** (from bottom-right to top-left) during the update phase, I was able to safely consolidate my loops. Going backwards ensures that the marker zones are read _before_ they are accidentally overwritten by the zeroes propagating upward!

**Link to work:** [Day 76 - Set Matrix Zeroes](./Day76/SetMatrixZeroes.java)

### Day 77: June 2, 2026

**Today's Progress:** Built a classic cellular automaton! #289: Game of Life.

**Thoughts:** This problem is famous for a reason. The challenge is that births and deaths must happen _simultaneously_. If you update a cell immediately, it corrupts the neighbor count for adjacent cells. Creating a second matrix solves this but costs $O(M \times N)$ space. My initial $O(1)$ space solution used `-1` and `2` as temporary placeholders to represent state changes. To optimize this into an enterprise-grade solution, I implemented **Bitwise State Encoding**. Because the grid only uses `0`s and `1`s, only the 1st bit of the integer is occupied. I calculated the neighbor counts by reading only the 1st bit (`board[r][c] & 1`), and then I stored the _future_ state in the 2nd bit using the bitwise OR operator (`board[i][j] |= 2`). Finally, to advance to the next generation, I simply shifted every integer right by one (`>>= 1`), which instantly replaced the old state with the new one!

**Link to work:** [Day 77 - Game of Life](./Day77/GameOfLife.java)

### Day 78: June 3, 2026

**Today's Progress:** Solved a classic frequency counting problem! #383: Ransom Note.

**Thoughts:** The standard logical approach for this problem is to build a frequency map of the `magazine` characters and then iterate through the `ransomNote` to see if you have enough letters in your "bank". While a `HashMap` works perfectly for this and gives an $O(M + N)$ time complexity, it isn't the most optimal choice for this specific problem. The constraints specify that the inputs will _only_ consist of lowercase English letters. As a senior optimization, I replaced the heavy `HashMap` with a simple **Alphabet Array** (`int[26]`). By doing `c - 'a'`, I dynamically mapped every character to an index from 0 to 25. This eliminated all autoboxing and hashing overhead, making the algorithm lightning fast while maintaining strict $O(1)$ space! I also added a fast-failing guard clause to immediately return `false` if the ransom note is longer than the magazine itself.

**Link to work:** [Day 78 - Ransom Note](./Day78/RansomNote.java)

### Day 79: June 4, 2026

**Today's Progress:** Verified string structures! #205: Isomorphic Strings.

**Thoughts:** To prove two strings are isomorphic, you have to guarantee a strict 1-to-1 mapping (bijection). If 'a' maps to 'b', 'b' cannot map to 'a'. My first implementation used two `HashMap`s to check the mappings in both directions (`S -> T` and `T -> S`). This safely handles all edge cases. However, as an optimization exercise, I leveraged the problem's ASCII constraint to replace the `HashMap`s with two `int[256]` arrays. Instead of mapping characters to other characters, I mapped each character to its **last seen index**. If the two characters in a given pair don't share the exact same last-seen index signature, I know the isomorphic pattern has been broken! This removes all autoboxing overhead and drops the space complexity to a microscopic, strict $O(1)$.

**Link to work:** [Day 79 - Isomorphic Strings](./Day79/IsomorphicStrings.java)

### Day 80: June 5, 2026

**Today's Progress:** Hit 80 Days! Solved #290: Word Pattern.

**Thoughts:** This problem is the exact same underlying logic as yesterday's "Isomorphic Strings", just mapping Characters to Strings instead of Characters to Characters. My initial approach was standard: `s.split(" ")` followed by two HashMaps to enforce a strict two-way bijection. To push my Java knowledge, I refactored the solution to use a **Single Heterogeneous Map** (`Map<Object, Integer>`). Since `Character` and `String` are distinct object types, they can share the same map without key collisions. I utilized the fact that `Map.put()` returns the _previous_ value associated with a key. By putting both the current character and the current word into the map on each iteration, I could simply check if they returned the same previous index using `Objects.equals()`. If the returned histories didn't match, the bijection was broken!

**Link to work:** [Day 80 - Word Pattern](./Day80/WordPattern.java)

### Day 81: June 6, 2026

**Today's Progress:** Solved a foundational string problem! #242: Valid Anagram.

**Thoughts:** I started by writing a frequency map implementation using a `HashMap`. I iterated through string `s` to count the letters, and then iterated through string `t` to deplete them. Interestingly, this is actually the exact answer to the problem's Follow-up question regarding Unicode characters, because a `HashMap` dynamically handles massive, sparse character sets without wasting memory! However, for the base constraints (strictly lowercase English letters), I refactored the solution to use a direct-access **Alphabet Array** (`int[26]`). Because both strings are guaranteed to be the same length, I processed them in a single loop—incrementing the array for characters in `s` and decrementing for characters in `t`. This acts as a zero-sum game; if they are true anagrams, every single bucket perfectly balances back out to `0` at the end!

**Link to work:** [Day 81 - Valid Anagram](./Day81/ValidAnagram.java)

### Day 82: June 8, 2026

**Today's Progress:** Mastered data grouping! #49: Group Anagrams.

**Thoughts:** My initial solution relied on string sorting. By converting every string to a character array and sorting it, I created a universal "key" that allowed me to group anagrams together in a `HashMap`. While highly readable, sorting takes $O(K \log K)$ time per string. To optimize this for an enterprise environment, I utilized a **Frequency Array Signature**. Because the characters are limited to `a-z`, I built an `int[26]` frequency array for each string and used `Arrays.toString()` to serialize it into my HashMap key. This drops the sorting entirely, resulting in an optimal $O(N \times K)$ algorithm! I also cleaned up my map initialization by using Java's idiomatic `.computeIfAbsent()`, which automatically handles the `null` checks and lists instantiations in a single line.

**Link to work:** [Day 82 - Group Anagrams](./Day82/GroupAnagrams.java)

### Day 83: June 8, 2026

**Today's Progress:** Conquered the algorithm that started it all! #1: Two Sum.

**Thoughts:** It's fitting to tackle LeetCode #1 this late in the challenge because I can truly appreciate the optimal solution. The brute-force double `for` loop approach takes $O(N^2)$ time. To solve the explicit follow-up question ("less than $O(N^2)$ time"), I implemented a single-pass `HashMap`. As I iterate through the array, I calculate the `complement` needed to reach the target. If the complement is in the map, I return the indices. If not, I store the current number and index in the map for future checks. This drops the time complexity to a blisteringly fast $O(N)$. To elevate the code to enterprise standards, I initialized the `HashMap` with `nums.length` to prevent internal resizing/rehashing overhead, and I replaced the empty return statement with an `IllegalArgumentException` to strictly enforce the "exactly one solution" data contract!

**Link to work:** [Day 83 - Two Sum](./Day83/TwoSum.java)

### Day 84: June 9, 2026

**Today's Progress:** Solved a classic cycle detection puzzle! #202: Happy Number.

**Thoughts:** The challenge with testing for a "Happy Number" isn't the math, it's preventing an infinite loop if the number is unhappy. My initial approach used a `HashSet`. By adding every generated number to the set, I could safely break the loop if I encountered a duplicate. To optimize the space complexity from `O(log N)` to `O(1)`, I treated the mathematical sequence like a Linked List! I implemented **Floyd’s Cycle-Finding Algorithm** using a `slow` and `fast` pointer. The slow pointer calculates the next number once, while the fast pointer calculates it twice. If a cycle exists, the fast pointer will mathematically "lap" the slow pointer and they will collide. If the number is happy, the fast pointer will effortlessly hit `1` and break the loop. No history storage required!

**Link to work:** [Day 84 - Happy Number](./Day84/HappyNumber.java)

### Day 85: June 10, 2026

**Today's Progress:** Mastered bounded memory constraints! #219: Contains Duplicate II.

**Thoughts:** The challenge here is finding duplicate numbers that are no more than `k` indices apart. My initial solution used a `HashMap` to store every number and its last seen index, giving me an optimal $O(N)$ time complexity. However, it required $O(N)$ space. To optimize this for enterprise-scale data, I implemented a **Fixed-Size Sliding Window**. Instead of a Map, I used a `HashSet`. I bounded the set's size so it never exceeded `k` elements by actively removing the oldest element (`nums[i - k]`) as the loop moved forward. This dropped the memory footprint down to $O(\min(N, K))$! I also applied a great idiomatic Java trick: `Set.add()` returns a boolean. By wrapping it in an `if (!window.add(nums[i]))` statement, I completely eliminated the need for a separate `.contains()` check, saving CPU cycles!

**Link to work:** [Day 85 - Contains Duplicate II](./Day85/ContainsDuplicateII.java)

### Day 86: June 11, 2026

**Today's Progress:** Solved an Amortized $O(N)$ classic! #128: Longest Consecutive Sequence.

**Thoughts:** The trick to solving this problem in strictly $O(N)$ time without sorting is to use a `HashSet` and a highly specific start-condition check. By only allowing the inner sequence-building `while` loop to run if the current number is the absolute _start_ of a sequence (`!set.contains(num - 1)`), I ensure that no number is processed more than twice, keeping the time complexity perfectly linear! To make this code enterprise-ready, I pre-allocated the `HashSet` capacity to `nums.length` to avoid dynamic resizing overhead. More importantly, I introduced **Mathematical Pruning**. I added an `if (longest > n / 2)` break condition. If the length of the sequence I just found is larger than half the array's total length, it is mathematically impossible for any remaining sequence to be larger, allowing the algorithm to instantly terminate and save massive amounts of processing time!

**Link to work:** [Day 86 - Longest Consecutive Sequence](./Day86/LongestConsecutiveSequence.java)

### Day 87: June 12, 2026

**Today's Progress:** Mastered array intervals and edge cases! #228: Summary Ranges.

**Thoughts:** The logic to find consecutive ranges is a straightforward $O(N)$ two-pointer/while-loop approach. However, this problem contains a very sneaky trap in its constraints: the numbers can reach up to `2^31 - 1`. If you check for consecutive numbers using `nums[i + 1] == nums[i] + 1`, the addition will cause an integer overflow at the maximum limit and break the loop! I sidestepped this by mathematically checking the difference using a long cast: `(long) nums[i + 1] - nums[i] == 1`. This bulletproofs the algorithm. To push the code to enterprise standards, I analyzed the worst-case space complexity. If no numbers are consecutive, the output list will be exactly the same size as the input array. By passing `nums.length` into the `ArrayList` constructor, I pre-allocated the exact maximum memory needed, preventing any underlying array resizing overhead!

**Link to work:** [Day 87 - Summary Ranges](./Day87/SummaryRanges.java)

### Day 88: June 23, 2026

**Today's Progress:** I'm back! Solved a FAANG classic! #56: Merge Intervals.

**Thoughts:** I took a short hiatus over the last week and a half to recharge. Consistency is key, but preventing burnout is just as important. I am back and ready to crush the final leg of this 100-day journey! I tackled "Merge Intervals", which requires sorting a 2D array by the start times to effectively merge overlapping blocks. While `(a, b) -> a[0] - b[0]` works for this specific LeetCode problem, I learned that in a real enterprise environment, this can cause a catastrophic Integer Overflow if the numbers are negative and positive extremes. I updated my comparator to use `Integer.compare(a[0], b[0])` for bulletproof sorting. Furthermore, instead of using separate variables to track my running bounds, I pushed intervals directly into my `result` list and used `result.get(result.size() - 1)` to fetch and dynamically update the intervals in-place!

**Link to work:** [Day 88 - Merge Intervals](./Day88/MergeIntervals.java)

### Day 89: June 24, 2026

**Today's Progress:** Mastered the snowplow algorithm! #57: Insert Interval.

**Thoughts:** Following up "Merge Intervals" with "Insert Interval" was the perfect sequence. Because the input array in this problem is _already sorted_, I knew I didn't have to run an $O(N \log N)$ sort. Instead, I used a **Three-Phase Sweep** to achieve an optimal $O(N)$ execution. I traversed the array linearly: 1. Pushing all intervals strictly to the left of the new interval into my result list. 2. Continuously updating the `newInterval`'s bounds using `Math.min` and `Math.max` to absorb any overlapping blocks like a snowplow. 3. Pushing the remaining intervals to the right into the result list. To make this enterprise-ready, I implemented **JVM Optimization**. I pre-allocated my `ArrayList` to `intervals.length + 1`. Then, when converting the list back to an array, I used `result.toArray(new int[0][])`. Modern JVMs handle internal memory allocation significantly faster when passed a 0-length array rather than manually computing the size!

**Link to work:** [Day 89 - Insert Interval](./Day89/InsertInterval.java)

### Day 90: June 25, 2026 🎉 90% MILESTONE! 🎉

**Today's Progress:** Hit 90 Days! Mastered the Greedy Interval pattern. Solved #452: Minimum Number of Arrows to Burst Balloons.

**Thoughts:** I am officially in the single-digit countdown to Day 100! Today’s problem is a famous variation of the **Interval Scheduling Maximization Problem**. The core trick to this Greedy Algorithm is sorting the intervals by their _end_ coordinates, rather than their start coordinates. This guarantees that if you place an arrow at the absolute right-most edge of a balloon, you maximize your chances of hitting the balloons coming after it. Most importantly, I remembered a critical lesson from Day 88: using `a[1] - b[1]` in a comparator can cause a catastrophic Integer Overflow if the problem constraints include large negative and positive numbers! I proactively used `Integer.compare(a[1], b[1])` to guarantee mathematical safety. Adding an enterprise fast-fail guard clause at the top made this a perfectly optimized $O(N \log N)$ solution!

**Link to work:** [Day 90 - Minimum Arrows](./Day90/MinimumArrows.java)

### Day 91: June 26, 2026

**Today's Progress:** Mastered the LIFO pattern! #20: Valid Parentheses.

**Thoughts:** This is the quintessential Stack problem. Because brackets must be closed in the reverse order they were opened, a Last-In-First-Out data structure is required. While `java.util.Stack` gets the job done, I learned it is actually a legacy, synchronized class that adds locking overhead. Furthermore, `Stack<Character>` causes heavy autoboxing memory bloat. I refactored the solution to use a raw primitive array (`char[] stack`) and an integer pointer (`top`), achieving hardware-level speed! To streamline the logic, I used the **Expected Bracket Trick**: instead of pushing the opening bracket, I pushed the closing bracket I _expected_ to see. When I encountered a closing bracket in the string, I simply popped my custom stack and checked if they matched. I also added a fast-fail guard clause for odd-length strings!

**Link to work:** [Day 91 - Valid Parentheses](./Day91/ValidParentheses.java)

### Day 92: June 27, 2026

**Today's Progress:** Cleaned up Unix file directories! #71: Simplify Path.

**Thoughts:** Parsing file paths is a classic use case for a Stack. You push when you enter a directory, and you pop when you encounter a `..` (go up a directory). I used `path.split("/")` to break the string into easily digestible tokens and ignore consecutive slashes. While my logic was perfectly $O(N)$, I took the opportunity to modernize the code for enterprise environments. First, I completely retired `java.util.Stack` in favor of `ArrayDeque`. The standard `Stack` is a synchronized legacy class from Java 1.0, whereas `ArrayDeque` is the modern, high-performance, non-synchronized alternative. Secondly, instead of manually looping through the stack with a `StringBuilder` to reconstruct the path, I used `String.join("/", deque)`. This natively builds the path and perfectly handles the root `/` edge case without needing an `isEmpty()` check!

**Link to work:** [Day 92 - Simplify Path](./Day92/SimplifyPath.java)

### Day 93: June 28, 2026

**Today's Progress:** Designed a custom data structure! #155: Min Stack.

**Thoughts:** The challenge of this problem is retrieving the minimum element in $O(1)$ time without searching the stack. My initial approach was mathematically sound: I used two `java.util.Stack` objects. One held the actual values, and the other held the running minimum. Whenever I pushed a value, I pushed `Math.min(value, minStack.peek())` to the secondary stack, ensuring they stayed perfectly synced. To optimize this for a true enterprise system design interview, I discarded the standard Java Collections entirely. Because `java.util.Stack` is a synchronized legacy class that forces memory-heavy autoboxing (`int` to `Integer`), I built a **Custom Linked List**. I created a private `Node` class containing `{val, min, next}`. By just updating the `head` pointer on push and pop, I eliminated all array-resizing overhead, prevented autoboxing, and achieved absolute maximum performance!

**Link to work:** [Day 93 - Min Stack](./Day93/MinStack.java)

### Day 94: June 29, 2026

**Today's Progress:** Built an optimized mathematical parser! #150: Evaluate Reverse Polish Notation.

**Thoughts:** RPN is inherently designed to be parsed by a Stack. Because the operators always apply to the two most recently seen numbers, the LIFO nature of a Stack handles the order of operations flawlessly. My initial solution used Java's standard `Stack<Integer>`, popping two variables, doing the math, and pushing the result. To elevate this to true enterprise-grade performance, I replaced the legacy Stack with a raw primitive array (`int[] stack = new int[tokens.length]`). This entirely eliminated the heavy memory overhead of autoboxing `int` values into `Integer` objects. Furthermore, I optimized the calculation step by utilizing **In-Place Pointer Arithmetic**. Instead of extracting variables, I applied the operators directly to `stack[top - 1]` and `stack[top]`, stored the result in `stack[top - 1]`, and decremented the pointer. This yielded a perfectly clean, 0ms execution!

**Link to work:** [Day 94 - Evaluate RPN](./Day94/EvaluateRPN.java)

### Day 95: June 30, 2026

**Today's Progress:** Conquered a LeetCode Hard! #224: Basic Calculator.

**Thoughts:** Just 5 days left, and I took down a Hard! To evaluate mathematical expressions with nested parentheses without converting to Reverse Polish Notation first, I used a **State-Saving Stack**. As I iterate through the string, I keep track of the `running result` and the `current sign`. When I encounter an opening parenthesis `(`, I push both of those values onto the stack to "save" my state, and reset them to 0 and 1 to evaluate the sub-expression. When I encounter a closing parenthesis `)`, I pop the saved sign and saved result, applying them to the sub-expression to merge it all back together! To optimize this for the massive `3 * 10^5` character constraint, I implemented the lessons from the past few days: I replaced `java.util.Stack` with a custom `int[]` primitive array to eliminate autoboxing memory bloat, and I swapped `Character.isDigit()` for a raw ASCII check (`ch >= '0' && ch <= '9'`) to bypass heavy Unicode validations.

**Link to work:** [Day 95 - Basic Calculator](./Day95/BasicCalculator.java)

### Day 96: July 1, 2026

**Today's Progress:** Brought Floyd's Algorithm home! #141: Linked List Cycle.

**Thoughts:** Just 4 days left! I encountered this logic back on Day 84 when detecting loops in math sequences, but today I applied it to its native data structure. Using Floyd’s Tortoise and Hare algorithm, I dispatched a `slow` pointer (1 step) and a `fast` pointer (2 steps). If a cycle exists, the fast pointer is guaranteed to lap the slow pointer and collide with it, answering the $O(1)$ memory follow-up perfectly. For a Senior Twist, I implemented the logic for LeetCode #142 directly into my collision check! In a real system, just knowing a cycle exists doesn't help you fix it. By moving a pointer to the `head` of the list after the collision, and stepping it forward alongside the `slow` pointer at a speed of 1, their next meeting point mathematically isolates the exact node where the cycle begins!

**Link to work:** [Day 96 - Linked List Cycle](./Day96/LinkedListCycle.java)

### Day 97: July 2, 2026

**Today's Progress:** Built the foundation for BigInteger! #2: Add Two Numbers.

**Thoughts:** Only 3 days left! Today I tackled a quintessential Linked List problem. The challenge is adding two numbers digit-by-digit while managing a carry, with the caveat that the numbers are represented as reverse-ordered Linked Lists. My logic consolidated the entire process into a single `while` loop with the condition `l1 != null || l2 != null || carry != 0`. This brilliantly handles lists of asymmetrical lengths and ensures any final trailing carry is appended as a new node without needing extra post-loop `if` statements. I learned that this specific algorithm is actually the foundational logic behind arbitrary-precision arithmetic, such as Java's `BigInteger` class, which uses arrays to store massive numbers and adds them chunk by chunk! To make the code production-ready, I refactored the shorthand variables into semantic, self-documenting names (`sentinelHead`, `val1`, `val2`).

**Link to work:** [Day 97 - Add Two Numbers](./Day97/AddTwoNumbers.java)

### Day 98: July 3, 2026

**Today's Progress:** Mastered in-place pointer manipulation! #21: Merge Two Sorted Lists.

**Thoughts:** Only 2 days left! Today's problem is a foundational Linked List algorithm. The goal is to merge two already-sorted lists into a single sorted list. I solved this iteratively using a `while` loop that compares the current nodes of both lists and attaches the smaller one to a running `current` pointer. The most crucial part of this solution is the Space Complexity: I achieved strictly $O(1)$ memory by rewiring the existing `.next` pointers rather than instantiating new `ListNode` objects. I also learned a valuable Senior concept: while a recursive solution to this problem is very popular and requires fewer lines of code, it is dangerous in production. Recursion requires $O(N+M)$ Call Stack space, which can easily trigger a `StackOverflowError` on massive datasets. My $O(1)$ iterative approach is the true enterprise standard! I finished the code by applying semantic naming conventions, replacing my `dummy` node with `sentinelHead`.

**Link to work:** [Day 98 - Merge Two Sorted Lists](./Day98/MergeTwoSortedLists.java)

### Day 99: July 4, 2026 🎉 PENULTIMATE DAY 🎉

**Today's Progress:** Mastered in-place deep copying! #138: Copy List with Random Pointer.

**Thoughts:** TOMORROW IS DAY 100! Today I tackled a problem that requires creating a deep copy of a linked list where nodes have arbitrary "random" pointers. My initial approach was to use a `HashMap<Node, Node>` to map the original nodes to their newly created clones. This allowed me to easily look up the cloned references in a second pass, yielding a perfect `O(N)` time complexity. However, it required `O(N)` auxiliary space for the map. To answer the classic FAANG follow-up ("Do this in `O(1)` space"), I implemented the **Interweaving Algorithm**. In Phase 1, I inserted every cloned node directly next to its original (`A -> A' -> B -> B'`). In Phase 2, this clever layout allowed me to assign random pointers by simply looking at the next node (`curr.next.random = curr.random.next`). Finally, in Phase 3, I unweaved the pointers to restore the original list and extract the fully assembled deep copy. Absolute memory optimization!

**Link to work:** [Day 99 - Copy List with Random Pointer](./Day99/CopyListWithRandomPointer.java)

### Day 100: July 5, 2026 🏆 CHALLENGE COMPLETE 🏆

**Today's Progress:** CROSSED THE FINISH LINE! Mastered single-pass pointer manipulation. Solved #92: Reverse Linked List II.

**Thoughts:** I did it. 100 Days of Code is officially complete! I chose a fantastic problem for the finale: reversing a targeted section of a Linked List. I successfully solved the Follow-Up challenge by executing the reversal in a **Single Pass** with strictly `O(1)` memory. By utilizing a sentinel node and stopping just before the `left` boundary, I iteratively extracted nodes and pushed them to the front of the sub-list. For my final enterprise optimization, I focused on Code Readability. Pointer manipulation is notoriously difficult to review, so I completely refactored the generic variables into self-documenting semantic names (`nodeBeforeSublist`, `sublistTail`, `nodeToExtract`). This makes the complex 4-step pointer rewiring instantly readable!

This journey has fundamentally changed how I approach problem-solving, data structures, and memory optimization. I am stepping away from Day 100 as a profoundly better Software Engineer!

**Link to work:** [Day 100 - Reverse Linked List II](./Day100/ReverseLinkedListII.java)

### Day 101: July 6, 2026 🚀 THE MOMENTUM CONTINUES 🚀

**Today's Progress:** Kicked off the next phase with a LeetCode Hard! Mastered pointer boundaries and sub-list management. Solved #25: Reverse Nodes in k-Group.

**Thoughts:** I am officially past the 100-day mark and keeping the streak alive! I tackled a notoriously complex linked list problem and successfully fulfilled the Follow-Up challenge by executing the `k`-group reversal with strictly `O(1)` memory. By utilizing a sentinel/dummy node and writing a clean helper function to identify group boundaries, I completely bypassed the messy edge cases that usually plague linked list logic. Continuing with the enterprise optimization from yesterday, I focused heavily on Code Readability. I completely refactored the generic pointer variables into self-documenting semantic names (`groupAnchor`, `previousNode`, `currentExtractionNode`). The complex pointer rewiring is now a highly readable, self-documenting blueprint!

**Link to work:** [Day 101 - Reverse Nodes in k-Group](./Day101/ReverseNodesInKGroup.java)

### Day 102: July 7, 2026 🚄 SLIDING WINDOW MASTERY 🚄

**Today's Progress:** Conquered a classic Medium problem using the two-pointer technique. Solved #19: Remove Nth Node From End of List.

**Thoughts:** Day 102 is in the books! I tackled this problem and successfully completed the Follow-Up challenge by executing the removal in a **Single Pass** with strictly `O(1)` memory. By utilizing a sentinel node and creating a gap of `n + 1` between a fast and slow pointer, I was able to find the exact node to remove without needing to calculate the length of the list first. Continuing with my enterprise optimization, I focused on Code Readability. I refactored the generic `fast` and `slow` pointers into self-documenting semantic names (`leadPointer` and `targetPredecessor`). This perfectly describes the sliding window architecture!

**Link to work:** [Day 102 - Remove Nth Node From End of List](./Day102/RemoveNthNodeFromEndOfList.java)

### Day 103: July 8, 2026 🔥 POINTER CLUSTER BYPASS 🔥

**Today's Progress:** Tackled another tricky Linked List problem. Solved #82: Remove Duplicates from Sorted List II.

**Thoughts:** Day 103 is complete! This problem was an excellent exercise in cluster management. I successfully executed the removal in a **Single Pass** with strictly `O(1)` memory. By utilizing a sentinel node and an inner `while` loop, I was able to scrub through entire clusters of duplicate values and aggressively rewire the list to bypass them completely. Continuing my focus on Code Readability, I refactored the generic `prev` and `curr` pointers into self-documenting semantic names (`latestDistinctNode` and `explorationPointer`). This perfectly describes the structural relationship between the secure anchor and the scouting pointer!

**Link to work:** [Day 103 - Remove Duplicates from Sorted List II](./Day103/RemoveDuplicatesFromSortedListII.java)

### Day 104: July 9, 2026 🪐 RING TOPOLOGY MASTERY 🪐

**Today's Progress:** Tackled a rotational Linked List problem by manipulating list topology. Solved #61: Rotate List.

**Thoughts:** Day 104 is complete! I solved a Medium-level rotation problem in strictly `O(1)` memory and `O(N)` time. The trick to this problem isn't actually shifting nodes—it's math and topology. By utilizing modulo arithmetic (`k % length`), I eliminated all redundant full-circle rotations. I then temporarily linked the tail to the head to form a closed ring, traversed to the calculated `breakPoint`, and snapped the ring open. Continuing my focus on Code Readability, I refactored the variables to describe the architectural state of the ring (`originalTail`, `breakPoint`, `rotatedHead`). The code reads like a blueprint!

**Link to work:** [Day 104 - Rotate List](./Day104/RotateList.java)

### Day 105: July 10, 2026 🔀 DATA STREAM BIFURCATION 🔀

**Today's Progress:** Mastered multi-pointer state management on a Linked List. Solved #86: Partition List.

**Thoughts:** Day 105 is locked in! I solved a Medium-level architectural problem in strictly `O(1)` memory and `O(N)` time. This problem requires splitting a list into two separate pipelines based on a pivot value, then stitching them back together. The key here was ensuring I terminated the final node of the "greater" list with `null` to prevent cyclic loops. Continuing my focus on Code Readability, I refactored the variables to describe the architectural state of the pipelines (`lessThanAnchor`, `greaterOrEqualTail`). The data flow is now explicitly documented by the variable names, making the final assembly phase read like plain English!

**Link to work:** [Day 105 - Partition List](./Day105/PartitionList.java)

### Day 106: July 11, 2026 🧠 SYSTEM ARCHITECTURE MASTERY 🧠

**Today's Progress:** Built the most famous FAANG interview data structure from scratch. Solved #146: LRU Cache.

**Thoughts:** Day 106 locked in! I tackled a complex Medium/Hard problem that requires marrying two distinct data structures: a HashMap for $O(1)$ lookups and a Doubly Linked List for $O(1)$ structural reordering. By utilizing sentinel anchors for the head and tail, I avoided the messy null-pointer checks that usually plague list removals. Continuing my focus on Code Readability, I refactored the generic list variables into explicit Cache Policy terms (`mruAnchor`, `lruAnchor`) and transformed the helper methods to narrate the eviction state (`markAsMostRecentlyUsed`). It reads like a production-grade cache controller!

**Link to work:** [Day 106 - LRU Cache](./Day106/LRUCache.java)

### Day 107: July 12, 2026 🌲 ENTERING THE FOREST 🌲

**Today's Progress:** Transitioned from linear structures to non-linear trees! Mastered recursive DFS. Solved #104: Maximum Depth of Binary Tree.

**Thoughts:** Day 107 locked in! Today marked a major shift in the curriculum as I moved from Linked Lists into Binary Trees. I solved the foundational tree depth problem using a recursive Depth-First Search approach, achieving optimal `O(N)` time complexity. This was a great exercise in trusting the recursive leap of faith and letting the call stack handle the heavy lifting. Continuing my focus on Code Readability, I updated the variables to `leftSubtreeHeight` and `rightSubtreeHeight` to explicitly document what the recursive calls are actually returning. The algorithm now perfectly narrates its own tree traversal!

**Link to work:** [Day 107 - Maximum Depth of Binary Tree](./Day107/MaxDepthOfBinaryTree.java)

### Day 108: July 13, 2026 🪞 SYNCHRONIZED TRAVERSAL 🪞

**Today's Progress:** Mastered parallel recursive call stacks. Solved #100: Same Tree.

**Thoughts:** Day 108 locked in! Today I tackled structural architecture by writing an algorithm that evaluates two separate binary trees in absolute lockstep. I solved this using a synchronized Depth-First Search approach, achieving optimal `O(N)` time complexity. The key to this problem was relying on highly defensive, fast-failing guard clauses to check for structural divergences (`null` mismatches) before checking data equality. Continuing my enterprise focus, I ditched the generic `p` and `q` arguments for `referenceNode` and `comparisonNode`. I also extracted the recursive calls into explicit boolean variables (`isLeftIdentical`), making the final return statement a highly readable, self-documenting audit.

**Link to work:** [Day 108 - Same Tree](./Day108/SameTree.java)

### Day 109: July 14, 2026 🔄 THE GOOGLE LEGEND 🔄

**Today's Progress:** Conquered the most famous interview question in tech history. Solved #226: Invert Binary Tree.

**Thoughts:** Day 109 is in the books! Today I tackled the algorithm that famously tripped up the creator of Homebrew at Google. I solved it using a clean Post-Order recursive traversal with optimal `O(N)` time and `O(H)` space complexity. By diving all the way down to the leaf nodes first, I ensured that every subtree was fully inverted before bubbling back up to swap them at the parent level. Continuing my focus on Code Readability, I updated the temporary variables from `left/right` to `invertedLeftSubtree` and `invertedRightSubtree`. This makes the post-order state mutation instantly obvious—documenting exactly what the variables hold at the moment the swap occurs!

**Link to work:** [Day 109 - Invert Binary Tree](./Day109/InvertBinaryTree.java)

### Day 110: July 15, 2026 🪞 SYMMETRIC ARCHITECTURE 🪞

**Today's Progress:** Hybridized the concepts of tree inversion and synchronized traversal. Solved #101: Symmetric Tree.

**Thoughts:** Day 110 locked in! Today I solved a problem that required checking if a tree is a mirror image of itself. This is effectively a combination of the logic from Day 108 (Same Tree) and Day 109 (Invert Tree). I used a synchronized Depth-First Search approach to evaluate the subtrees in absolute lockstep, achieving optimal `O(N)` time complexity. Continuing my focus on Code Readability, I updated the recursive return statements into descriptive boolean variables. By extracting the checks into `isOuterSymmetric` and `isInnerSymmetric`, the code explicitly documents the geometric cross-checking happening inside the recursive call stack!

**Link to work:** [Day 110 - Symmetric Tree](./Day110/SymmetricTree.java)

### Day 111: July 15, 2026 🪞 SYMMETRIC ARCHITECTURE 🪞

**Today's Progress:** Hybridized the concepts of tree inversion and synchronized traversal. Solved #101: Symmetric Tree.

**Thoughts:** Day 111 locked in! Today I solved a problem that required checking if a tree is a mirror image of itself. This is effectively a combination of the logic from Day 108 (Same Tree) and Day 109 (Invert Tree). I used a synchronized Depth-First Search approach to evaluate the subtrees in absolute lockstep, achieving optimal `O(N)` time complexity. Continuing my focus on Code Readability, I updated the recursive return statements into descriptive boolean variables. By extracting the checks into `isOuterSymmetric` and `isInnerSymmetric`, the code explicitly documents the geometric cross-checking happening inside the recursive call stack!

**Link to work:** [Day 111 - Symmetric Tree](./Day110/SymmetricTree.java)

### Day 112: July 17, 2026 🏗️ TREE CONSTRUCTION ARCHITECTURE 🏗️

**Today's Progress:** Mastered array-based tree construction. Solved #106: Construct Binary Tree from Inorder and Postorder Traversal.

**Thoughts:** Day 112 locked in! Today I tackled a complex structural problem that required reverse-engineering a binary tree from two separate traversal arrays. I optimized the solution to `O(N)` time complexity by caching the `inorder` array into a HashMap for `O(1)` index lookups. The crucial realization was that processing a `postorder` array backward yields a `Root -> Right -> Left` sequence, meaning the right subtree _must_ be constructed before the left! Continuing my enterprise focus, I refactored the variables to explicitly document the geometric array slicing (`inorderBoundaryLeft` and `inorderBoundaryRight`). The recursive calls now perfectly narrate how the tree boundaries shrink!

**Link to work:** [Day 112 - Construct Binary Tree](./Day112/ConstructTreeInorderPostorder.java)

### Day 113: July 18, 2026 🔗 LEVEL-ORDER LINKING 🔗

**Today's Progress:** Mastered O(1) space complexity tree manipulation. Solved #117: Populating Next Right Pointers in Each Node II.

**Thoughts:** Day 113 in the books! Today was an excellent lesson in using a tree’s structure to perform its own traversal. By utilizing the `next` pointers to navigate levels, I eliminated the need for a Queue, bringing space complexity down to `O(1)`. This is a classic pattern for tree manipulation where the tree acts as a linked list at every depth. I focused on making the variable names (`currentLevelNode`, `nextLevelTail`) explicitly describe their structural role in constructing the level below, ensuring the code is readable and maintainable!

**Link to work:** [Day 113 - Populating Next Pointers](./Day113/PopulateNextRightPointers.java)

### Day 114: July 19, 2026 🎗️ TREE FLATTENING ARCHITECTURE 🎗️

**Today's Progress:** Solved #114: Flatten Binary Tree to Linked List. Optimized to O(1) space.

**Thoughts:** Day 114 locked in! Today I converted a binary tree into a right-leaning linked list using an in-place transformation. While my initial logic used an `ArrayList` to preserve the preorder traversal sequence, I refactored it to use an in-place strategy that achieves `O(1)` space complexity. By locating the predecessor (rightmost node of the left subtree) and re-stitching the pointers, I effectively bypassed the need for extra memory. This is a powerful pattern for tree manipulation where the tree's own structure can be used to hold state!

**Link to work:** [Day 114 - Flatten Binary Tree](./Day114/FlattenBinaryTree.java)

### Day 115: July 20, 2026 🛤️ PATH SUM ARCHITECTURE 🛤️

**Today's Progress:** Mastered tree path validation using recursive target reduction. Solved #112: Path Sum.

**Thoughts:** Day 115 locked in! Today I solved the Path Sum problem using an elegant recursive approach. By subtracting node values from the `targetSum` as I traversed downward, I transformed the problem into a simple balance check at each leaf node. This method provides `O(N)` time complexity and relies on implicit stack space (`O(H)`), making it very efficient. The use of clear structural guards for null and leaf nodes makes the logic incredibly resilient to edge cases!

**Link to work:** [Day 115 - Path Sum](./Day115/PathSum.java)

### Day 116: July 21, 2026 🧮 DIGIT ACCUMULATION ARCHITECTURE 🧮

**Today's Progress:** Solved #129: Sum Root to Leaf Numbers using a top-down DFS approach.

**Thoughts:** Day 116 locked in! Today's challenge required aggregating numbers formed by root-to-leaf paths. By utilizing the classic `num * 10 + node.val` formula, I was able to pass the running sum down the recursive call stack efficiently. When hitting a leaf node, the complete number is returned and aggregated. This achieves optimal `O(N)` time complexity and relies cleanly on the call stack memory `O(H)`. Refactoring with expressive variable names ensures the digit-shifting logic remains crystal clear!

**Link to work:** [Day 116 - Sum Root to Leaf Numbers](./Day116/SumRootToLeafNumbers.java)

### Day 117: July 22, 2026 ⚡ HARD-TIER PATH MAXIMIZATION ⚡

**Today's Progress:** Conquered a classic Hard problem. Solved #124: Binary Tree Maximum Path Sum.

**Thoughts:** Day 117 locked in! Today I tackled Binary Tree Maximum Path Sum, a brilliant test of post-order tree recursion. By utilizing `Math.max(0, ...)` to prune negative subtrees, I ensured that unprofitable branches never drag down valid path sums. The core architectural realization is distinguishing between a node acting as a path's turning point (`left + root + right`) versus passing a single optimal branch upward (`root + max(left, right)`). Achieving optimal `O(N)` time complexity with clean state-tracking cements this core tree pattern!

**Link to work:** [Day 117 - Binary Tree Maximum Path Sum](./Day117/BinaryTreeMaximumPathSum.java)

### Day 118: July 23, 2026 🔄 CONTROLLED BST ITERATOR 🔄

**Today's Progress:** Built an efficient state-managed iterator for Binary Search Trees. Solved #173: Binary Search Tree Iterator.

**Thoughts:** Day 118 locked in! Today I implemented a controlled in-order iterator using an explicit stack. Instead of flattening the entire tree into an array ahead of time (which would cost `O(N)` memory), this design caches only the left spine, achieving optimal `O(H)` space complexity. The `next()` and `hasNext()` operations run in amortized `O(1)` time, making it exceptionally scalable for large trees. Encapsulating the stack initialization into a helper method keeps the class clean and professional!

**Link to work:** [Day 118 - BST Iterator](./Day118/BSTIterator.java)

### Day 119: July 24, 2026 🌲 LOGARITHMIC TREE COUNTING 🌲

**Today's Progress:** Mastered complete binary tree geometry. Solved #222: Count Complete Tree Nodes.

**Thoughts:** Day 119 locked in! Today I optimized node counting from a standard `O(N)` traversal down to an ultra-fast `O(log^2 N)` algorithm. By checking the extreme left and right heights of subtrees, I can instantly identify "perfect binary subtrees" and calculate their size using bitwise shifting (`(1 << height) - 1`) without visiting individual nodes. This architectural trick bypasses full-tree exploration by exploiting the structural constraints of complete binary trees!

**Link to work:** [Day 119 - Count Complete Tree Nodes](./Day119/CountCompleteTreeNodes.java)

### Day 120: July 25, 2026 🌳 LOWEST COMMON ANCESTOR CONVERGENCE 🌳

**Today's Progress:** Celebrated 120 consecutive days of coding by mastering a foundational tree classic. Solved #236: Lowest Common Ancestor of a Binary Tree.

**Thoughts:** Day 120 locked in! Today I solved the Lowest Common Ancestor problem using an elegant bottom-up DFS recursive pattern. By letting subtrees report back whether they found `p` or `q`, the current node acts as a convergence checkpoint. If both children return valid nodes, the current node is mathematically proven to be the split point (LCA). This avoids explicit path-tracking arrays, achieving optimal `O(N)` time complexity and `O(H)` stack space. Reaching 120 days of disciplined, consistent architectural execution is an incredible milestone!

**Link to work:** [Day 120 - Lowest Common Ancestor](./Day120/LowestCommonAncestor.java)

### Day 121: July 26, 2026 👀 RIGHT SIDE VIEW ARCHITECTURE 👀

**Today's Progress:** Kicked off Day 121 with level-order traversal optimization. Solved #199: Binary Tree Right Side View.

**Thoughts:** Day 121 locked in! Today I tackled the Right Side View problem using a level-order queue approach. By tracking the exact size of each row during traversal, I can isolate the final node (`size - 1`), which represents the rightmost visible point of that tree level. This guarantees an optimal `O(N)` time complexity and clear queue memory management. Moving smoothly into post-120 territory with clean, maintainable patterns!

**Link to work:** [Day 121 - Binary Tree Right Side View](./Day121/BinaryTreeRightSideView.java)

### Day 122: July 27, 2026 📊 LEVEL-ORDER AVERAGING 📊

**Today's Progress:** Mastered level-by-level mathematical aggregation. Solved #637: Average of Levels in Binary Tree.

**Thoughts:** Day 122 locked in! Today I implemented an efficient level-order traversal to compute the average node value at each depth of a binary tree. By using a `long` accumulator for level sums, the code is fully protected against potential integer overflow from large node values. This design achieves optimal `O(N)` time complexity with clean queue management. Another rock-solid addition to the tree mastery block!

**Link to work:** [Day 122 - Average of Levels in Binary Tree](./Day122/AverageOfLevelsInBinaryTree.java)

### Day 123: July 28, 2026 🌊 BREADTH-FIRST LEVEL ORDER TRAVERSAL 🌊

**Today's Progress:** Mastered the foundational BFS level-order pattern. Solved #102: Binary Tree Level Order Traversal.

**Thoughts:** Day 123 locked in! Today I implemented the classic level order traversal using a Queue. By tracking the exact `size` of the queue at the start of each level iteration, I successfully isolated row boundaries, ensuring nodes are cleanly grouped into nested lists from left to right. This is the blueprint for all breadth-first search algorithms, combining optimal `O(N)` time complexity with precise queue-based space management.

**Link to work:** [Day 123 - Binary Tree Level Order Traversal](./Day123/BinaryTreeLevelOrderTraversal.java)

### Day 124: July 29, 2026 ⚡ ZIGZAG LEVEL-ORDER ARCHITECTURE ⚡

**Today's Progress:** Mastered directional queue alternation. Solved #103: Binary Tree Zigzag Level Order Traversal.

**Thoughts:** Day 124 locked in! Today I solved the Zigzag Level Order Traversal problem by building on top of standard breadth-first search. By introducing a boolean direction flag (`isLeftToRight`) and utilizing front-index insertion (`list.add(0, val)`), I was able to construct reversed rows on the fly without an extra post-processing step. This preserves optimal `O(N)` time complexity while delivering clean, readable state alternation. 124 days strong!

**Link to work:** [Day 124 - Binary Tree Zigzag Level Order Traversal](./Day124/BinaryTreeZigzagLevelOrderTraversal.java)

### Day 125: July 30, 2026 🎯 125 DAYS: BST IN-ORDER OPTIMIZATION 🎯

**Today's Progress:** Celebrated 125 consecutive days of coding by mastering BST property exploitation. Solved #530: Minimum Absolute Difference in BST.

**Thoughts:** Day 125 locked in! Today I tackled Minimum Absolute Difference in BST using an optimized in-order traversal. Because a BST's in-order sequence is always sorted in ascending order, the minimum absolute difference is guaranteed to exist between adjacent elements in that sequence. By maintaining a `previousNode` pointer during recursion, I calculated differences on the fly without storing nodes in an array, achieving optimal `O(N)` time and `O(H)` space complexity. Reaching 125 days of unbroken dedication is an incredible milestone!

**Link to work:** [Day 125 - Minimum Absolute Difference in BST](./Day125/MinimumAbsoluteDifferenceInBST.java)

### Day 126: July 31, 2026 🏆 BST RANK OPTIMIZATION 🏆

**Today's Progress:** Concluded July with advanced BST property exploration. Solved #230: Kth Smallest Element in a BST.

**Thoughts:** Day 126 locked in! Today I solved the Kth Smallest Element in a BST problem using an optimized in-order traversal. Because in-order traversal processes nodes in sorted ascending order, we can track our position with a counter and short-circuit the recursion the exact moment we hit rank `k`. This achieves optimal `O(H + K)` time complexity and prevents unnecessary traversal of larger subtrees. Finishing July with such clean, efficient architecture feels fantastic!

**Link to work:** [Day 126 - Kth Smallest Element in a BST](./Day126/KthSmallestElementInABST.java)

### Day 127: August 1, 2026 🚀 KICKING OFF AUGUST: BST VALIDATION 🚀

**Today's Progress:** Opened August with rigorous tree validation architecture. Solved #98: Validate Binary Search Tree.

**Thoughts:** Day 127 locked in! Today I tackled Validate Binary Search Tree using a boundary-passing recursive strategy. Ensuring a valid BST requires checking global constraints across ancestors rather than local parent-child links. By enforcing strict lower and upper limits (`min` and `max`) and utilizing `long` types to prevent edge-case overflows, this solution achieves optimal `O(N)` time complexity with absolute accuracy. Starting August with strong momentum!

**Link to work:** [Day 127 - Validate Binary Search Tree](./Day127/ValidateBinarySearchTree.java)

### Day 128: August 2, 2026 🏝️ GRAPH MATRIX FLOOD FILL 🏝️

**Today's Progress:** Entered Graph/Grid Traversal domain. Solved #200: Number of Islands.

**Thoughts:** Day 128 locked in! Today I transitioned into graph algorithms by tackling Number of Islands using Depth-First Search (DFS). By mutating visited land cells to `'0'` directly inside the grid, the algorithm sinks entire island components in-place without requiring extra memory for a visited matrix. Using direction vectors (`DIRECTIONS = {{1,0}, {-1,0}, {0,1}, {0,-1}}`) keeps orthogonal traversal scalable and error-free. Achieved optimal `O(M * N)` time complexity!

**Link to work:** [Day 128 - Number of Islands](./Day128/NumberOfIslands.java)

### Day 129: August 3, 2026 🛡️ BOUNDARY-DRIVEN SURROUNDED REGIONS 🛡️

**Today's Progress:** Mastered reverse-boundary graph traversal. Solved #130: Surrounded Regions.

**Thoughts:** Day 129 locked in! Today I tackled Surrounded Regions by inverting the problem logic: instead of searching inward for trapped components, I started from the matrix borders and marked all edge-connected `'O'` cells as safe (`'T'`). A final linear scan then captures all remaining trapped `'O'` cells into `'X'` while restoring the safe zones. This elegant flood-fill approach guarantees optimal `O(M * N)` performance without complex edge-case checking!

**Link to work:** [Day 129 - Surrounded Regions](./Day129/SurroundedRegions.java)

### Day 130: August 4, 2026 🧬 CELEBRATING 130 DAYS: GRAPH DEEP COPY 🧬

**Today's Progress:** Hit 130 consecutive days of engineering excellence! Solved #133: Clone Graph.

**Thoughts:** Day 130 locked in! Today I tackled Clone Graph using a memoized DFS approach. Because graphs can contain complex cycles (unlike trees), duplicating them requires a hash map to track already-cloned nodes. By caching the clone in the map _before_ recursing into neighbors, the algorithm safely intercepts back-edges and prevents infinite loops. Achieving optimal `O(V + E)` time complexity while celebrating 130 days of unyielding daily consistency is a monumental achievement!

**Link to work:** [Day 130 - Clone Graph](./Day130/CloneGraph.java)

### Day 131: August 5, 2026 ⚖️ WEIGHTED GRAPH DIVISION EVALUATION ⚖️

**Today's Progress:** Solved #399: Evaluate Division using weighted directed graph DFS traversal.

**Thoughts:** Day 131 locked in! Today I tackled Evaluate Division by modeling algebraic equations as weighted directed edges. By storing forward ratios and their reverse reciprocals in an adjacency map, queries translate directly into path-finding problems. As DFS traverses the graph, edge weights are multiplied together to compute the final ratio. This achieves optimal performance while elegantly handling undefined variables and cycles!

**Link to work:** [Day 131 - Evaluate Division](./Day131/EvaluateDivision.java)

### Day 132: August 6, 2026 📚 DIRECTED GRAPH CYCLE DETECTION 📚

**Today's Progress:** Mastered topological cycle detection. Solved #207: Course Schedule.

**Thoughts:** Day 132 locked in! Today I tackled Course Schedule using a 3-state Depth-First Search (Graph Coloring) approach. In directed graphs, detecting cycles requires distinguishing between nodes currently on the active recursion path (`VISITING`) versus nodes that have already been fully cleared (`VISITED`). This elegant state machine achieves optimal `O(V + E)` time complexity while preventing false positives. Unstoppable momentum into August!

**Link to work:** [Day 132 - Course Schedule](./Day132/CourseSchedule.java)

### Day 133: August 7, 2026 🎲 BFS SNAKES AND LADDERS 🎲

**Today's Progress:** Mastered matrix graph shortest path and Boustrophedon mapping. Solved #909: Snakes and Ladders.

**Thoughts:** Day 133 locked in! Today I tackled Snakes and Ladders using Breadth-First Search to find the minimum dice rolls to reach the target. The core challenge lies in mapping 1D linear square numbers to 2D Boustrophedon (zigzag) matrix coordinates, which I handled cleanly with a dedicated coordinate decoding helper. BFS guarantees shortest path optimality with `O(N^2)` time complexity. Another brilliant graph problem conquered!

**Link to work:** [Day 133 - Snakes and Ladders](./Day133/SnakesAndLadders.java)

### Day 134: August 8, 2026 🧬 BFS STATE-SPACE EXPLORATION 🧬

**Today's Progress:** Solved #433: Minimum Genetic Mutation using on-the-fly state expansion BFS.

**Thoughts:** Day 134 locked in! Today I solved Minimum Genetic Mutation by modeling the problem as a shortest-path traversal on a state-space graph. Instead of pre-calculating every possible mutation link, I generated neighbors dynamically and validated them against the gene bank. This approach is memory-efficient and keeps the BFS logic clean. Successfully navigated the state-space!

**Link to work:** [Day 134 - Minimum Genetic Mutation](./Day134/MinimumGeneticMutation.java)

### Day 135: August 9, 2026 🪜 WORD LADDER SHORTEST PATH 🪜

**Today's Progress:** Conquered Hard-tier Word Ladder using BFS state expansion.

**Thoughts:** Day 135 locked in! Today I solved Word Ladder by treating the word mutation space as an unweighted graph and performing a Breadth-First Search. The most elegant optimization I implemented was removing words from the set the moment they are queued—this implicit 'visited' tracking makes the algorithm incredibly clean and avoids the extra memory of a separate visited set. Maintaining 135 days of daily problem solving is a massive achievement!

**Link to work:** [Day 135 - Word Ladder](./Day135/WordLadder.java)

### Day 136: August 10, 2026 🎓 TOPOLOGICAL DEPENDENCY SORTING 🎓

**Today's Progress:** Mastered dependency linearization. Solved #210: Course Schedule II using Kahn's Algorithm.

**Thoughts:** Day 136 locked in! Today I implemented topological sorting to find a valid ordering for course completion. By modeling the courses as a directed graph and tracking the `indegree` of each node, I efficiently extracted courses as their prerequisites were satisfied. This is a foundational pattern for any task-scheduling problem with dependencies, and achieving optimal `O(V + E)` complexity ensures it scales perfectly for large systems. 136 days of consistency—let's keep the graph mastery going!

**Link to work:** [Day 136 - Course Schedule II](./Day136/CourseScheduleII.java)

### Day 137: August 11, 2026 🌳 TRIE (PREFIX TREE) ARCHITECTURE 🌳

**Today's Progress:** Mastered the Trie data structure. Solved #208: Implement Trie (Prefix Tree).

**Thoughts:** Day 137 locked in! Today I implemented a Trie, a core data structure for efficient string retrieval and prefix matching. By using a fixed-size node array (size 26), I achieved O(1) character transitions, making the overall complexity strictly proportional to the length of the input string (`O(L)`). This is a foundational structure for autocompletes and spellcheckers. Adding another robust tool to the architectural toolkit!

**Link to work:** [Day 137 - Implement Trie](./Day137/Trie.java)

### Day 138: August 12, 2026 🔍 WILDCARD TRIE SEARCH 🔍

**Today's Progress:** Mastered recursive search patterns in Tries. Solved #211: Design Add and Search Words Data Structure.

**Thoughts:** Day 138 locked in! Today I implemented a Word Dictionary that supports both exact word matching and wildcard (`.`) searches. The core challenge was handling the wildcard by branching the search across all valid child nodes of the current Trie level. This is a perfect example of using recursion to handle search space branching, turning a standard O(L) Trie traversal into a robust, flexible search engine. 138 days of steady progress—closing in on the 5-month mark!

**Link to work:** [Day 138 - Word Dictionary](./Day138/WordDictionary.java)

### Day 139: August 13, 2026 🗺️ TRIE-ACCELERATED WORD SEARCH 🗺️

**Today's Progress:** Mastered advanced Hard-tier graph/Trie integration. Solved #212: Word Search II.

**Thoughts:** Day 139 locked in! Today I tackled Word Search II by combining a Trie with matrix backtracking. Searching for words individually via standard DFS would be extremely slow, but structuring the dictionary into a prefix tree allows the algorithm to check thousands of words simultaneously as it navigates the board. Storing the word directly at the Trie terminal node makes collection instantaneous. 139 days of elite consistency—just one day away from the 140-day milestone!

**Link to work:** [Day 139 - Word Search II](./Day139/WordSearchII.java)

### Day 140: August 14, 2026 ☎️ 140 DAYS: ENTERING BACKTRACKING ☎️

**Today's Progress:** Hit 140 consecutive days of coding! Transitioned into the Backtracking domain. Solved #17: Letter Combinations of a Phone Number.

**Thoughts:** Day 140 locked in! Today I tackled a classic permutation generation problem using DFS Backtracking. The biggest takeaway was upgrading from immutable `String` concatenation to a mutable `StringBuilder`. By explicitly appending a character, recursing, and then deleting the character (`deleteCharAt`), the true "choose, explore, un-choose" pattern of backtracking is revealed, drastically reducing memory overhead. 140 days of continuous growth!

**Link to work:** [Day 140 - Letter Combinations of a Phone Number](./Day140/LetterCombinationsOfAPhoneNumber.java)

### Day 141: August 15, 2026 🔢 COMBINATORIAL PRUNING 🔢

**Today's Progress:** Mastered search space optimization in Backtracking. Solved #77: Combinations.

**Thoughts:** Day 141 locked in! Today I implemented a classic backtracking algorithm to generate combinations. The core `choose -> explore -> undo` pattern feels very natural now. I leveled up the standard approach by adding mathematical branch pruning: by calculating the exact number of elements still needed, I restricted the `for` loop's upper bound so it never wastes time exploring branches that don't have enough numbers left to form a complete combination of size `k`.

**Link to work:** [Day 141 - Combinations](./Day141/Combinations.java)

### Day 142: August 16, 2026 🔄 IN-PLACE PERMUTATIONS 🔄

**Today's Progress:** Upgraded permutation generation to an in-place architecture. Solved #46: Permutations.

**Thoughts:** Day 142 locked in! Today I optimized the classic permutation backtracking algorithm. Instead of relying on a `boolean[] visited` array and a dynamic state list, I switched to an in-place array swapping technique. By swapping elements to lock them into the current index and then swapping them back during the backtrack phase, the algorithm runs significantly leaner and completely eliminates auxiliary space overhead. Closing out the weekend strong!

**Link to work:** [Day 142 - Permutations](./Day142/Permutations.java)

### Day 143: August 17, 2026 ✂️ AGGRESSIVE BRANCH PRUNING ✂️

**Today's Progress:** Kicked off a new week by optimizing state-space exploration. Solved #39: Combination Sum.

**Thoughts:** Day 143 locked in! Today I tackled Combination Sum using DFS backtracking. The key mechanic here was passing `i` instead of `i + 1` to allow for unlimited reuse of the same element. To optimize it to senior-level performance, I added an upfront `Arrays.sort(candidates)`. This allowed me to upgrade my `continue` statement to a `break` statement: the moment a candidate exceeds the target, the algorithm instantly prunes the entire rest of the loop, skipping thousands of useless recursive calls.

**Link to work:** [Day 143 - Combination Sum](./Day143/CombinationSum.java)

### Day 144: August 18, 2026 👑 N-QUEENS GEOMETRIC BACKTRACKING 👑

**Today's Progress:** Conquered the legendary N-Queens problem. Solved #52: N-Queens II (Hard).

**Thoughts:** Day 144 locked in! Today I solved the famous N-Queens puzzle using DFS backtracking. The most brilliant optimization here is bypassing the need for a 2D matrix scan by using 1D boolean arrays to track columns, main diagonals, and anti-diagonals. Because anti-diagonals share a constant `row + col` sum, and main diagonals share a constant `row - col` difference, I achieved `O(1)` constant-time lookups for checking if a square is under attack. Writing clean, efficient, Hard-tier algorithms is becoming second nature!

**Link to work:** [Day 144 - N-Queens II](./Day144/NQueensII.java)

### Day 145: August 19, 2026 🪢 CATALAN NUMBER BACKTRACKING 🪢

**Today's Progress:** Mastered early branch pruning in string combinations. Solved #22: Generate Parentheses.

**Thoughts:** Day 145 locked in! Today I implemented a highly efficient backtracking algorithm to generate well-formed parentheses. Instead of generating brute-force combinations and validating them later, I tracked `openCount` and `closeCount` to aggressively prune invalid branches on the fly. Adding a closing parenthesis is only permitted when `closeCount < openCount`, ensuring every sequence stays mathematically valid at every step. Time complexity matches the Catalan numbers—a brilliant optimization!

**Link to work:** [Day 145 - Generate Parentheses](./Day145/GenerateParentheses.java)

### Day 146: August 20, 2026 🕵️‍♂️ PRUNED MATRIX BACKTRACKING 🕵️‍♂️

**Today's Progress:** Mastered matrix backtracking and search space reduction. Solved #79: Word Search.

**Thoughts:** Day 146 locked in! Today I implemented a grid-based DFS backtracking solution. The basic in-place board modification was elegant, but I completely leveled up the solution by adding the LeetCode follow-up optimizations. By tracking board character frequencies, I can instantly fail impossible boards before starting the DFS. Even better, by checking if the first letter of the word is more common on the board than the last letter, I can reverse the search string to minimize the recursive branching factor. Algorithmic efficiency at its finest!

**Link to work:** [Day 146 - Word Search](./Day146/WordSearch.java)

### Day 147: August 21, 2026 🌳 DIVIDE AND CONQUER TREES 🌳

**Today's Progress:** Transitioned into Tree construction algorithms. Solved #108: Convert Sorted Array to Binary Search Tree.

**Thoughts:** Day 147 locked in! Wrapping up the work week by diving into Divide and Conquer. The process of converting a sorted array into a height-balanced BST is beautifully symmetrical to the Binary Search algorithm. By constantly picking the `midIndex` as the root node and recursively slicing the array into left and right bounds, the tree naturally balances itself. I made sure to use `left + (right - left) / 2` to avoid any sneaky integer overflow bugs. A phenomenal end to the week!

**Link to work:** [Day 147 - Convert Sorted Array to BST](./Day147/ConvertSortedArrayToBST.java)

### Day 148: August 22, 2026 🔗 LINKED LIST MERGE SORT 🔗

**Today's Progress:** Applied Divide and Conquer to Linked Lists. Solved #148: Sort List.

**Thoughts:** Day 148 locked in! Today I implemented Top-Down Merge Sort on a Linked List. Because linked lists do not have random access, standard sorting algorithms like Quick Sort struggle, making Merge Sort the undisputed best approach. The most critical part of the algorithm is initializing `fast = head.next` to ensure that a list of length 2 actually gets split into two lists of length 1, avoiding an infinite recursion loop. The resulting `O(n log n)` time complexity is perfectly optimal for this data structure!

**Link to work:** [Day 148 - Sort List](./Day148/SortList.java)

### Day 149: August 23, 2026 🗺️ SPATIAL QUAD TREES 🗺️

**Today's Progress:** Applied Divide and Conquer to 2D spatial partitioning. Solved #427: Construct Quad Tree.

**Thoughts:** Day 149 locked in! Today I explored Quad Trees, a specialized spatial data structure used heavily in rendering and collision detection. The algorithm recursively divides a 2D matrix into four quadrants. To make the code robust and enterprise-ready, I applied the Single Responsibility Principle, separating the "check if uniform" logic from the "recursively split geometry" logic. This made the core Divide and Conquer pattern crystal clear. Tomorrow is Day 150—an absolutely massive milestone!

**Link to work:** [Day 149 - Construct Quad Tree](./Day149/ConstructQuadTree.java)

### Day 150: August 24, 2026 🏆 DAY 150 MILESTONE: MERGE K LISTS 🏆

**Today's Progress:** Hit 150 continuous days of problem-solving! Solved the classic Hard problem #23: Merge k Sorted Lists.

**Thoughts:** Day 150 is officially in the books! Half a year of continuous momentum. I chose to tackle a Hard problem to celebrate, using a Min-Heap (Priority Queue) to merge `k` sorted linked lists. By maintaining a heap of size `k`, I achieved an optimal `O(N log k)` time complexity. I also upgraded my comparator to `Comparator.comparingInt(node -> node.val)` to prevent any potential integer overflow vulnerabilities that can occur with simple subtraction. This level of consistency is transforming my architectural thinking. Onward to the next 150!

**Link to work:** [Day 150 - Merge k Sorted Lists](./Day150/MergeKSortedLists.java)

### Day 151: August 25, 2026 📈 DIVIDE & CONQUER SUBARRAYS 📈

**Today's Progress:** Tackled the advanced follow-up for #53: Maximum Subarray.

**Thoughts:** Day 151 locked in! I started with Kadane's algorithm, which easily solves this in `O(N)` time and `O(1)` space. However, I wanted to conquer the LeetCode follow-up challenge: implementing the Divide and Conquer approach. I built a custom `SubarrayNode` class to track the total sum, max prefix, max suffix, and max continuous sum for every array segment. This architectural pattern forms the exact basis of a Segment Tree, turning a simple array problem into a scalable blueprint for distributed data processing. Post-milestone momentum feels great!

**Link to work:** [Day 151 - Maximum Subarray](./Day151/MaximumSubarray.java)

### Day 152: August 26, 2026 ⭕ CIRCULAR KADANE'S ALGORITHM ⭕

**Today's Progress:** Solved a brilliant mathematical twist on Kadane's Algorithm. Solved #918: Maximum Sum Circular Subarray.

**Thoughts:** Day 152 locked in! Today I took yesterday's Maximum Subarray logic and applied it to a circular array. The trick here is recognizing mathematical duality: a wrapped-around maximum subarray is just the total sum of the array minus the minimum contiguous subarray in the middle. By running Kadane's algorithm twice in a single pass (once to find the max, once to find the min), I solved it in `O(N)` time and `O(1)` space. I also made sure to catch the edge case where all numbers are negative to prevent returning an empty `0` sum. Another elite array algorithm in the toolkit!

**Link to work:** [Day 152 - Maximum Sum Circular Subarray](./Day152/MaximumSumCircularSubarray.java)

### Day 153: August 27, 2026 🔍 BINARY SEARCH INSERTION 🔍

**Today's Progress:** Solidified O(log N) array traversal. Solved #35: Search Insert Position.

**Thoughts:** Day 153 locked in! Today I implemented a classic Binary Search to find a target's insertion position. The true beauty of this algorithm lies in the termination state of the `while (lowerBound <= upperBound)` loop. When the loop finishes without finding the target, the pointers cross, and the `lowerBound` naturally rests on the exact index where the target belongs to keep the array sorted. It's a mathematically elegant `O(log N)` solution that requires no extra conditional checks at the end.

**Link to work:** [Day 153 - Search Insert Position](./Day153/SearchInsertPosition.java)

### Day 154: August 28, 2026 🧮 VIRTUAL ARRAY BINARY SEARCH 🧮

**Today's Progress:** Mastered index mapping for multi-dimensional search. Solved #74: Search a 2D Matrix.

**Thoughts:** Day 154 locked in! Today I took standard Binary Search and applied it to a 2D matrix. Instead of performing multiple searches, I treated the entire $M \times N$ matrix as a single flattened 1D array. By using integer division (`mid / cols`) to find the row and the modulo operator (`mid % cols`) to find the column, I achieved a pure `O(log(M * N))` solution in a single pass. This mathematical index mapping is identical to how RAM handles multi-dimensional arrays under the hood. A perfect way to finish the week!

**Link to work:** [Day 154 - Search a 2D Matrix](./Day154/SearchA2DMatrix.java)

### Day 155: August 29, 2026 🏔️ GRADIENT BINARY SEARCH 🏔️

**Today's Progress:** Solved a classic algorithm trap. Applied Binary Search to an unsorted array for #162: Find Peak Element.

**Thoughts:** Day 155 locked in on a Saturday! Today I tackled a problem that tricks a lot of developers into writing `O(N)` linear scans because the array isn't sorted. However, because the problem defines edges as `-∞`, you can use Binary Search based purely on local slopes (gradients). If `nums[mid] < nums[mid+1]`, you are climbing, so the peak must be to the right. If you are falling, the peak must be at `mid` or to the left. By using the `left < right` template and setting `right = mid` (instead of `mid - 1`), the pointers beautifully converge on a local peak in `O(log n)` time. A masterclass in algorithmic principles!

**Link to work:** [Day 155 - Find Peak Element](./Day155/FindPeakElement.java)

### Day 156: August 30, 2026 🔄 ROTATED BINARY SEARCH 🔄

**Today's Progress:** Solved a FAANG classic algorithm. Mastered #33: Search in Rotated Sorted Array.

**Thoughts:** Day 156 locked in! Today I used Binary Search to traverse an array that has been rotated at an unknown pivot. The trick here is accepting that you can't just do normal binary search because the numbers aren't purely ascending. However, if you pick any midpoint, _one of the halves will always be sorted_. By checking if the left side is sorted (`nums[left] <= nums[mid]`), I can determine if my target fits securely in that boundary. If it does, discard the right. If it doesn't, discard the left. It maintains perfect `O(log N)` complexity. A great end to the weekend!

**Link to work:** [Day 156 - Search in Rotated Sorted Array](./Day156/SearchInRotatedSortedArray.java)

### Day 157: September 1, 2026 ⏪ REVERSE IN-PLACE MERGE ⏪

**Today's Progress:** Kicked off September by optimizing array manipulation space complexity. Solved #88: Merge Sorted Array.

**Thoughts:** Day 157 locked in! I initially wrote a standard `O(m + n)` time and `O(m + n)` space merge function using a temporary array. To hit the true optimal solution, I refactored it to use an In-Place Reverse Merge. By setting up three pointers (`p1`, `p2`, and `pMerge`) and starting from the _end_ of the arrays, I was able to safely overwrite the padded zeroes in `nums1` with the largest elements first. This brought the space complexity down to `O(1)` without losing any time efficiency. Working backwards is a brilliant trick for in-place array modifications!

**Link to work:** [Day 157 - Merge Sorted Array](./Day157/MergeSortedArray.java)

### Day 158: September 2, 2026 🎯 BOUNDARY BINARY SEARCH 🎯

**Today's Progress:** Mastered the DRY principle with Binary Search. Solved #34: Find First and Last Position of Element in Sorted Array.

**Thoughts:** Day 158 locked in! Today I used Binary Search to find the exact boundary indices of a target value in an array containing duplicates. Instead of doing a linear scan once the target is found (which ruins the `O(log n)` complexity), I forced the binary search to keep aggressively searching left for the first occurrence, and right for the last occurrence. To elevate the code quality, I applied the DRY (Don't Repeat Yourself) principle, combining two nearly identical methods into a single `findBound` helper function controlled by a boolean flag. I also added a minor optimization to skip the second search if the first search returns `-1`. Clean, enterprise-ready code!

**Link to work:** [Day 158 - Find First and Last Position](./Day158/FindFirstAndLastPosition.java)

### Day 159: September 3, 2026 ⬛ SQUARES OF A SORTED ARRAY ⬛

**Today's Progress:** Hit the O(N) follow-up requirement for array sorting. Solved #977: Squares of a Sorted Array.

**Thoughts:** Day 159 in the books! Switched gears to C++ today and wanted to keep my exact, unedited thought process logged. The challenge was to sort the squares in `O(N)` time instead of the trivial `O(N log N)` sort. I solved this by explicitly dividing the array into two separate vectors for negative and positive numbers. Since squaring negative numbers reverses their relative sorted order, I reversed the negative vector after squaring. Finally, I applied a standard two-pointer merge to combine the two sorted halves into the final result. It’s raw, it’s real, and it perfectly nails the algorithmic time constraint!

**Link to work:** [Day 159 - Squares of a Sorted Array](./Day159/SquaresOfASortedArray.cpp)
