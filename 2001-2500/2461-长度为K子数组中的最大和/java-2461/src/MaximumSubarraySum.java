import java.util.HashMap;

class MaximumSubarraySum {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;

        int l = 0;
        int r = 0;
        long curSum = 0;
        long res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (; r < k; r++) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            curSum += nums[r];
        }
        r--;

        if (map.size() == k) {
            res = curSum;
        }

        while (r + 1 < n) {
            r++;
            curSum += nums[r];
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            map.put(nums[l], map.get(nums[l]) - 1);
            if (map.get(nums[l]) == 0) {
                map.remove(nums[l]);
            }
            curSum -= nums[l];
            l++;

            if (map.size() == k) {
                res = Math.max(res, curSum);
            }
        }
        return res;
    }
}