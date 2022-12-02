import com.sun.tools.javac.util.List;

class MaxValueOfCoins {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();

        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            List<Integer> curStack = piles.get(i - 1);

            // 选j个
            for (int j = 1; j <= k; j++) {
                int sum = 0;

                // 第i个栈选择硬币的个数
                for (int x = 0; x <= curStack.size() && x <= j; x++) {
                    // 第i个选择x个，i - 1个栈选择j - x个，再加上当前前缀和sum
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - x] + sum);
                    if (x < curStack.size()) {
                        sum += curStack.get(x);
                    }
                }
            }
        }
        return dp[n][k];
    }
}
