class Solution:
    def reversePrefix(self, word: str, ch: str) -> str:
        idx, n = -1, len(word)
        for i in range(n):
            if word[i] == ch:
                idx = i
                break
        if idx == -1:
            return word
        res = ""
        for i in range(idx, -1, -1):
            res = res + word[i]
        for i in range(idx + 1, n):
            res = res + word[i]
        return res