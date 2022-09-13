import java.util.HashMap;

class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        // 动态规划
        int n = s.length();
        if (n == 0) {
            return 0;
        }

        // dp[i]表示以i结尾的字符串的无重复字符最长子串
        int[] dp = new int[n + 1];
        dp[0] = 1;

        HashMap<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);

        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[i - 1] + 1, i - map.getOrDefault(s.charAt(i), -1));
            max = Math.max(max, dp[i]);

            map.put(s.charAt(i), i);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("abcabcbb"));
    }
}