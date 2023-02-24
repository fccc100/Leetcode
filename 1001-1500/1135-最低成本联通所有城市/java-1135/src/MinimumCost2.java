import java.util.*;

class MinimumCost2 {
    public int minimumCost(int n, int[][] connections) {
        HashMap<Integer, Integer> [] graph = new HashMap[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new HashMap<>();
        }

        for (int i = 0; i < connections.length; i++) {
            int v1 = connections[i][0];
            int v2 = connections[i][1];
            int w = connections[i][2];
            graph[v1 - 1].put(v2 - 1, Math.min(graph[v1 - 1].getOrDefault(v2 - 1, Integer.MAX_VALUE), w));
            graph[v2 - 1].put(v1 - 1, Math.min(graph[v2 - 1].getOrDefault(v1 - 1, Integer.MAX_VALUE), w));
        }

        List<int[]> res = new ArrayList<>();
        boolean[] visited = new boolean[n];
        visited[0] = true;

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int w : graph[0].keySet()) {
            pq.offer(new int[]{0, w, graph[0].get(w)});
        }

        while (!pq.isEmpty()) {
            int[] minEdge = pq.poll();
            if (visited[minEdge[0]] && visited[minEdge[1]]) {
                continue;
            }

            res.add(minEdge);
            int newV = visited[minEdge[0]] ? minEdge[1] : minEdge[0];
            visited[newV] = true;
            for (int w : graph[newV].keySet()) {
                if (!visited[w]) {
                    pq.offer(new int[]{newV, w, graph[newV].get(w)});
                }
            }
        }

        for (boolean f : visited) {
            if (!f) return -1;
        }
        int ans = 0;
        for (int[] p : res) {
            ans += p[2];
        }
        return ans;
    }
}
