class Solution:
    map, res, score = [0] * 26, 0, []

    def maxScoreWords(self, words: List[str], letters: List[str], score: List[int]) -> int:
        self.map = [0] * 26
        self.res = 0
        self.score = score
        for c in letters:
            self.map[ord(c) - ord('a')] += 1

        self.dfs(words, self.map, 0, 0)
        return self.res

    def dfs(self, words, letter_cnt, index, cur_score):
        if index == len(words):
            self.res = max(self.res, cur_score)
            return

        s, can_sel, word_score, cur_letter_cnt = words[index], True, 0, letter_cnt.copy()
        for c in s:
            if letter_cnt[ord(c) - ord('a')] == 0:
                can_sel = False
                break
            letter_cnt[ord(c) - ord('a')] -= 1
            word_score += self.score[ord(c) - ord('a')]

        if not can_sel:
            self.dfs(words, cur_letter_cnt, index + 1, cur_score)
        else:
            self.dfs(words, cur_letter_cnt, index + 1, cur_score)
            self.dfs(words, letter_cnt, index + 1, cur_score + word_score)