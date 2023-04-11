class NumSimilarGroups {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;

        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (uf.isConnected(i, j)) continue;

                if (check(strs[i], strs[j])) uf.union(i, j);
            }
        }
        return uf.getCCCount();
    }

    private boolean check(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int cnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) cnt++;
            if (cnt > 2) return false;
        }
        return cnt == 0 || cnt == 2;
    }

    class UnionFind {
        int[] parent;
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
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

            parent[pRoot] = qRoot;
        }

        public int getCCCount() {
            int res = 0;
            for (int i = 0; i < parent.length; i++) {
                if (parent[i] == i) res++;
            }
            return res;
        }
    }
}