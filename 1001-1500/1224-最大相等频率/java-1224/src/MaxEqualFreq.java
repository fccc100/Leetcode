import java.util.HashMap;
import java.util.Map;

class MaxEqualFreq {
    public int maxEqualFreq(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        int max = 0, res = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            if (cnt.containsKey(x) && cnt.get(x) > 0) {
                int x_cnt = cnt.get(x);
                freq.put(x_cnt, freq.get(x_cnt) - 1);
            }

            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
            freq.put(cnt.get(x), freq.getOrDefault(cnt.get(x), 0) + 1);
            max = Math.max(max, cnt.get(x));

            boolean ok = max == 1;
            ok = ok || max * freq.get(max) + 1 == i + 1;
            ok = ok || (max - 1) * (freq.get(max - 1) + 1) + 1 == i + 1;
            if (ok) {
                res = Math.max(res, i + 1);
            }
        }
        return res;
    }
}