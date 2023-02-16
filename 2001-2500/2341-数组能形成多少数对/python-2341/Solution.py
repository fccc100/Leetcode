class Solution:
    def numberOfPairs(self, nums: List[int]) -> List[int]:
        n, nums_set, res = len(nums), set(), [0] * 2
        for x in nums:
            if x in nums_set:
                res[0] += 1
                nums_set.remove(x)
            else:
                nums_set.add(x)
        res[1] = n - 2 * res[0]
        return res