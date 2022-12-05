class LUPrefix2 {

    // 并查集
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

        public int getLongest() {
            return size[find(1)];
        }
    }

    UnionFind uf;
    int[] nums;
    public LUPrefix2(int n) {
        uf = new UnionFind(n + 1);
        nums = new int[n + 1];
    }

    public void upload(int video) {
        nums[video] = 1;
        if (video - 1 >= 1 && nums[video - 1] == 1) {
            uf.union(video, video - 1);
        }
        if (video + 1 < nums.length && nums[video + 1] == 1) {
            uf.union(video, video + 1);
        }
    }

    public int longest() {
        if (nums[1] == 0) return 0;
        return uf.getLongest();
    }
}
