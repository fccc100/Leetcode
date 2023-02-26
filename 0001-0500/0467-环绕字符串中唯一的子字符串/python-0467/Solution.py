class Solution:
    def findSubstringInWraproundString(self, s: str) -> int:
        n, dp, cur_len = len(s), [0] * 26, 1
        dp[ord(s[0]) - ord('a')] += 1
        for i in range(1, n):
            if ord(s[i]) - ord(s[i - 1]) == 1 or (s[i] == 'a' and s[i - 1] == 'z'):
                cur_len += 1
            else:
                cur_len = 1

            dp[ord(s[i]) - ord('a')] = max(dp[ord(s[i]) - ord('a')], cur_len)
        return sum(dp)
