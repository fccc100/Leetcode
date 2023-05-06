class MinNumberOfFrogs {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int n = croakOfFrogs.length();
        int[] cnt = new int[5];
        for (int i = 0; i < n; i++) {
            char ch = croakOfFrogs.charAt(i);
            if (ch == 'c') {
                cnt[0]++;
            } else if (ch == 'r') {
                cnt[1]++;
            } else if (ch == 'o') {
                cnt[2]++;
            } else if (ch == 'a') {
                cnt[3]++;
            } else if (ch == 'k') {
                cnt[4]++;
            }
            if (invalid(cnt)) return -1;
        }
        if (!(cnt[0] == cnt[1] && cnt[1] == cnt[2] && cnt[2] == cnt[3] && cnt[3] == cnt[4])) {
            return -1;
        }

        int cur = 0, res = -1;
        for (int i = 0; i < n; i++) {
            char ch = croakOfFrogs.charAt(i);
            if (ch == 'c') {
                cur++;
            }
            if (ch == 'k') {
                cur--;
            }
            res = Math.max(res, cur);
        }
        return res;
    }
    private boolean invalid(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) return true;
        }
        return false;
    }
}
