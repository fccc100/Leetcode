import java.util.HashMap;

class CountGood {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        if (n <= 1) return 0;

        int l = 0;
        int r = 1;
        int cnt = nums[0] == nums[1] ? 1 : 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        if (nums[0] == nums[1]) {
            map.put(nums[0], 2);
        } else {
            map.put(nums[0], 1);
            map.put(nums[1], 1);
        }
        int res = 0;
        while (l < n && r < n) {
            if (cnt < k) {
                r++;
                if (r >= n) break;
                int preCnt = map.getOrDefault(nums[r], 0);
                cnt += preCnt;
                map.put(nums[r], preCnt + 1);
            } else {
                res += n - r;
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                cnt -= map.getOrDefault(nums[l], 0);
                l++;
            }
        }
        return res;
    }
}