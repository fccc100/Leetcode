class Solution:
    def makePrefSumNonNegative(self, nums: List[int]) -> int:
        presum, res, pq = 0, 0, []
        for x in nums:
            if x < 0:
                heapq.heappush(pq, x)
            presum += x
            if presum < 0:
                presum -= heapq.heappop(pq)
                res += 1
        return res
