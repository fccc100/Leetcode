import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class FieldOfGreatestBlessing {
    public int fieldOfGreatestBlessing(int[][] forceField) {
        int n = forceField.length;

        Set<Long> xSet = new HashSet<>();
        Set<Long> ySet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            long x = forceField[i][0];
            long y = forceField[i][1];
            long r = forceField[i][2];

            long x1 = x * 2 - r;
            long y1 = y * 2 - r;
            long x2 = x * 2 + r;
            long y2 = y * 2 + r;
            xSet.add(x1);
            xSet.add(x2);
            ySet.add(y1);
            ySet.add(y2);
        }

        Long[] xs = xSet.toArray(new Long[]{});
        Long[] ys = ySet.toArray(new Long[]{});
        Arrays.sort(xs);
        Arrays.sort(ys);
        int[][] diff = new int[2 * n + 2][n * 2 + 2];
        for (int i = 0; i < n; i++) {
            long x = forceField[i][0];
            long y = forceField[i][1];
            long r = forceField[i][2];

            long x1 = x * 2 - r;
            long y1 = y * 2 - r;
            long x2 = x * 2 + r;
            long y2 = y * 2 + r;

            diff[upper_floor(xs, x1) + 1][upper_floor(ys, y1) + 1] ++;
            diff[upper_floor(xs, x2) + 2][upper_floor(ys, y1) + 1] --;
            diff[upper_floor(xs, x1) + 1][upper_floor(ys, y2) + 2] --;
            diff[upper_floor(xs, x2) + 2][upper_floor(ys, y2) + 2] ++;
        }

        int res = 0;
        for (int i = 1; i < diff.length; i++) {
            for (int j = 1; j < diff[i].length; j++) {
                diff[i][j] += diff[i - 1][j] + diff[i][j - 1] - diff[i - 1][j - 1];
                res = Math.max(res, diff[i][j]);
            }
        }
        return res;
    }
    private int upper_floor(Long[] nums, long target) {
        int l = -1;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l + 1 >> 1);
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}