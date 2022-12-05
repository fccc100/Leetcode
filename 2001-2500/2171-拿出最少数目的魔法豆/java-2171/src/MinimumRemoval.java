import java.util.Arrays;

class MinimumRemoval {
    public long minimumRemoval(int[] beans) {
        int n = beans.length;

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += beans[i];
        }

        Arrays.sort(beans);
        long presum = 0;
        long res = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, presum + (sum - presum - beans[i] - ((long)beans[i] * (n - i - 1))));
            presum += beans[i];
        }
        return res;
    }
}