import java.util.HashMap;

class CountSubarrays {
    public int countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int kIdx = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == k) {
                kIdx = i;
                break;
            }
        }
        if (kIdx < 0) return 0;

        int res = 1;
        HashMap<Integer, Integer> leftMap = new HashMap<>();
        int min = 0, max = 0;
        for (int i = kIdx - 1; i >= 0; i--) {
            if (nums[i] > k) {
                max++;
            } else {
                min++;
            }

            leftMap.put(max - min, leftMap.getOrDefault(max - min, 0) + 1);
            if (max == min || min == max - 1) {
                res++;
            }
        }

        min = 0;
        max = 0;
        HashMap<Integer, Integer> rightMap = new HashMap<>();
        for (int i = kIdx + 1; i < n; i++) {
            if (nums[i] > k) {
                max++;
            } else {
                min++;
            }

            rightMap.put(i, max - min);
            if (max == min || min == max - 1) {
                res++;
            }
        }

        for (int i = kIdx + 1; i < n; i++) {
            int cur = rightMap.get(i);
            if (leftMap.containsKey(-cur)) {
                res += leftMap.get(-cur);
            }
            if (leftMap.containsKey(1 - cur)) {
                res += leftMap.get(1 - cur);
            }
        }
        return res;
    }
}