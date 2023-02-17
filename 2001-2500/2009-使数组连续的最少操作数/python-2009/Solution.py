class Solution:
    def minOperations(self, nums: List[int]) -> int:
        n = len(nums)
        nums.sort()
        presum = [0] * (n + 1)
        for i in range(1, n):
            presum[i + 1] = presum[i]
            if nums[i] == nums[i - 1]:
                presum[i + 1] += 1

        res = n + 1
        for i in range(n):
            up = self.upper(nums, nums[i] + n - 1)
            res = min(res, n - (up - i + 1) + presum[up + 1] - presum[i])
        return res

    def upper(self, nums, target):
        l, r = -1, len(nums) - 1
        while l < r:
            mid = l + (r - l + 1 >> 1)
            if nums[mid] > target:
                r = mid - 1
            else:
                l = mid
        return l