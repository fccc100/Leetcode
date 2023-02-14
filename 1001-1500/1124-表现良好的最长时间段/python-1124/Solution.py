class Solution:
    def longestWPI(self, hours: List[int]) -> int:
        n = len(hours)
        for i in range(n):
            if hours[i] > 8:
                hours[i] = 1
            else:
                hours[i] = -1
        presum = [0] * (n + 1)
        for i in range(1, n + 1):
            presum[i] = presum[i - 1] + hours[i - 1]
        stack, res = [], 0
        for i in range(n + 1):
            if len(stack) == 0 or presum[i] < presum[stack[-1]]:
                stack.append(i)
        for i in range(n, -1, -1):
            while len(stack) > 0 and presum[i] > presum[stack[-1]]:
                res = max(res, i - stack[-1])
                stack.pop()
        return res