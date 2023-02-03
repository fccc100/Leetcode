/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BtreeGameWinningMove {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode node = getNode(root, x);
        int leftCnt = getCount(node.left);
        int rightCnt = getCount(node.right);
        int parentCnt = n - leftCnt - rightCnt - 1;
        int k = n / 2;
        if (leftCnt > k || rightCnt > k || parentCnt > k) {
            return true;
        }
        return false;
    }

    private TreeNode getNode(TreeNode root, int x) {
        if (root == null) {
            return null;
        }
        if (root.val == x) return root;

        TreeNode res = getNode(root.left, x);
        return res != null ? res : getNode(root.right, x);
    }

    private int getCount(TreeNode root) {
        if (root == null) return 0;
        int leftCnt = getCount(root.left);
        int rightCnt = getCount(root.right);
        return 1 + leftCnt + rightCnt;
    }
}