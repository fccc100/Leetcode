class Solution:
    def getMinDistance(self, nums: List[int], target: int, start: int) -> int:
        n, res = len(nums), len(nums) + 1
        for i in range(n):
            if nums[i] == target:
                res = min(res, abs(i - start))
        return res