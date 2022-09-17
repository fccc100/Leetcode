import java.util.Deque;
import java.util.LinkedList;

class ConstrainedSubsetSum {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return 0;

        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];

        Deque<Integer> queue = new LinkedList<>();
        queue.offerLast(0);
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[queue.peekFirst()] + nums[i]);
            max = Math.max(max, dp[i]);

            if (i - queue.peekFirst() >= k) {
                queue.pollFirst();
            }

            while (!queue.isEmpty() && dp[queue.peekLast()] <= dp[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        return max;
    }
}