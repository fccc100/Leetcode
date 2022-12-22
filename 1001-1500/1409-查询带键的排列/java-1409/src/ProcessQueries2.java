public class ProcessQueries2 {
    class BinaryIndexedTree {
        int[] tree;
        public BinaryIndexedTree(int n) {
            tree = new int[n + 1];
        }

        private int lowbit(int n) {
            return n & -n;
        }
        public int presum(int idx) {
            int res = 0;
            for (int i = idx; i > 0; i -= lowbit(i)) {
                res += tree[i];
            }
            return res;
        }
        public void add(int idx, int val) {
            for (int i = idx; i < tree.length; i += lowbit(i)) {
                tree[i] += val;
            }
        }
    }
    public int[] processQueries(int[] queries, int m) {
        int n = queries.length;
        BinaryIndexedTree bit = new BinaryIndexedTree(m + n);
        int[] pos = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            pos[i] = n + i;
            bit.add(n + i, 1);
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int cur = pos[queries[i]];
            bit.add(cur, -1);
            res[i] = bit.presum(cur);
            cur = n - i;
            pos[queries[i]] = cur;
            bit.add(cur, 1);
        }
        return res;
    }
}
