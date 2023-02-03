class Solution:
    def interchangeableRectangles(self, rectangles: List[List[int]]) -> int:
        n, map, res = len(rectangles), {}, 0
        for i in range(n):
            c = rectangles[i][0] / rectangles[i][1]
            if c in map:
                res += map.get(c)
                map[c] = map.get(c) + 1
            else:
                map[c] = 1
        return res