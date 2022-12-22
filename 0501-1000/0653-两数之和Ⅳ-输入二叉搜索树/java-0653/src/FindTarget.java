import java.util.HashSet;

class FindTarget {
    HashSet<Integer> set;
    int k;
    boolean res;
    public boolean findTarget(TreeNode root, int k) {
        this.k = k;
        res = false;
        set = new HashSet<>();
        inorder(root);
        return res;
    }
    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        if (set.contains(k - root.val)) {
            res = true;
            return;
        }
        set.add(root.val);
        inorder(root.right);
    }
}