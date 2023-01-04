import java.util.Arrays;

class MaxDistance {
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);
        int min = position[0];
        int max = position[n - 1];
        int l = 0;
        int r = (max - min) / (m - 1);

        while (l < r) {
            int mid = l + (r - l + 1 >> 1);
            if (check(position, mid, m)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
    private boolean check(int[] position, int dis, int m) {
        int n = position.length;
        int cur = position[0];
        m--;
        for (int i = 1; i < n; i++) {
            if (position[i] - cur < dis) {
                continue;
            }
            cur = position[i];
            m--;
            if (m == 0) return true;
        }
        return m == 0;
    }
}