class Solution:
    def minimumBuckets(self, hamsters: str) -> int:
        n, res, last = len(hamsters), 0, -1
        for i in range(n):
            c = hamsters[i]
            if c == 'H':
                if i == 0:
                    if i + 1 >= n:
                        return -1
                    if hamsters[i + 1] == 'H':
                        return -1
                    else:
                        res += 1
                        last = 2
                if i == n - 1:
                    if i - 1 >= 0:
                        if hamsters[n - 2] == 'H':
                            return -1
                        else:
                            if last < i:
                                res += 1
                                last = i
                    if last < i:
                        return -1

                if i <= last:
                    continue
                if i + 1 < n and hamsters[i + 1] == '.':
                    res += 1
                    last = i + 2
                elif hamsters[i - 1] == '.':
                    res += 1
                    last = i
                else:
                    return -1
        return res
