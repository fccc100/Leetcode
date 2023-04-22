class MaxAncestorDiff {
    int res;
    public int maxAncestorDiff(TreeNode root) {
        int[] rootRes = dfs(root);
        res = Math.max(res, Math.abs(root.val - rootRes[0]));
        res = Math.max(res, Math.abs(root.val - rootRes[1]));
        return res;
    }
    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int min = Math.min(left[0], right[0]);
        if (min != Integer.MAX_VALUE) {
            res = Math.max(res, Math.abs(root.val - min));
        }
        min = Math.min(root.val, min);

        int max = Math.max(left[1], right[1]);
        if (max != Integer.MIN_VALUE) {
            res = Math.max(res, Math.abs(root.val - max));
        }
        max = Math.max(root.val, max);

        return new int[]{min, max};
    }
}