import java.util.HashMap;
import java.util.Map;

class FindSmallestInteger {
    public int findSmallestInteger(int[] nums, int value) {
        int n = nums.length;
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        for (int i = 0; i < n; i++) {
            long val = nums[i] + 10000000000l * value;
            val %= value;
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        long cur = 0;
        int res = 0;
        while (true) {
            if (map.containsKey(cur)) {
                res++;
                map.put(cur, map.get(cur) - 1);
                if (map.get(cur) == 0) {
                    map.remove(cur);
                }
                cur = (cur + 1) % value;
            } else {
                return res;
            }
        }
    }
}