import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class LargestValsFromLabels {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = values[i];
            pairs[i][1] = labels[i];
        }

        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int v = pairs[i][0];
            int l = pairs[i][1];
            if (map.getOrDefault(l, 0) < useLimit) {
                cnt++;
                res += v;
                map.put(l, map.getOrDefault(l, 0) + 1);
            }
            if (cnt >= numWanted) break;
        }
        return res;
    }
}