class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        return root;
    }
}