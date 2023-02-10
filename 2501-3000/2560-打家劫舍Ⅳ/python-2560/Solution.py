class Solution:
    def minCapability(self, nums: List[int], k: int) -> int:
        n, l, r = len(nums), min(nums), max(nums)
        while l < r:
            mid = l + (r - l >> 1)
            if self.check(nums, mid, k):
                r = mid
            else:
                l = mid + 1
        return l

    def check(self, nums, mid, k):
        n, cnt, prev = len(nums), 0, -2
        for i in range(0, n):
            if nums[i] <= mid:
                if i - prev > 1:
                    cnt += 1
                    prev = i
        return cnt >= k