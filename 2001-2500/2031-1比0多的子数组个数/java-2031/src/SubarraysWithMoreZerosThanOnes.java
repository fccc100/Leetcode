import java.util.TreeSet;

class SubarraysWithMoreZerosThanOnes {
    public int subarraysWithMoreZerosThanOnes(int[] nums) {
        int n = nums.length;

        // 把0当作-1， 先求前缀和，再求每个位置左边比其小的元素个数
        int[] presum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i - 1] + (nums[i - 1] == 0 ? -1 : 1);
        }

        TreeSet<Integer> set = new TreeSet<>();
        for (int v : nums) {

        }

        return 0;
    }
}

//          [0,  1,  1,  0,  1]
//          [-1, 1,  1, -1,  1]
// presum [0, -1, 0,  1,  0,  1]