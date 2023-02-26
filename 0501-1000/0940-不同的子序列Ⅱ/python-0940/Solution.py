class Solution:
    def distinctSubseqII(self, s: str) -> int:
        n, pre_cnt, res, MOD = len(s), [0] * 26, 0, 1000000007
        for i in range(n):
            c = ord(s[i]) - ord('a')
            prev = pre_cnt[c]
            pre_cnt[c] = (res + 1) % MOD
            res = ((res + pre_cnt[c] - prev) % MOD + MOD) % MOD
        return res