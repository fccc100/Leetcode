class MinSwaps {
    public int minSwaps(int[] data) {
        int n = data.length;

        int oneCnt = 0;
        for (int i = 0; i < n ;i++) {
            if (data[i] == 1) {
                oneCnt++;
            }
        }

        int l = 0;
        int r = oneCnt - 1;
        int curOneCnt = 0;
        for (int i = 0; i <= r; i++) {
            if (data[i] == 1) {
                curOneCnt++;
            }
        }

        int maxOneCnt = curOneCnt;
        while (r + 1 < n) {
            r++;
            if (data[r] == 1) {
                curOneCnt++;
            }
            if (data[l] == 1) {
                curOneCnt--;
            }
            l++;

            maxOneCnt = Math.max(maxOneCnt, curOneCnt);
        }

        return oneCnt - maxOneCnt;
    }
}