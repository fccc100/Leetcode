class DiameterOfBinaryTree {
    int res;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return res;
    }
    private int dfs(TreeNode root) {
        if (root == null) return -1;
        int leftDiameter = dfs(root.left) + 1;
        int rightDiameter = dfs(root.right) + 1;
        res = Math.max(res, leftDiameter + rightDiameter);
        return Math.max(leftDiameter, rightDiameter);
    }
}