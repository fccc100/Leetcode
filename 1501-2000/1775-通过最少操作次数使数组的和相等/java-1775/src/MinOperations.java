import java.util.Arrays;
import java.util.Collections;

class MinOperations {
    public int minOperations(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int sum1 = 0;
        for (int i = 0; i < m; i++) {
            sum1 += nums1[i];
        }
        int sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum2 += nums2[i];
        }

        if (sum1 == sum2) {
            return 0;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int res = 0;
        int i = 0, j = n - 1;
        int t = Math.abs(sum2 - sum1);
        if (sum1 < sum2) {
            while (t > 0 && (i < m || j >= 0)) {
                if (i >= m) {
                    t -= nums2[j] - 1;
                    j--;
                    res++;
                    continue;
                }
                if (j < 0) {
                    t -= 6 - nums1[i];
                    i++;
                    res++;
                    continue;
                }
                int max = Math.max(6 - nums1[i], nums2[j] - 1);
                if (max == 0) return -1;
                if (6 - nums1[i] == max) {
                    i++;
                } else {
                    j--;
                }
                t -= max;
                res++;
            }
            if (t > 0) return -1;
            return res;
        } else {
            j = m - 1;
            while (t > 0 && (i < n || j >= 0)) {
                if (i >= n) {
                    t -= nums1[j] - 1;
                    j--;
                    res++;
                    continue;
                }
                if (j < 0) {
                    t -= 6 - nums2[i];
                    i++;
                    res++;
                    continue;
                }
                int max = Math.max(6 - nums2[i], nums1[j] - 1);
                if (max == 0) return -1;
                if (6 - nums2[i] == max) {
                    i++;
                } else {
                    j--;
                }
                t -= max;
                res++;
            }
            if (t > 0) return -1;
            return res;
        }
    }
}
// nums1 = [1,2,3,4,5,6], nums2 = [1,1,2,2,2,2]
//          21                     10
//