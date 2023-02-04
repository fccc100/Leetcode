class Solution:
    def getMaximumConsecutive(self, coins: List[int]) -> int:
        coins.sort()
        res = 1
        for x in coins:
            if x > res:
                break
            res += x
        return res