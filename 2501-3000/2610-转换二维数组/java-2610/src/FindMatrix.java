import java.util.*;

class FindMatrix {
    public List<List<Integer>> findMatrix(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            max = Math.max(max, map.get(nums[i]));
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            List<Integer> cur = new ArrayList<>();
            for (Iterator it = map.entrySet().iterator(); it.hasNext();) {
                Map.Entry<Integer, Integer> next = (Map.Entry<Integer, Integer>) it.next();
                cur.add(next.getKey());
                next.setValue(next.getValue() - 1);
                if (next.getValue() == 0) {
                    it.remove();
                }
            }
            res.add(cur);
        }
        return res;
    }
}