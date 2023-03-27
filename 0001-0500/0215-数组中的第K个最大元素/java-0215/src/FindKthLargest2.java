import java.util.PriorityQueue;
import java.util.Queue;

public class FindKthLargest2 {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int x : nums) {
            pq.offer(x);
        }

        int res = -1;
        while (k > 0) {
            res = pq.poll();
            k--;
        }
        return res;
    }
}
