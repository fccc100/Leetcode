import java.util.HashMap;

class CanDivideIntoSubsequences {
    public boolean canDivideIntoSubsequences(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            max = Math.max(max, map.get(nums[i]));
        }

        return max * k <= n;
    }
}