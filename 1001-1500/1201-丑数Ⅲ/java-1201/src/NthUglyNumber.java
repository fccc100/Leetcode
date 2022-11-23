class NthUglyNumber {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long l = Math.min(a, Math.min(b, c)) - 1;
        long r = Math.min(a, Math.min(b, c)) * n;

        long d = lcm(a, b);
        long e = lcm(a, c);
        long f = lcm(b, c);
        long g = lcm(d, c);
        while (l < r) {
            long mid = l + (r - l + 1 >> 1);
            long cnt = mid / a + mid / b + mid / c - mid / d - mid / e - mid / f + mid / g;

            if (cnt >= n) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return (int) l + 1;
    }

    private long lcm(long x, long y) {
        return x * y / gcd(x, y);
    }
    private long gcd(long x, long y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}