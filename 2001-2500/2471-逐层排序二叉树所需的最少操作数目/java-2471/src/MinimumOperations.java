import java.util.Arrays;
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

class MinimumOperations {
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();

            int[] curVals = new int[len];
            int idx = 0;
            for (int i = 0; i < len; i++) {
                TreeNode curNode = queue.poll();
                curVals[idx] = curNode.val;
                idx++;
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }

            res += minSwap(curVals);
        }
        return res;
    }
    private int minSwap(int[] nums) {
        int n = nums.length;

        int[][] numsPos = new int[n][2];
        for (int i = 0; i < n; i++) {
            numsPos[i][0] = nums[i];
            numsPos[i][1] = i;
        }

        int res = 0;
        Arrays.sort(numsPos, (a, b) -> a[0] - b[0]);
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] || numsPos[i][1] == i) {
                continue;
            }
            int j = i;
            int cycleSize = 0;
            while (!visited[j]) {
                visited[j] = true;
                j = numsPos[j][1];
                cycleSize ++;
            }

            if (cycleSize > 0) {
                res += cycleSize - 1;
            }
        }
        return res;
    }
}