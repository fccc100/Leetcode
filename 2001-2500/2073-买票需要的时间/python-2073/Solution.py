class Solution:
    def timeRequiredToBuy(self, tickets: List[int], k: int) -> int:
        n, res = len(tickets), 0
        while True:
            for i in range(n):
                if tickets[i] > 0:
                    res += 1
                    tickets[i] -= 1
                if i == k and tickets[i] == 0:
                    return res
