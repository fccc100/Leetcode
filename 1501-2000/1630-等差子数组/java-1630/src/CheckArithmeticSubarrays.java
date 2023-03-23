import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CheckArithmeticSubarrays {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = l.length;
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (r[i] - l[i] <= 0) {
                res.add(false);
                continue;
            }
            int[] subArr = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            Arrays.sort(subArr);
            int diff = subArr[1] - subArr[0];
            boolean b = true;
            for (int j = 2; j < subArr.length; j++) {
                if (subArr[j] - subArr[j - 1] != diff) {
                    b = false;
                    break;
                }
            }
            res.add(b);
        }
        return res;
    }
}