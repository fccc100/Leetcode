public class MyPow2 {
    // 快速幂递归写法
    public double myPow(double x, int n) {
        return n >= 0 ? quickPow(x, n) : 1.0 / quickPow(x, -n);
    }

    private double quickPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        double y = quickPow(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }
}
