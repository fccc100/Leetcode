import com.sun.tools.javac.util.List;

import java.util.ArrayList;

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
class ClosestNodes {
    ArrayList<Integer> nums;
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        nums = new ArrayList<>();
        inorder(root);

        int n = queries.size();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> cur = new ArrayList<>();

            int min = upper_floor(nums, queries.get(i));
            cur.add(min < 0 ? -1 : nums.get(min));

            int max = lower_ceil(nums, queries.get(i));
            cur.add(max >= nums.size() ? -1 : nums.get(max));
            res.add(cur);
        }
        return res;
    }
    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        nums.add(root.val);
        inorder(root.right);
    }
    private int upper_floor(ArrayList<Integer> nums, int target) {
        int l = -1;
        int r = nums.size() - 1;
        while (l < r) {
            int mid = l + (r - l + 1 >> 1);

            if (nums.get(mid) <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
    private int lower_ceil(ArrayList<Integer> nums, int target) {
        int l = 0;
        int r = nums.size();
        while (l < r) {
            int mid = l + (r - l >> 1);
            if (nums.get(mid) < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}