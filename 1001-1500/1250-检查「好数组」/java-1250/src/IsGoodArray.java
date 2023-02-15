class IsGoodArray {
    public boolean isGoodArray(int[] nums) {
        int res = nums[0];
        for (int x : nums) {
            res = gcd(res, x);
            if (res == 1) break;
        }
        return res == 1;
    }
    private int gcd(int x, int y) {
        if (y == 0) return x;
        return gcd(y, x % y);
    }
}