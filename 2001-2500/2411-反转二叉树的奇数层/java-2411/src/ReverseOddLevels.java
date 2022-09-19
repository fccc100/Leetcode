import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
class ReverseOddLevels {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curLevel = 0;

        while (!queue.isEmpty()) {
            int len = queue.size();

            ArrayList<TreeNode> nodeList = new ArrayList<>();
            ArrayList<Integer> valList = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode cur = queue.poll();

                nodeList.add(cur);
                valList.add(cur.val);

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }

            if (curLevel % 2 == 1) {
                for (int i = 0; i < nodeList.size(); i++) {
                    nodeList.get(i).val = valList.get(len - i - 1);
                }
            }

            curLevel++;
        }
        return root;
    }
}