import java.util.Arrays;

class MinCost {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += cost[i];
        }

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{nums[i], cost[i]};
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        long presum = 0;
        int target = -1;
        for (int i = 0; i < n; i++) {
            presum += arr[i][1];
            if (presum > sum / 2) {
                target = arr[i][0];
                break;
            }
        }

        long res = 0;
        for (int i = 0; i < n; i++) {
            res += (long) Math.abs(nums[i] - target) * cost[i];
        }
        return res;
    }
}
