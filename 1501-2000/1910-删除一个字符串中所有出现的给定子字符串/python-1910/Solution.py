class Solution:
    def removeOccurrences(self, s: str, part: str) -> str:
        while s.find(part) > -1:
            idx = s.find(part)
            s = s[0:idx] + s[idx + len(part):]
        return s