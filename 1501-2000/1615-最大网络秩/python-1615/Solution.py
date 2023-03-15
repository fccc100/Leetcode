class Solution:
    def maximalNetworkRank(self, n: int, roads: List[List[int]]) -> int:
        graph = [set() for _ in range(n)]
        for r in roads:
            graph[r[0]].add(r[1])
            graph[r[1]].add(r[0])
        res = 0
        for i in range(n):
            for j in range(i + 1, n):
                cur = len(graph[i]) + len(graph[j])
                if j in graph[i]:
                    cur -= 1
                res = max(res, cur)
        return res