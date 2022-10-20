import java.util.HashMap;

class DistinctNumbers {
    public int[] distinctNumbers(int[] nums, int k) {
        int n = nums.length;

        int[] res = new int[n - k + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        while (r < k) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            r++;
        }
        r--;
        res[0] = map.size();

        int idx = 1;
        while (r + 1 < n) {
            r++;
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            map.put(nums[l], map.get(nums[l]) - 1);
            if (map.get(nums[l]) == 0) {
                map.remove(nums[l]);
            }
            l++;
            res[idx] = map.size();
            idx++;
        }
        return res;
    }
}