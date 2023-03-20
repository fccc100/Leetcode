class Solution:
    def maximumProfit(self, present: List[int], future: List[int], budget: int) -> int:
        n = len(present)
        vals = [0] * n
        for i in range(n):
            vals[i] = future[i] - present[i]
        dp = [[0] * (budget + 1) for _ in range(n + 1)]
        for i in range(1, n + 1):
            w, v = present[i - 1], vals[i - 1]
            for j in range(budget + 1):
                dp[i][j] = max(dp[i][j], dp[i - 1][j])
                if w <= j:
                    dp[i][j] = max(dp[i][j], dp[i - 1][j - w] + v)
        return dp[n][budget]
    