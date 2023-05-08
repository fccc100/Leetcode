class Solution:
    def numPairsDivisibleBy60(self, time: List[int]) -> int:
        res, cnts = 0, [0] * 61
        for x in time:
            m = x % 60
            if m == 0:
                res += cnts[0]
                cnts[0] += 1
            else:
                res += cnts[60 - m]
                cnts[m] += 1
        return res