import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

class MaxProbability {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        HashMap<Integer, Double> [] graph = new HashMap[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new HashMap<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            double w = succProb[i];
            graph[v1].put(v2, w);
            graph[v2].put(v1, w);
        }

        double[] dis = new double[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dis, Integer.MIN_VALUE);
        dis[start] = 1;

        Queue<double[]> pq = new PriorityQueue<>((a, b) -> {
            if (b[1] > a[1]) {
                return 1;
            } else if (b[1] < a[1]) {
                return -1;
            } else {
                return 0;
            }
        });
        pq.offer(new double[]{start, dis[start]});
        while (!pq.isEmpty()) {
            double[] maxEdge = pq.poll();
            int v = (int) maxEdge[0];

            if (visited[v]) continue;

            visited[v] = true;
            if (v == end) break;
            for (int w : graph[v].keySet()) {
                if (!visited[w] && dis[v] * graph[v].get(w) > dis[w]) {
                    dis[w] = dis[v] * graph[v].get(w);
                    pq.offer(new double[]{w, dis[w]});
                }
            }
        }
        return visited[end] ? dis[end] : 0;
    }
}