import java.util.List;

import java.util.TreeSet;

class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int n = nums.size();

        TreeSet<Integer> lTs = new TreeSet<>();
        TreeSet<Integer> rTs = new TreeSet<>();
        for (int i = x; i < n; i++) {
            rTs.add(nums.get(i));
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (i - x >= 0) {
                lTs.add(nums.get(i - x));
            }
            Integer v = nums.get(i);
            Integer l1 = lTs.floor(v);
            Integer l2 = lTs.ceiling(v);

            Integer r1 = rTs.floor(v);
            Integer r2 = rTs.ceiling(v);
            if (l1 != null) res = Math.min(res, Math.abs(l1 - v));
            if (l2 != null) res = Math.min(res, Math.abs(l2 - v));
            if (r1 != null) res = Math.min(res, Math.abs(r1 - v));
            if (r2 != null) res = Math.min(res, Math.abs(r2 - v));


            if (i + x < n) {
                rTs.remove(nums.get(i + x));
            }
        }
        return res;
    }
}
