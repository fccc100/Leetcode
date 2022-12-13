import java.util.Arrays;

class NumWays {
    long[][] memo;
    int MOD = 1000000007;
    public int numWays(int steps, int arrLen) {
        memo = new long[steps + 1][500];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return (int)tryMove(steps, arrLen, 0);
    }
    private long tryMove(int steps, int arrLen, int curIdx) {
        if (curIdx > steps) {
            return 0;
        }
        if (curIdx == steps) return 1;

        if (memo[steps][curIdx] > -1) {
            return memo[steps][curIdx];
        }

        long res = 0;
        if (curIdx - 1 >= 0) {
            res += tryMove(steps - 1, arrLen, curIdx - 1);
        }
        if (curIdx + 1 < arrLen) {
            res += tryMove(steps - 1, arrLen, curIdx + 1);
        }
        res += tryMove(steps - 1, arrLen, curIdx);
        return memo[steps][curIdx] = res % MOD;
    }
}