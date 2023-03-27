import java.util.ArrayList;
import java.util.List;

class BeautifulSubsets {
    int res;
    public int beautifulSubsets(int[] nums, int k) {
        res = 0;
        subsets(nums, 0, new ArrayList<Integer>(), k);
        return res - 1;
    }
    private void subsets(int[] nums, int idx, List<Integer> path, int k) {
        res++;
        if (idx == nums.length) return;

        for (int i = idx; i < nums.length; i++) {
            if (path.contains(nums[i] - k) || path.contains(nums[i] + k)) {
                continue;
            }
            path.add(nums[i]);
            subsets(nums, i + 1, path, k);
            path.remove(path.size() - 1);
        }
    }
}
