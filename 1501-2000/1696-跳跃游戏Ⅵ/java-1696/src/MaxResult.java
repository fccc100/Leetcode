import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class MaxResult {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;

        int[] dp = new int[n];
        dp[0] = nums[0];

        // 单调双端队列
        Deque<Integer> queue = new LinkedList<>();
        queue.offerLast(0);
        for (int i = 1; i < n; i++) {
            dp[i] = dp[queue.peekFirst()] + nums[i];

            if (i - queue.peekFirst() >= k) {
                queue.pollFirst();
            }

            while (!queue.isEmpty() && dp[queue.peekLast()] <= dp[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        return dp[n - 1];
    }
}