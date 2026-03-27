class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // empty tree
        if (root == null) return false;

        // if leaf node
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // check left or right subtree
        return hasPathSum(root.left, targetSum - root.val) ||
               hasPathSum(root.right, targetSum - root.val);
    }
}