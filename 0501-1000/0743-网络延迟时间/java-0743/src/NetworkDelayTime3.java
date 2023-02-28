import java.util.Arrays;
import java.util.HashMap;

class NetworkDelayTime3 {
    // BellmanFord
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

        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[k - 1] = 0;

        // n - 1次松弛操作
        for (int i = 1; i < n; i++) {
            for (int v = 0; v < n; v++) {
                for (int w : graph[v].keySet()) {
                    if (dis[v] != Integer.MAX_VALUE && dis[v] + graph[v].get(w) < dis[w]) {
                        dis[w] = dis[v] + graph[v].get(w);
                    }
                }
            }
        }

        int res = -1;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dis[i]);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}