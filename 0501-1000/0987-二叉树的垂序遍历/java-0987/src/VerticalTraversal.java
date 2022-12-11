import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class VerticalTraversal {
    HashMap<TreeNode, Integer> map;
    TreeMap<Integer, List<Integer>> res;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new HashMap<>();
        res = new TreeMap<>();
        dfs(root, 0);
        levelOrder(root);

        List<List<Integer>> ans = new ArrayList<>();
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

    private void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();

            HashMap<Integer, ArrayList<Integer>> tempMap = new HashMap<>();
            for (int i = 0; i < len; i++) {
                TreeNode curNode = queue.poll();
                int curK = map.get(curNode);
                if (!tempMap.containsKey(curK)) {
                    tempMap.put(curK, new ArrayList<>());
                }
                tempMap.get(curK).add(curNode.val);

                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }

            for (Map.Entry entry : tempMap.entrySet()) {
                int k = (int) entry.getKey();
                List<Integer> cur = (List) entry.getValue();
                Collections.sort(cur);
                if (!res.containsKey(k)) {
                    res.put(k, new ArrayList<>());
                }
                res.get(k).addAll(cur);
            }
        }
    }
}