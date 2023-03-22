class RepairCars {
    public long repairCars(int[] ranks, int cars) {
        int n = ranks.length;
        int max = ranks[0];
        for (int x : ranks) {
            max = Math.max(max, x);
        }

        long l = 1, r = (long) max * cars * cars;
        while (l < r) {
            long mid = l + (r - l) / 2;
            if (check(ranks, cars, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    private boolean check(int[] nums, int cars, long mid) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            double cnt = mid / nums[i];
            res += Math.floor(Math.sqrt(cnt));
        }
        return res >= cars;
    }
}