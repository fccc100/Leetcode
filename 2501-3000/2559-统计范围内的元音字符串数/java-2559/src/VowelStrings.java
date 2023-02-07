import java.util.HashSet;

class VowelStrings {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] presum = new int[n + 1];
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        for (int i = 0; i < n; i++) {
            presum[i + 1] = presum[i];
            String s = words[i];
            int len = s.length();
            if (set.contains(s.charAt(0)) && set.contains(s.charAt(len - 1))) {
                presum[i + 1]++;
            }
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = presum[queries[i][1] + 1] - presum[queries[i][0]];
        }
        return res;
    }
}