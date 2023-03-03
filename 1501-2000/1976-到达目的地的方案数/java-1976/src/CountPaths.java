import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

class CountPaths {
    public int countPaths(int n, int[][] roads) {
        int MOD = 1000000007;
        HashMap<Integer, Integer> [] graph = new HashMap[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new HashMap<>();
        }
        for (int i = 0; i < roads.length; i++) {
            int v1 = roads[i][0];
            int v2 = roads[i][1];
            int w = roads[i][2];
            graph[v1].put(v2, w);
            graph[v2].put(v1, w);
        }

        int[] dis = new int[n];
        boolean[] visited = new boolean[n];
        int[] cnt = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;
        cnt[0] = 1;
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, dis[0]});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int v = cur[0];
            if (visited[v]) continue;

            visited[v] = true;
            for (int w : graph[v].keySet()) {
                if (!visited[w]) {
                    if (dis[v] + graph[v].get(w) < dis[w]) {
                        dis[w] = dis[v] + graph[v].get(w);
                        cnt[w] = cnt[v];
                        pq.offer(new int[]{w, dis[w]});
                    } else if (dis[v] + graph[v].get(w) == dis[w]) {
                        cnt[w] = (cnt[v] + cnt[w]) % MOD;
                    }
                }
            }
        }
        return cnt[n - 1];
    }
}