class Solution:
    def vowelStrings(self, words: List[str], queries: List[List[int]]) -> List[int]:
        n, m = len(words), len(queries)
        presum = [0] * (n + 1)
        word_set = set(['a', 'e', 'i', 'o', 'u'])
        for i in range(n):
            presum[i + 1] = presum[i]
            s, l = words[i], len(words[i])
            if s[0] in word_set and s[l - 1] in word_set:
                presum[i + 1] += 1
        res = [0] * m
        for i in range(m):
            res[i] = presum[queries[i][1] + 1] - presum[queries[i][0]]
        return res