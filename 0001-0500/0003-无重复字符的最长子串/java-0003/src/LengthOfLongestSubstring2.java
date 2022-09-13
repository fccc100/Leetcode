public class LengthOfLongestSubstring2 {
    // 滑动窗口
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int[] map = new int[256];

        int l = 0;
        int r = -1;

        int res = 1;
        while (l < n && r < n) {
            if (r + 1 < n && map[s.charAt(r + 1)] == 0) {
                r++;
                map[s.charAt(r)]++;
            } else {
                map[s.charAt(l)]--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
