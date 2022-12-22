public class IsValidBST2 {
    public boolean isValidBST(TreeNode root) {
        return check(root.left, Long.MIN_VALUE, root.val) && check(root.right, root.val, Long.MAX_VALUE);
    }
    private boolean check(TreeNode root, long min, long max) {
        if (root == null) return true;

        if (root.val <= min || root.val >= max) {
            return false;
        }
        return check(root.left, min, root.val) && check(root.right, root.val, max);
    }
}
