public class MyPow3 {
    // 快速幂迭代写法
    public double myPow(double x, int n) {
        long m = n;
        return n >= 0 ? quickPow(x, m) : 1.0 / quickPow(x, -m);
    }

    private double quickPow(double x, long n) {
        double res = 1.0;
        double y = x;

        while (n > 0) {
            if ((n & 1) != 0) {
                res *= y;
            }
            y *= y;

            n >>= 1;
        }
        return res;
    }
}
