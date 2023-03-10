import java.util.HashMap;
import java.util.Map;

class MinSubarray {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long[] presum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }

        int res = n;
        long mod = presum[n] % p;
        if (mod == 0) return 0;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0l, -1);
        for (int i = 1; i <= n; i++) {
            long curMod = presum[i] % p;
            long targetMod = curMod >= mod ? curMod - mod : curMod - mod + p;

            if (map.containsKey(targetMod)) {
                res = Math.min(res, i - 1 - map.get(targetMod));
            }
            map.put(curMod, i - 1);
        }
        return res == n ? -1 : res;
    }
}
// [3,1,4,2] 6
// [3,4,8,10]

// [  6,3, 5, 2] 9
// [0,6,9,14,16]
// mod 7
// [0,6,0,5,

// sum(nums) = a
// a % p = k , k = 0, 返回0
// (a - b) % p = 0
// => b % p = k
