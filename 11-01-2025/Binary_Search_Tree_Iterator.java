public class Binary_Search_Tree_Iterator {
    public class TreeNode {
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

    class BSTIterator {
        private Stack<TreeNode> stack;

        // Constructor: Initialize the stack and push leftmost nodes.
        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            pushLeft(root);
        }

        // Push all left nodes of a given tree onto the stack.
        private void pushLeft(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        // next() returns the next smallest element.
        public int next() {
            TreeNode node = stack.pop(); // Get the top element.
            if (node.right != null) {
                pushLeft(node.right); // Push leftmost nodes of right subtree.
            }
            return node.val;
        }

        // hasNext() checks if there are more elements in the traversal.
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

}
