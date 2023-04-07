import java.util.PriorityQueue;
import java.util.Queue;

class MaxProfit {
    public int maxProfit(int[] inventory, int orders) {
        int n = inventory.length;
        long MOD = 1000000007;

        int max = -1;
        for (int x : inventory) {
            max = Math.max(max, x);
        }

        // 二分查找出最后一个取出的球的价值
        int l = -1;
        int r = max + 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (check(inventory, orders, mid)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        long res = 0;
        for (int x : inventory) {
            if (x > l) {
                long cnt = x - l;
                long cur = (cnt * (long) (x + 1 + l)) / 2;
                res = (res + cur) % MOD;
                orders -= cnt;
            }
        }

        res += (long) l * (long) orders;

        return (int) (res % MOD);
    }
    private boolean check(int[] nums, int orders, int mid) {
        long sum = 0;
        for (int x : nums) {
            if (x > mid) {
                sum += x - mid;
                if (sum >= orders) return true;
            }
        }
        return false;
    }
}
//Sn = [n(A1 + An)] / 2

// 10 -> 10 9 8 7 6
// 6
// Sn = n(a1 + an) / 2