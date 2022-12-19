import java.util.HashSet;

class ValidPath2 {
    boolean[] visited;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;
        HashSet<Integer>[] graph = new HashSet[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new HashSet<>();
        }
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        visited = new boolean[n];
        return dfs(graph, source, destination);
    }
    private boolean dfs(HashSet<Integer>[] graph, int v, int dest) {
        visited[v] = true;
        if (v == dest) return true;
        for (Integer v1 : graph[v]) {
            if (!visited[v1] && dfs(graph, v1, dest)) {
                return true;
            }
        }
        return false;
    }
}