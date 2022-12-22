import java.util.ArrayList;

class IsValidBST {
    ArrayList<Integer> res;
    public boolean isValidBST(TreeNode root) {
        res = new ArrayList<>();
        inorder(root);
        int cur = res.get(0);
        for (int i = 1; i < res.size(); i++) {
            if (res.get(i) <= cur) {
                return false;
            }
            cur = res.get(i);
        }
        return true;
    }
    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
    }
}