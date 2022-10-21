import java.util.HashMap;
import java.util.HashSet;

class MaximumUniqueSubarray {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;

        int l = 0;
        int r = -1;
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        int res = 0;
        while (r + 1 < n) {
            if (!set.contains(nums[r + 1])) {
                r++;
                set.add(nums[r]);
                sum += nums[r];
                res = Math.max(res, sum);
            } else {
                set.remove(nums[l]);
                sum -= nums[l];
                l++;
            }
        }
        return res;
    }
}