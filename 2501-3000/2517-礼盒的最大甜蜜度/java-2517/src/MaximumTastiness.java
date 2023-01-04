import java.util.Arrays;

class MaximumTastiness {
    public int maximumTastiness(int[] price, int k) {
        int n = price.length;
        Arrays.sort(price);
        int min = price[0];
        int max = price[n - 1];
        int l = max;
        for (int i = 1; i < n; i++) {
            l = Math.min(l, price[i] - price[i - 1]);
        }
        int r = (max - min) / (k - 1);

        while (l < r) {
            int mid = l + (r - l + 1 >> 1);
            // 取mid作为甜蜜度，能否取到k个数，可以取到则mid是一个备选答案, 并且缩左区间尝试更大的甜蜜度
            if (check(price, mid, k)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
    private boolean check(int[] price, int lim, int k) {
        int cur = price[0];
        k--;
        for (int i = 1; i < price.length; i++) {
            if (price[i] - cur < lim) {
                continue;
            }
            cur = price[i];
            k--;
            if (k == 0) return true;
        }
        return k == 0;
    }
}
