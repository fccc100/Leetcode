import java.util.*;

class FrequencySort {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        ArrayList<int[]> pairs = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int[] cur = new int[2];
            cur[0] = entry.getKey();
            cur[1] = entry.getValue();
            pairs.add(cur);
        }

        Collections.sort(pairs, (a, b) -> {
            if (a[1] < b[1]) {
                return -1;
            } else if (a[1] == b[1]) {
                return b[0] - a[0];
            } else {
                return 1;
            }
        });

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < pairs.size(); i++) {
            for (int j = 0; j < pairs.get(i)[1]; j++) {
                res.add(pairs.get(i)[0]);
            }
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }
}