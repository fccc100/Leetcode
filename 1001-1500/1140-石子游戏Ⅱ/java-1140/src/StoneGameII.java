import java.util.Arrays;

class StoneGameII {
    private int[] sufixsum;
    private int[][] memo;
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        sufixsum = piles;
        memo = new int[n][2 * n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        for (int i = n - 2; i >= 0; i--) {
            sufixsum[i] += sufixsum[i + 1];
        }
        return dfs(0, 1);
    }
    private int dfs(int i, int m) {
        if (i + m * 2 >= sufixsum.length) return sufixsum[i];

        if (memo[i][m] != -1) {
            return memo[i][m];
        }

        int min = Integer.MAX_VALUE;
        for (int x = 1; x <= m * 2; x++) {
            min = Math.min(min, dfs(i + x, Math.max(m, x)));
        }
        return memo[i][m] = sufixsum[i] - min;
    }
}