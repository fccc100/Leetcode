class Solution:
    def maxIceCream(self, costs: List[int], coins: int) -> int:
        n, res = len(costs), 0
        costs.sort()
        for x in costs:
            if x > coins:
                return res
            coins -= x
            res += 1
        return res
