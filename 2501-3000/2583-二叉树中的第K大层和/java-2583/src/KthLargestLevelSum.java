import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class KthLargestLevelSum {
    Map<Integer, Long> map;
    public long kthLargestLevelSum(TreeNode root, int k) {
        map = new HashMap<>();
        dfs(root, 0);

        ArrayList<Long> list = new ArrayList<>();
        for (Map.Entry entry : map.entrySet()) {
            list.add((long) entry.getValue());
        }
        Collections.sort(list);
        if (list.size() < k) return -1;
        return list.get(list.size() - k);
    }
    private void dfs(TreeNode root, int dep) {
        if (root == null) return;
        map.put(dep, map.getOrDefault(dep, 0l) + root.val);
        dfs(root.left, dep + 1);
        dfs(root.right, dep + 1);
    }
}