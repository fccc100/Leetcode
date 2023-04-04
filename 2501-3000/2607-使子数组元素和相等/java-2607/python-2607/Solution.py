class Solution:
    def makeSubKSumEqual(self, arr: List[int], k: int) -> int:
        n, res = len(arr), 0
        visited = [False] * n
        for i in range(k):
            if not visited[i]:
                cur, t = [], i
                while not visited[t]:
                    visited[t] = True
                    cur.append(arr[t])
                    t = (t + k) % n
                cur.sort()
                for x in cur:
                    res += abs(x - cur[len(cur) // 2])
        return res
