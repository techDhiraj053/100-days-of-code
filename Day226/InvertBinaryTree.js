/*
226. Invert Binary Tree (Iterative DFS + ES6 Destructuring - DAY 226!)

Time Complexity: O(N) where N is the number of nodes.
Space Complexity: O(H) for the explicit stack (O(N) in the worst case of a skewed tree).

Senior Twist: ES6 Destructuring & Heap-Allocated Stack.
While the recursive solution is concise, deeply unbalanced trees can trigger a 
`Maximum call stack size exceeded` error in the V8 JavaScript engine. By using 
an explicit stack array, we move the traversal state to the heap. Combined with 
ES6 array destructuring for a clean one-line swap, this is production-ready JS.
*/

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */

/**
 * @param {TreeNode} root
 * @return {TreeNode}
 */
var invertTree = function (root) {
  if (root === null) return null;

  // Explicit stack to avoid V8 call stack limits on deep trees
  const stack = [root];

  while (stack.length > 0) {
    const curr = stack.pop();

    // Modern ES6 destructuring swap (no temp variable needed)
    [curr.left, curr.right] = [curr.right, curr.left];

    if (curr.left !== null) stack.push(curr.left);
    if (curr.right !== null) stack.push(curr.right);
  }

  return root;
};
