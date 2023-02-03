class Solution:
    def maximumEvenSplit(self, finalSum: int) -> List[int]:
        if finalSum % 2 != 0:
            return []
        cur, res = 2, []
        while finalSum >= cur:
            res.append(cur)
            finalSum -= cur
            cur += 2
        if finalSum == 0:
            return res
        res[-1] = res[-1] + finalSum
        return res