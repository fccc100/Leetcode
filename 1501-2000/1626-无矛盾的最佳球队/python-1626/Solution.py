class Solution:
    def bestTeamScore(self, scores: List[int], ages: List[int]) -> int:
        n = len(scores)
        pairs = sorted(zip(scores, ages))

        dp = [0] * n;
        res = 0
        for i in range(n):
            for j in range(i):
                if pairs[i][1] >= pairs[j][1]:
                    dp[i] = max(dp[i], dp[j])
            dp[i] += pairs[i][0]
            res = max(res, dp[i])
        return res
