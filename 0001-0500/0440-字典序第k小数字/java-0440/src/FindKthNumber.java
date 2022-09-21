class FindKthNumber {
    public int findKthNumber(int n, int k) {
        // 前缀
        int pre = 1;

        int cnt = 1;
        while (cnt < k) {
            int curCnt = getCount(pre, n);
            // 以当前前缀的个数超过k了，往下一层寻找
            if (cnt + curCnt > k) {
                pre *= 10;
                cnt++;
            } else {
                cnt += curCnt;
                pre++;
            }
        }
        return pre;
    }

    // 求前缀为p的n以内的数字个数
    private int getCount(int p, int n) {
        long cur = p;
        long next = p + 1;

        int cnt = 0;
        while (cur <= n) {
            cnt += Math.min(next, n + 1) - cur;

            cur *= 10;
            next *= 10;
        }
        return cnt;
    }
}