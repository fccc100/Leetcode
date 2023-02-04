# TLE
class Solution:
    def __init__(self):
        self.res = 0

    def maxProduct(self, s: str) -> int:
        s1, s2 = '', ''
        self.dfs(s, s1, s2, 0)
        return self.res

    def dfs(self, s, s1, s2, index):
        if self.check(s1) and self.check(s2):
            self.res = max(self.res, len(s1) * len(s2))
        if index == len(s):
            return
        self.dfs(s, s1 + s[index], s2, index + 1)
        self.dfs(s, s1, s2 + s[index], index + 1)
        self.dfs(s, s1, s2, index + 1)

    def check(self, s):
        l, r = 0, len(s) - 1
        while l < r:
            if s[l] != s[r]:
                return False
            l += 1
            r -= 1
        return True