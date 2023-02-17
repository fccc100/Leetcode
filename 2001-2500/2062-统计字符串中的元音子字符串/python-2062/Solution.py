class Solution:
    def countVowelSubstrings(self, word: str) -> int:
        n, res = len(word), 0
        for i in range(n):
            c = word[i]
            if not self.isVowel(c):
                continue
            c_set = set()
            c_set.add(c)
            for j in range(i + 1, n):
                if not self.isVowel(word[j]):
                    break
                c_set.add(word[j])
                if len(c_set) >= 5:
                    res += 1
        return res

    def isVowel(self, c):
        return c in ('a', 'e', 'i', 'o', 'u')