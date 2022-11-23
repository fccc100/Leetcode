class NthMagicalNumber {
    public int nthMagicalNumber(int n, int a, int b) {
        int mod = 1000000007;
        long l = Math.min(a, b) - 1;
        long r = (long) Math.min(a, b) * n;

        int c = lcm(a, b);
        while (l < r) {
            long mid = l + (r - l + 1 >> 1);
            long cnt = mid / a + mid / b - mid / c;

            // 找到cnt == n的最左边那个
            // 先找cnt < n的最大值
            if (cnt >= n) {
                r = mid - 1;
            } else if (cnt < n) {
                l = mid;
            }
        }

        return (int) ((l + 1) % mod);
    }

    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    private int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}
