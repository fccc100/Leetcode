class Solution:
    def separateDigits(self, nums: List[int]) -> List[int]:
        n, res = len(nums), []
        for x in nums:
            cur = []
            while x > 0:
                cur.insert(0, x % 10)
                x //= 10
            for y in cur:
                res.append(y)
        return res