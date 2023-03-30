class Solution:
    def countVowelStrings(self, n: int) -> int:
        a, e, i, o, u = 1, 1, 1, 1, 1
        while n > 1:
            a = a + e + i + o + u
            e = e + i + o + u
            i = i + o + u
            o = o + u
            u = u
            n -= 1
        return a + e + i + o + u
