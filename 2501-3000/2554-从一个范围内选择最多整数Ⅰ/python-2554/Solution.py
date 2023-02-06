class Solution:
    def maxCount(self, banned: List[int], n: int, maxSum: int) -> int:
        m, banned_set, banned_sum, res = len(banned), set(banned), 0, 0
        for i in range(1, n + 1):
            if i in banned_set:
                continue
            banned_sum += i
            if banned_sum > maxSum:
                return res
            res += 1
        return res