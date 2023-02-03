class MonkeyMove {
    int MOD = 1000000007;
    public int monkeyMove(int n) {
        return (int)(quickPow(2, n) - 2 + MOD) % MOD;
    }
    private long quickPow(int x, int n) {
        if (n == 0) return 1;

        long y = quickPow(x, n / 2);
        y %= MOD;
        return n % 2 == 0 ? (y * y) % MOD : ((y * y) % MOD * x) % MOD;
    }
}