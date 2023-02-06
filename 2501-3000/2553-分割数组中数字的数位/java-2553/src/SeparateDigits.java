import java.util.List;

import java.util.ArrayList;
import java.util.Collections;

class SeparateDigits {
    public int[] separateDigits(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> cur = new ArrayList<>();
            int x = nums[i];
            while (x > 0) {
                cur.add(x % 10);
                x /= 10;
            }
            Collections.reverse(cur);
            res.addAll(cur);
        }
        int[] ans = new int[res.size()];
        int idx = 0;
        for (int x : res) {
            ans[idx] = x;
            idx++;
        }
        return ans;
    }
}