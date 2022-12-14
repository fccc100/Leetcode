import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class MinimumHammingDistance {
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
        public HashMap<Integer, ArrayList<Integer>> getGroup() {
            HashMap<Integer, ArrayList<Integer>> res = new HashMap<>();
            for (int i = 0; i < parent.length; i++) {
                int root = find(i);
                if (!res.containsKey(root)) {
                    res.put(root, new ArrayList<>());
                }
                res.get(root).add(i);
            }
            return res;
        }
    }
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int m = source.length;
        int n = allowedSwaps.length;
        UnionFind uf = new UnionFind(m);
        for (int i = 0; i < n; i++) {
            uf.union(allowedSwaps[i][0], allowedSwaps[i][1]);
        }

        int res = 0;
        HashMap<Integer, ArrayList<Integer>> group = uf.getGroup();
        for (ArrayList<Integer> g : group.values()) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < g.size(); i++) {
                int idx = g.get(i);
                map.put(source[idx], map.getOrDefault(source[idx], 0) + 1);
            }

            int same = 0;
            for (int i = 0; i < g.size(); i++) {
                int idx = g.get(i);
                if (map.containsKey(target[idx])) {
                    same++;
                    map.put(target[idx], map.get(target[idx]) - 1);
                    if (map.get(target[idx]) == 0) {
                        map.remove(target[idx]);
                    }
                }
            }
            res += g.size() - same;
        }
        return res;
    }
}