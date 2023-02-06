class Solution:
    def maximizeWin(self, prizePositions: List[int], k: int) -> int:
        n, l, res = len(prizePositions), 0, 0
        pre = [0] * (n + 1)
        for r in range(n):
            while prizePositions[r] - prizePositions[l] > k:
                l += 1
            res = max(res, r - l + 1 + pre[l])
            pre[r + 1] = max(pre[r], r - l + 1)
        return res