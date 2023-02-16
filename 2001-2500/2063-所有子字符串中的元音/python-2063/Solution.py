class Solution:
    def countVowels(self, word: str) -> int:
        n, res = len(word), 0
        for i in range(n):
            c = word[i]
            if self.isVowel(c):
                res += (i + 1) * (n - i)
        return res

    def isVowel(self, c):
        return c in ('a', 'e', 'i', 'o', 'u')