class Solution:
    def vowelStrings(self, words: List[str], left: int, right: int) -> int:
        s, res = "aeiou", 0
        for i in range(left, right + 1):
            w = words[i]
            if w[0] in s and w[-1] in s:
                res += 1
        return res
