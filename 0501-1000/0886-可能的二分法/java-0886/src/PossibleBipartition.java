import java.util.Arrays;
import java.util.HashSet;

class PossibleBipartition {

    HashSet<Integer>[] graph;
    boolean[] visited;
    int[] colors;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        graph = new HashSet[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new HashSet<>();
        }
        for (int i = 0; i < dislikes.length; i++) {
            graph[dislikes[i][0]].add(dislikes[i][1]);
            graph[dislikes[i][1]].add(dislikes[i][0]);
        }

        visited = new boolean[n + 1];
        colors = new int[n + 1];
        Arrays.fill(colors, -1);

        for (int i = 0; i <= n; i++) {
            if (!visited[i]) {
                if (!dfs(i, 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int v, int color) {
        visited[v] = true;
        colors[v] = color;

        for (int i: graph[v]) {
            if (!visited[i]) {
                if (!dfs(i, 1 - color)) {
                    return false;
                }
            } else if (colors[v] == colors[i]) {
                return false;
            }
        }
        return true;
    }
}