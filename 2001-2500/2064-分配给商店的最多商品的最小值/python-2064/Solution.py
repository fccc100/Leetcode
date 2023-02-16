class Solution:
    def minimizedMaximum(self, n: int, quantities: List[int]) -> int:
        m, max_v = len(quantities), max(quantities)
        l, r = 1, max_v
        while l < r:
            mid = l + (r - l >> 1)
            if self.check(quantities, n, mid):
                r = mid
            else:
                l = mid + 1
        return l

    def check(self, nums, n, mid):
        cnt = 0
        for x in nums:
            if x % mid == 0:
                cnt += x // mid
            else:
                cnt += x // mid + 1
        return cnt <= n