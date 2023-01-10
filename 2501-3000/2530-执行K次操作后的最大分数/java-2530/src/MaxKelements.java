import java.util.PriorityQueue;

class MaxKelements {
    public long maxKelements(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < n; i++) {
            pq.offer(nums[i]);
        }

        long res = 0;
        while (k > 0) {
            int top = pq.poll();
            res += top;
            pq.offer(top % 3 == 0 ? top / 3 : top / 3 + 1);
            k--;
        }
        return res;
    }
}