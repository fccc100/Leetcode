class Solution:
    def movesToMakeZigzag(self, nums: List[int]) -> int:
        n, temp, res1 = len(nums), nums.copy(), 0
        for i in range(0, n, 2):
            if i + 1 < n and temp[i + 1] >= temp[i]:
                res1 += temp[i + 1] - temp[i] + 1
                temp[i + 1] = temp[i] - 1
            if i - 1 >= 0 and temp[i - 1] >= temp[i]:
                res1 += temp[i - 1] - temp[i] + 1
                temp[i - 1] = temp[i] - 1

        res2 = 0
        for i in range(1, n, 2):
            if i + 1 < n and nums[i + 1] >= nums[i]:
                res2 += nums[i + 1] - nums[i] + 1
                nums[i + 1] = nums[i] - 1
            if i - 1 >= 0 and nums[i - 1] >= nums[i]:
                res2 += nums[i - 1] - nums[i] + 1
                nums[i - 1] = nums[i] - 1
        return min(res1, res2)
