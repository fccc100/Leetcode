public class MonkeyMove3 {
    public int monkeyMove(int n) {
        int MOD = 1000000007;
        long x = 2;
        long res = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                res = (res * x) % MOD;
            }
            x = (x * x) % MOD;
            n >>= 1;
        }
        return (int) (res - 2 + MOD) % MOD;
    }
}
