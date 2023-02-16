import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class MaximalPathQuality {
    int res;
    int[] values;
    int maxTime;
    List<List<int[]>> graph;
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        int n = values.length;
        res = 0;
        this.values = values;
        this.maxTime = maxTime;
        graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(new int[]{edges[i][1], edges[i][2]});
            graph.get(edges[i][1]).add(new int[]{edges[i][0], edges[i][2]});
        }

        dfs(0, 0, 0, new boolean[n]);
        return res;
    }

    private void dfs(int v, int val, int time, boolean[] visited) {
        if (time > maxTime) return;

        if (!visited[v]) {
            val += values[v];
        }

        visited[v] = true;
        if (v == 0) {
            res = Math.max(res, val);
        }

        List<int[]> next = graph.get(v);
        for (int[] nextP: next) {
            int nextV = nextP[0];
            int curTime = nextP[1];

            dfs(nextV, val, time + curTime, Arrays.copyOfRange(visited, 0, visited.length));
        }
    }
}