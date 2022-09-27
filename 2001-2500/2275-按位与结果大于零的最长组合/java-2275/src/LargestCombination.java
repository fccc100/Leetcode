class LargestCombination {
    public int largestCombination(int[] candidates) {
        int n = candidates.length;

        int[] cnt = new int[32];
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < 32; j++) {
                // 该位置为1
                if ((candidates[i] & (1 << j)) != 0) {
                    cnt[j]++;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < cnt.length; i++) {
            res = Math.max(res, cnt[i]);
        }
        return res;
    }
}