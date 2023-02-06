import java.util.Arrays;
import java.util.HashSet;

public class MaxCount2 {
    public int maxCount(int[] banned, int n, long maxSum) {
        int m = banned.length;
        Arrays.sort(banned);
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            set.add(banned[i]);
        }
        int bannedCnt = 0;
        for (int x : set) {
            if (x <= n) bannedCnt++;
        }

        int l = 0, r = n - bannedCnt;
        while (l < r) {
            int mid = l + (r - l + 1 >> 1);
            if (check(banned, n, mid) <= maxSum) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    // banned中选mid个数最少能取到多少sum
    private long check(int[] banned, int n, int mid) {
        long sum = 0;
        int m = banned.length;
        int prev = 0;
        // 遍历禁用的上界
        for (int i = 0; i <= m; i++) {
            int cur = i < m ? banned[i] : n + 1;
            if (cur == prev) continue;
            // 当前数与前一个数中间数的个数
            int range = Math.min(cur - prev - 1, mid);
            int start = prev + 1;
            int end = prev + range;
            sum += (long) (start + end) * (end - start + 1) / 2;
            mid -= range;
            prev = cur;
        }
        return sum;
    }
}
