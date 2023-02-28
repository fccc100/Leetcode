import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

class NetworkDelayTime2 {
    // Dijkstra 优先队列优化
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
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{k - 1, dis[k - 1]});

        while (!pq.isEmpty()) {
            int[] minDis = pq.poll();
            int v = minDis[0];
            if (visited[v]) continue;

            for (int w : graph[v].keySet()) {
                if (!visited[w] && dis[v] + graph[v].get(w) < dis[w]) {
                    dis[w] = dis[v] + graph[v].get(w);
                    pq.offer(new int[]{w, dis[w]});
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