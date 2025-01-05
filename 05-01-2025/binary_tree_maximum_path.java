
public class binary_tree_maximum_path {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE; // Initialize the global max sum
        dfs(root); // Start the DFS traversal
        return maxSum; // Return the global max sum
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0; // Base case: no contribution from null node
        }

        // Recursively calculate the maximum gain from left and right subtrees
        int leftGain = Math.max(dfs(node.left), 0);
        int rightGain = Math.max(dfs(node.right), 0);

        // Calculate the price of the new path passing through the current node
        int priceNewPath = node.val + leftGain + rightGain;

        // Update the global max sum if the new path's sum is greater
        maxSum = Math.max(maxSum, priceNewPath);

        // Return the maximum gain the current node can contribute to its parent
        return node.val + Math.max(leftGain, rightGain);
    }
}
