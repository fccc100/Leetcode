class Solution:
    def totalSteps(self, nums: List[int]) -> int:
        n, res, stack = len(nums), 0, []
        for x in nums:
            max_t = 0
            while len(stack) > 0 and stack[-1][0] <= x:
                max_t = max(max_t, stack.pop()[1])
            max_t = 0 if len(stack) == 0 else max_t + 1
            res = max(res, max_t)
            stack.append([x, max_t])
        return res