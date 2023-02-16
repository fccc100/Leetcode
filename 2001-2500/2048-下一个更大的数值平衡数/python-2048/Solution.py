class Solution:
    def nextBeautifulNumber(self, n: int) -> int:
        i = n + 1
        while True:
            if self.check(i):
                return i
            i += 1

    def check(self, n):
        map = [0] * 10
        while n > 0:
            k = n % 10
            map[k] += 1
            n //= 10
        for i in range(10):
            if 0 < map[i] != i:
                return False
        return True