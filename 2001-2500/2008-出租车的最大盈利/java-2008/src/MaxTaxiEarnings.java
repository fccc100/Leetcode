import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class MaxTaxiEarnings {
    public long maxTaxiEarnings(int n, int[][] rides) {
        long[] dp = new long[n + 1];
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < rides.length; i++) {
            if (!map.containsKey(rides[i][1])) {
                map.put(rides[i][1], new ArrayList<>());
            }
            map.get(rides[i][1]).add(new int[]{rides[i][0], rides[i][2]});
        }

        long res = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            if (map.containsKey(i)) {
                List<int[]> list = map.get(i);
                for (int[] p : list) {
                    dp[i] = Math.max(dp[i], dp[p[0]] + i - p[0] + p[1]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}