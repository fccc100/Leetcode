import java.util.HashMap;

class GoodTriplets {
    class BinaryIndexedTree {
        int[] tree;
        public BinaryIndexedTree(int n) {
            tree = new int[n + 1];
        }

        public int lowbit(int x) {
            return x & (-x);
        }

        public int query(int x) {
            int res = 0;
            for (int i = x; i > 0; i -= lowbit(i)) {
                res += tree[i];
            }
            return res;
        }

        public void add(int index, int x) {
            for (int i = index; i < tree.length; i += lowbit(i)) {
                tree[i] += x;
            }
        }
    }

    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums2[i], i + 1);
        }

        BinaryIndexedTree bit = new BinaryIndexedTree(n);
        long res = 0;
        for (int i = 0; i < n; i++) {
            int idx = map.get(nums1[i]);

            int left = bit.query(idx);
            int right = n - idx - (bit.query(n) - bit.query(idx));
            res += (long) left * right;
            bit.add(idx, 1);
        }
        return res;
    }
}