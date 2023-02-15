class Solution:
    def isGoodArray(self, nums: List[int]) -> bool:
        return gcd(*nums) == 1