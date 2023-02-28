import java.util.Arrays;
import java.util.HashMap;

class NetworkDelayTime4 {
    // Floyed
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, Integer> [] graph = new HashMap[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new HashMap<>();
        }
        for (int i = 0; i < times.length; i++) {
            int v1 = times[i][0] - 1;
            int v2 = times[i][1] - 1;
            int w = times[i][2];
            graph[v1].put(v2, w);
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

        int res = -1;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dis[k - 1][i]);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}