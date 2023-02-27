import java.util.Arrays;

class MaxScoreWords {
    int[] map;
    int res = 0;
    int[] score;
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        map = new int[26];
        this.score = score;
        for (int i = 0; i < letters.length; i++) {
            map[letters[i] - 'a']++;
        }

        dfs(words, map, 0, 0);
        return res;
    }
    private void dfs(String[] words, int[] letterCnt, int index, int curScore) {
        if (index == words.length) {
            res = Math.max(res, curScore);
            return;
        }

        String s = words[index];
        boolean canSel = true;
        int wordScore = 0;
        int[] curLetterCnt = Arrays.copyOfRange(letterCnt, 0, letterCnt.length);
        for (int i = 0; i < s.length(); i++) {
            if (letterCnt[s.charAt(i) - 'a'] == 0) {
                canSel = false;
                break;
            }
            letterCnt[s.charAt(i) - 'a']--;
            wordScore += score[s.charAt(i) - 'a'];
        }

        if (!canSel) {
            dfs(words, curLetterCnt, index + 1, curScore);
        } else {
            dfs(words, curLetterCnt, index + 1, curScore);

            dfs(words, letterCnt, index + 1, curScore + wordScore);
        }
    }
}