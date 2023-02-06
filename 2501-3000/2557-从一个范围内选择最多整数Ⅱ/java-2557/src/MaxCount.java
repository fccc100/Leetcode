import java.util.HashSet;

class MaxCount {
    // TLE
    public int maxCount(int[] banned, int n, long maxSum) {
        int m = banned.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            set.add(banned[i]);
        }
        long sum = 0;
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (set.contains(i)) continue;
            sum += i;
            if (sum > maxSum) return res;
            res++;
        }
        return res;
    }
}