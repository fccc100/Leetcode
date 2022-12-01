import java.util.HashSet;

class CountPalindromicSubsequence {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();

        int[] sufCnt = new int[26];
        for (int i = n - 1; i >= 0; i--) {
            int cur = s.charAt(i) - 'a';
            sufCnt[cur]++;
        }

        HashSet<String> set = new HashSet<>();
        int[] preCnt = new int[26];
        for (int i = 0; i < n; i++) {
            int cur = s.charAt(i) - 'a';

            sufCnt[cur]--;

            for (int j = 0; j < 26; j++) {

                if (preCnt[j] > 0 && sufCnt[j] > 0) {
                    set.add(j + "-" + cur + "-" + j);
                }
            }

            preCnt[cur]++;
        }
        return set.size();
    }
}