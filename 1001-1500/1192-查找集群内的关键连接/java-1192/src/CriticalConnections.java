import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class CriticalConnections {
    boolean[] visited;
    HashSet<Integer>[] graph;
    int[] ord;
    int[] low;
    int cnt;
    List<List<Integer>> res;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        graph = new HashSet[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new HashSet<>();
        }

        for (List<Integer> connect : connections) {
            int v1 = connect.get(0);
            int v2 = connect.get(1);
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        visited = new boolean[n];
        ord = new int[n];
        low = new int[n];
        cnt = 0;
        res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, i);
            }
        }
        return res;
    }
    private void dfs(int v, int parent) {
        visited[v] = true;
        ord[v] = cnt;
        low[v] = ord[v];
        cnt++;

        for (Integer w : graph[v]) {
            if (!visited[w]) {
                dfs(w, v);
                low[v] = Math.min(low[v], low[w]);

                if (low[w] > ord[v]) {
                    List<Integer> edge = new ArrayList<>();
                    edge.add(v);
                    edge.add(w);
                    res.add(edge);
                }
            } else if (w != parent) {
                low[v] = Math.min(low[v], low[w]);
            }
        }
    }
}