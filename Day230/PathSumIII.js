var pathSum = function (root, targetSum) {
  if (!root) return 0;

  function dfs(node, remaining) {
    if (!node) return 0;

    let count = 0;

    if (node.val === remaining) {
      count++;
    }

    count += dfs(node.left, remaining - node.val);
    count += dfs(node.right, remaining - node.val);

    return count;
  }

  return (
    dfs(root, targetSum) +
    pathSum(root.left, targetSum) +
    pathSum(root.right, targetSum)
  );
};
