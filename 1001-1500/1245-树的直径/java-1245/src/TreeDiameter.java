import java.util.HashSet;

class TreeDiameter {
    HashSet<Integer>[] graph;
    int res;
    public int treeDiameter(int[][] edges) {
        int n = edges.length + 1;
        graph = new HashSet[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new HashSet<>();
        }

        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }

        dfs(0, 0);
        return res;
    }
    private int dfs(int v, int parent) {
        int maxLen = 0;
        for (int w : graph[v]) {
            if (w != parent) {
                int curLen = dfs(w, v);
                res = Math.max(res, maxLen + curLen);
                maxLen = Math.max(maxLen, curLen);
            }
        }
        return maxLen + 1;
    }
}