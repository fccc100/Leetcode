import java.util.HashSet;

class MaximalNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {
        HashSet<Integer> [] graph = new HashSet[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new HashSet<Integer>();
        }
        for (int i = 0; i < roads.length; i++) {
            graph[roads[i][0]].add(roads[i][1]);
            graph[roads[i][1]].add(roads[i][0]);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int cur = graph[i].size() + graph[j].size();
                if (graph[i].contains(j)) cur --;
                res = Math.max(res, cur);
            }
        }
        return res;
    }
}