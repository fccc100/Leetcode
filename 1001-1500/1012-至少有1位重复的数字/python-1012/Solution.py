class Solution:
    def numDupDigitsAtMostN(self, n: int) -> int:
        s = str(n)

        @cache
        def f(index, mask, is_limit, is_num):
            if index == len(s):
                return int(is_num)

            res = 0
            if not is_num:
                res += f(index + 1, mask, False, False)

            up = int(s[index]) if is_limit else 9
            start = 1 - int(is_num)
            for d in range(start, up + 1):
                if (mask >> d & 1) == 0:
                    res += f(index + 1, mask | (1 << d), is_limit and d == up, True)
            return res

        return n - f(0, 0, True, False)