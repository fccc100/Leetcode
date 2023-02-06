// TLE
class Solution:
    def check(self, banned, n, mid):
        m, sum, prev = len(banned), 0, 0
        for i in range(m + 1):
            if i < m:
                cur = banned[i]
            else:
                cur = n + 1
            if cur == prev:
                continue
            ran = min(cur - prev - 1, mid)
            start, end = prev + 1, prev + ran
            sum += (start + end) * (end - start + 1) / 2
            mid -= ran
            prev = cur
        return sum

    def maxCount(self, banned: List[int], n: int, maxSum: int) -> int:
        m, banned_set = len(banned), set()
        banned.sort()
        for x in banned:
            banned_set.add(x)
        banned_cnt = 0
        for x in banned_set:
            if x <= n:
                banned_cnt += 1

        l, r = 0, n - banned_cnt
        while l < r:
            mid = l + (r - l + 1 // 2)
            if self.check(banned, n, mid) <= maxSum:
                l = mid
            else:
                r = mid - 1
        return l