class Solution:
    def pickGifts(self, gifts: List[int], k: int) -> int:
        n, pq = len(gifts), []
        for x in gifts:
            heapq.heappush(pq, -x)

        while k > 0:
            top = (-1) * heapq.heappop(pq)
            heapq.heappush(pq, -math.floor(top ** 0.5))
            k -= 1
        res = 0
        while len(pq) > 0:
            res += (-1) * heapq.heappop(pq)
        return res
