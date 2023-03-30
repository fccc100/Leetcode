class Solution:
    def maxWidthOfVerticalArea(self, points: List[List[int]]) -> int:
        points.sort()
        res, cur = 0, points[0][0]
        for x, y in points:
            res = max(x - cur, res)
            cur = x
        return res
