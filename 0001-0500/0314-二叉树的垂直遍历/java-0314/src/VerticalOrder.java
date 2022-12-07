import java.util.*;

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
class VerticalOrder {
    HashMap<TreeNode, Integer> map;
    TreeMap<Integer, List<Integer>> res;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        map = new HashMap<>();
        res = new TreeMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        dfs(root, 0);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode curNode = queue.poll();
                int curK = map.get(curNode);
                if (!res.containsKey(curK)) {
                    res.put(curK, new ArrayList<>());
                }
                res.get(curK).add(curNode.val);
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
        }

        for (Map.Entry entry : res.entrySet()) {
            ans.add((List) entry.getValue());
        }

        return ans;
    }
    private void dfs(TreeNode root, int k) {
        if (root == null) return;

        map.put(root, k);
        dfs(root.left, k - 1);
        dfs(root.right, k + 1);
    }
}