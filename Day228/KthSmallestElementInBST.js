var kthSmallest = function (root, k) {
  let count = 0;
  let answer = null;

  function inorder(node) {
    if (node === null || answer !== null) {
      return;
    }

    // Step 1: Visit left subtree
    inorder(node.left);

    // Step 2: Visit current node
    count++;

    if (count === k) {
      answer = node.val;
      return;
    }

    // Step 3: Visit right subtree
    inorder(node.right);
  }

  inorder(root);

  return answer;
};
