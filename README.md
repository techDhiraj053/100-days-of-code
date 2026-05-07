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
