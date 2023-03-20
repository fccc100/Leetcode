class Solution:
    def maximumProfit(self, present: List[int], future: List[int], budget: int) -> int:
        n = len(present)
        vals = [0] * n
        for i in range(n):
            vals[i] = future[i] - present[i]
        dp = [0] * (budget + 1)
        for i in range(1, n + 1):
            w, v = present[i - 1], vals[i - 1]
            for j in range(budget, w - 1, -1):
                dp[j] = max(dp[j], dp[j - w] + v)
        return dp[budget]
