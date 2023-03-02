import java.util.Arrays;
import java.util.HashMap;

class FindTheCity {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        HashMap<Integer, Integer>[] graph = new HashMap[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new HashMap<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            int w = edges[i][2];
            graph[v1].put(v2, graph[v1].getOrDefault(v2, 0) + w);
            graph[v2].put(v1, graph[v2].getOrDefault(v1, 0) + w);
        }

        int[][] dis = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
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
        int minDis = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int[] curDis = dis[i];
            int curCnt = 0;
            for (int j = 0; j < curDis.length; j++) {
                if (curDis[j] <= distanceThreshold) curCnt++;
            }

            if (curCnt <= minDis) {
                minDis = curCnt;
                res = i;
            }
        }
        return res;
    }
}