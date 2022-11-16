import java.util.Arrays;

public class ReversePairs3 {
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

    public int reversePairs(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];

        System.arraycopy(nums, 0, temp, 0, n);
        Arrays.sort(temp);
        for (int i = 0; i < n; i++) {
            nums[i] = Arrays.binarySearch(temp, nums[i]) + 1;
        }

        BinaryIndexedTree bit = new BinaryIndexedTree(n);
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            res += bit.query(nums[i] - 1);
            bit.add(nums[i], 1);
        }
        return res;
    }
}
