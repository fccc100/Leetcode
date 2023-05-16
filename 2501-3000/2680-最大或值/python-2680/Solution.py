class Solution:
    def maximumOr(self, nums: List[int], k: int) -> int:
        n = len(nums)
        suffix = [0] * (n + 1)
        for i in range(n - 1, -1, -1):
            suffix[i] = suffix[i + 1] | nums[i]

        pre, res = 0, 0
        for i in range(n):
            res = max(res, pre | (nums[i] << k) | suffix[i + 1])
            pre = pre | nums[i]
        return res