import java.util.Arrays;
import java.util.HashMap;
// TLE
class MinCost {
    public long[] minCost(int n, int[][] roads, int[] appleCost, int k) {
        HashMap<Integer, Integer> [] graph = new HashMap[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new HashMap<>();
        }
        for (int i = 0; i < roads.length; i++) {
            int v1 = roads[i][0] - 1;
            int v2 = roads[i][1] - 1;
            int w = roads[i][2];
            graph[v1].put(v2, w);
            graph[v2].put(v1, w);
        }

        int[][] dis = new int[n][n];
        for (int v = 0; v < n; v++) {
            Arrays.fill(dis[v], Integer.MAX_VALUE);
        }
        for (int v = 0; v < n; v++) {
            dis[v][v] = 0;
            for (int w : graph[v].keySet()) {
                dis[v][w] = graph[v].get(w);
            }
        }

        for (int t = 0; t < n; t++) {
            for (int v = 0; v < n; v++) {
                for (int w = 0; w < n; w++) {
                    if (dis[v][t] != Integer.MAX_VALUE && dis[t][w] != Integer.MAX_VALUE && dis[v][t] + dis[t][w] < dis[v][w]) {
                        dis[v][w] = dis[v][t] + dis[t][w];
                    }
                }
            }
        }

        long[] res = new long[n];
        for (int v = 0; v < n; v++) {
            int minCost = Integer.MAX_VALUE;
            for (int w = 0; w < n; w++) {
                int d = dis[v][w];
                if (d == Integer.MAX_VALUE) continue;
                int ac = appleCost[w];
                int cur = d + ac + d * k;
                minCost = Math.min(minCost, cur);
            }
            res[v] = minCost;
        }
        return res;
    }
}