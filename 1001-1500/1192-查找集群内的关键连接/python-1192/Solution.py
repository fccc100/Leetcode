class Solution:
    visited, ord, low, cnt, res, graph = [], [], [], 0, [], []

    def criticalConnections(self, n: int, connections: List[List[int]]) -> List[List[int]]:
        self.graph = [0] * n
        for i in range(n):
            self.graph[i] = set()

        for v1, v2 in connections:
            self.graph[v1].add(v2)
            self.graph[v2].add(v1)

        self.visited = [False] * n
        self.ord = [0] * n
        self.low = [0] * n
        self.res = []

        for i in range(n):
            if not self.visited[i]:
                self.dfs(i, i)
        return self.res

    def dfs(self, v, parent):
        self.visited[v] = True
        self.ord[v] = self.cnt
        self.low[v] = self.cnt
        self.cnt += 1

        for w in self.graph[v]:
            if not self.visited[w]:
                self.dfs(w, v)
                self.low[v] = min(self.low[v], self.low[w])

                if self.low[w] > self.ord[v]:
                    self.res.append([v, w])
            elif w != parent:
                self.low[v] = min(self.low[v], self.low[w])

