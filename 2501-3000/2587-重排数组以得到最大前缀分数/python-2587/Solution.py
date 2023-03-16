class Solution:
    def maxScore(self, nums: List[int]) -> int:
        n, res = len(nums), 0
        nums.sort()
        presum = nums[-1]
        if presum > 0: res += 1
        for i in range(n - 2, -1, -1):
            presum += nums[i]
            if presum > 0: res += 1
        return res
