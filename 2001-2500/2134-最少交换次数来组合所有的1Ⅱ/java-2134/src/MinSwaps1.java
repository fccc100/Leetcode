class MinSwaps1 {
    public int minSwaps(int[] nums) {
        int n = nums.length;

        int oneCnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                oneCnt++;
            }
        }

        int l = 0;
        int r = oneCnt - 1;
        int curOneCnt = 0;
        for (int i = 0; i <= r; i++) {
            if (nums[i] == 1) {
                curOneCnt++;
            }
        }

        int maxOneCnt = curOneCnt;
        while (l < n) {
            r = (r + 1) % n;
            if (nums[r] == 1) {
                curOneCnt++;
            }
            if (nums[l] == 1) {
                curOneCnt--;
            }
            l++;
            maxOneCnt = Math.max(maxOneCnt, curOneCnt);
        }
        return oneCnt - maxOneCnt;
    }
}