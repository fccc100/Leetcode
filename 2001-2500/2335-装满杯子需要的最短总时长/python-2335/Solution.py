class Solution:
    def fillCups(self, amount: List[int]) -> int:
        res = 0
        amount.sort()
        while amount[2] > 0:
            amount[1] -= 1
            amount[2] -= 1
            res += 1
            amount.sort()
        return res
