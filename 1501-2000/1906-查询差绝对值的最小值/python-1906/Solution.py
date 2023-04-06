class Solution:
    def minDifference(self, nums: List[int], queries: List[List[int]]) -> List[int]:
        n, m = len(nums), len(queries)
        pre_cnt = [[0] * 101 for _ in range(n + 1)]
        for i in range(1, n + 1):
            for j in range(1, 101):
                pre_cnt[i][j] = pre_cnt[i - 1][j]
            pre_cnt[i][nums[i - 1]] += 1

        res = [0] * m
        for i in range(m):
            l, r, prev, cur = queries[i][0], queries[i][1], -1, sys.maxsize
            for j in range(1, 101):
                if pre_cnt[r + 1][j] - pre_cnt[l][j] > 0:
                    if prev == -1:
                        prev = j
                    else:
                        cur = min(cur, abs(j - prev))
                        prev = j
            res[i] = -1 if cur == sys.maxsize else cur
        return res
