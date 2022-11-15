class SubarrayLCM {
    public int subarrayLCM(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            if (cur == k) res++;
            for (int j = i - 1; j >= 0; j--) {
                cur = lcm(cur, nums[j]);
                if (cur == k) {
                    res++;
                } else if (cur > k) break;
            }

        }
        return res;
    }

    private int lcm(int x, int y) {
        return x * y / gcd(x, y);
    }

    private int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}