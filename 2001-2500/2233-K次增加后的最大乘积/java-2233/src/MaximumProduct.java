import java.util.PriorityQueue;

class MaximumProduct {
    public int maximumProduct(int[] nums, int k) {
        int n = nums.length;
        int mod = 1000000007;

        long sum = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (k <= 0) return 0;
                nums[i] = 1;
                k--;
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(nums[i]);
        }

        while (k > 0) {
            pq.offer(pq.poll() + 1);
            k--;
        }

        while (!pq.isEmpty()) {
            sum = (sum * pq.poll()) % mod;
        }
        return (int)sum;
    }
}