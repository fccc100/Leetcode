class MaxPower {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long[] presum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i - 1] + stations[i - 1];
        }
        long[] power = new long[n];
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            power[i] = presum[Math.min(i + r + 1, n)] - presum[Math.max(0, i - r)];
            min = Math.min(power[i], min);
        }

        long left = min;
        long right = min + k;
        while (left < right) {
            long mid = left + (right - left + 1 >> 1);
            if (check(power, r, k, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean check(long[] nums, int r, int k, long mid) {
        int n = nums.length;
        long[] diff = new long[n + 1];
        long sumDiff = 0;
        long need = 0;
        for (int i = 0; i < n; i++) {
            sumDiff += diff[i];
            // 缺m个发电站
            long m = mid - (nums[i] + sumDiff);
            if (m > 0) {
                need += m;
                if (need > k) return false;
                sumDiff += m;
                if (i + r * 2 + 1 < n) {
                    diff[i + r * 2 + 1] -= m;
                }
            }
        }
        return true;
    }
}