var lowestCommonAncestor = function (root, p, q) {
  // Base case
  if (root === null) {
    return null;
  }

  // If current node is p or q
  if (root === p || root === q) {
    return root;
  }

  // Search in left and right subtree
  let left = lowestCommonAncestor(root.left, p, q);
  let right = lowestCommonAncestor(root.right, p, q);

  // Both sides found something
  if (left !== null && right !== null) {
    return root;
  }

  // Return whichever side is not null
  return left !== null ? left : right;
};
