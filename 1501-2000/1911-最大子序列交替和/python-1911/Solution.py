class Solution:
    def maxAlternatingSum(self, nums: List[int]) -> int:
        n = len(nums)
        dpOdd = [0] * n
        dpEven = [0] * n
        dpEven[0] = nums[0]
        res = max(dpOdd[0], dpEven[0])
        for i in range(n):
            dpOdd[i] = max(dpEven[i - 1] - nums[i], dpOdd[i - 1])
            dpEven[i] = max(dpOdd[i - 1] + nums[i], dpEven[i - 1])
            res = max(res, dpOdd[i])
            res = max(res, dpEven[i])
        return res