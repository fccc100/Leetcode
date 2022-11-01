class NumArray {

    // 树状数组
    private class BinaryIndexedTree {
        int[] tree;
        public BinaryIndexedTree(int n) {
            tree = new int[n + 1];
        }

        public int lowbit(int x) {
            return x & (-x);
        }

        public int preSum(int index) {
            int res = 0;
            for (int i = index; i > 0; i -= lowbit(i)) {
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

    int[] nums;
    BinaryIndexedTree biTree;
    public NumArray(int[] nums) {
        this.nums = nums;
        biTree = new BinaryIndexedTree(nums.length);
        for (int i = 0; i < nums.length; i++) {
            biTree.add(i + 1, nums[i]);
        }
    }

    public void update(int index, int val) {
        biTree.add(index + 1, val - nums[index]);
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return biTree.preSum(right + 1) - biTree.preSum(left);
    }
}
