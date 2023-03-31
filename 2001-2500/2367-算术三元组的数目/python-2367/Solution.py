class Solution:
    def arithmeticTriplets(self, nums: List[int], diff: int) -> int:
        num_set, res = set(nums), 0
        for x in nums:
            if x + diff in num_set and x - diff in num_set:
                res += 1
        return res