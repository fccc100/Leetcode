class Solution:
    def sumOfBeauties(self, nums: List[int]) -> int:
        n = len(nums)
        right_min = [0] * n
        right_min[n - 2] = nums[n - 1]
        for i in range(n - 3, -1, -1):
            right_min[i] = min(right_min[i + 1], nums[i + 1])

        left_max, res = nums[0], 0
        for i in range(1, n - 1):
            if left_max < nums[i] < right_min[i]:
                res += 2
            elif nums[i - 1] < nums[i] < nums[i + 1]:
                res += 1
            left_max = max(left_max, nums[i])
        return res