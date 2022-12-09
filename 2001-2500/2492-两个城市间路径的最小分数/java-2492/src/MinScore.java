import java.util.HashMap;
import java.util.HashSet;

class MinScore {
    public int minScore(int n, int[][] roads) {
        int m = roads.length;

        HashSet<Integer>[] graph = new HashSet[n + 1];

        HashMap<Integer, Integer>[] dis = new HashMap[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new HashSet<>();
            dis[i] = new HashMap<>();
        }

        UnionFind uf = new UnionFind(n + 1);
        for (int i = 0; i < m; i++) {
            int v1 = roads[i][0];
            int v2 = roads[i][1];
            uf.union(v1, v2);
            graph[v1].add(v2);
            graph[v2].add(v1);

            dis[v1].put(v2, roads[i][2]);
            dis[v2].put(v1, roads[i][2]);
        }

        int res = Integer.MAX_VALUE;
        for (int i = 1; i < graph.length; i++) {
            if (uf.isConnected(i, n)) {

                for (Integer k : graph[i]) {
                    res = Math.min(res, dis[i].get(k));
                }
            }
        }
        return res;
    }
    class UnionFind {
        int[] parent;
        int[] size;
        int[] rank;
        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
                rank[i] = 1;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }

        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) return;

            if (rank[pRoot] < rank[qRoot]) {
                parent[pRoot] = qRoot;
                size[qRoot] += size[pRoot];
            } else if (rank[pRoot] > rank[qRoot]) {
                parent[qRoot] = pRoot;
                size[pRoot] += size[qRoot];
            } else {
                parent[pRoot] = qRoot;
                size[qRoot] += size[pRoot];
                rank[qRoot]++;
            }
        }
    }
}