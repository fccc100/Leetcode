class Solution:
    def substringXorQueries(self, s: str, queries: List[List[int]]) -> List[List[int]]:
        m, n, res = len(s), len(queries), []
        for p in queries:
            x, y = p[0], p[1]
            t = str(bin(x ^ y))[2:]
            idx = s.find(t)
            if idx == -1:
                res.append([-1, -1])
            else:
                res.append([idx, idx + len(t) - 1])
        return res
