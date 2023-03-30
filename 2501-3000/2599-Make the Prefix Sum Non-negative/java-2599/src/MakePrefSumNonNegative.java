import java.util.PriorityQueue;
import java.util.Queue;

class MakePrefSumNonNegative {
    public int makePrefSumNonNegative(int[] nums) {
        int n = nums.length;
        Queue<Integer> pq = new PriorityQueue<>();
        int res = 0;
        long presum = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                pq.offer(nums[i]);
            }
            presum += nums[i];
            if (presum < 0) {
                presum -= pq.poll();
                res++;
            }
        }
        return res;
    }
}