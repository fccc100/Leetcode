class Solution:
    def countFairPairs(self, nums: List[int], lower: int, upper: int) -> int:
        n, res = len(nums), 0
        nums.sort()
        for i in range(n):
            if nums[i] * 2 > upper:
                break
            min_val, max_val = lower - nums[i] - 1, upper - nums[i] + 1
            lower_idx, upper_idx = self.lower(nums, min_val), self.upper(nums, max_val)
            res += upper_idx - max(lower_idx, i + 1) + 1
        return res

    def lower(self, nums, target):
        l, r = 0, len(nums)
        while l < r:
            mid = l + (r - l >> 1)
            if nums[mid] <= target:
                l = mid + 1
            else:
                r = mid
        return l

    def upper(self, nums, target):
        l, r = -1, len(nums) - 1
        while l < r:
            mid = l + (r - l + 1 >> 1)
            if nums[mid] >= target:
                r = mid - 1
            else:
                l = mid
        return l
