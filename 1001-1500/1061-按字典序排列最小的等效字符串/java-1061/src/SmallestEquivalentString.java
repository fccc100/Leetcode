class SmallestEquivalentString {
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
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int m = s1.length();

        UnionFind uf = new UnionFind(26);
        for (int i = 0; i < m; i++) {
            uf.union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        int n = baseStr.length();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int cur = baseStr.charAt(i) - 'a';
            boolean isMatch = false;
            for (int j = 0; j < 26; j++) {
                if (uf.isConnected(cur, j)) {
                    isMatch = true;
                    char c = (char) (j + Integer.valueOf('a'));
                    res.append(c);
                    break;
                }
            }
            if (!isMatch) res.append(baseStr.charAt(i));
        }
        return res.toString();
    }
}