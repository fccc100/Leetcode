import java.util.Arrays;
import java.util.HashMap;

class NetworkDelayTime {
    // Dijkstra
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
        boolean[] visited = new boolean[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[k - 1] = 0;

        while (true) {
            int minDis = Integer.MAX_VALUE, curV = -1;
            for (int v = 0; v < n; v++) {
                if (!visited[v] && dis[v] < minDis) {
                    minDis = dis[v];
                    curV = v;
                }
            }

            if (curV == -1) break;

            visited[curV] = true;
            for (int w : graph[curV].keySet()) {
                if (!visited[w] && dis[curV] + graph[curV].get(w) < dis[w]) {
                    dis[w] = dis[curV] + graph[curV].get(w);
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