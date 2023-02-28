import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

class MinCost2 {
    public long[] minCost(int n, int[][] roads, int[] appleCost, int k) {
        HashMap<Integer, Integer> [] graph = new HashMap[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new HashMap<>();
        }
        for (int i = 0; i < roads.length; i++) {
            int v1 = roads[i][0] - 1;
            int v2 = roads[i][1] - 1;
            int w = roads[i][2];
            graph[v1].put(v2, w * (k + 1));
            graph[v2].put(v1, w * (k + 1));
        }
        for (int i = 0; i < appleCost.length; i++) {
            int v1 = n;
            int v2 = i;
            int w = appleCost[i];
            graph[v1].put(v2, w);
            graph[v2].put(v1, w);
        }

        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n + 1];
        dis[n] = 0;
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{n, dis[n]});

        while (!pq.isEmpty()) {
            int[] minV = pq.poll();
            int v = minV[0];
            if (visited[v]) continue;

            visited[v] = true;
            for (int w : graph[v].keySet()) {
                if (!visited[w] && dis[v] + graph[v].get(w) < dis[w]) {
                    dis[w] = dis[v] + graph[v].get(w);
                    pq.offer(new int[]{w, dis[w]});
                }
            }
        }

        long[] res = new long[n];
        for (int v = 0; v < n; v++) {
            res[v] = dis[v];
        }
        return res;
    }
}