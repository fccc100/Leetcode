import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class SingleNumbers {
    public int[] singleNumbers(int[] nums) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (Map.Entry entry: map.entrySet()) {
            if (entry.getValue().equals(1)) {
                res.add((Integer) entry.getKey());
            }
        }

        int[] ans = {res.get(0), res.get(1)};
        return ans;
    }
}