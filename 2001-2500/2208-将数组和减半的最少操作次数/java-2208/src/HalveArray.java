import java.util.PriorityQueue;

class HalveArray {
    public int halveArray(int[] nums) {
        int n = nums.length;

        double[] temp = new double[n];
        for (int i = 0; i < n; i++) {
            temp[i] = (double) nums[i];
        }

        PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> {
            double d = b / 2 - a / 2;
            if (d > 0) {
                return 1;
            } else if (d < 0) {
                return -1;
            } else {
                return 0;
            }
        });

        double sum = 0;
        for (int i = 0; i < n; i++) {
            pq.offer(temp[i]);
            sum += temp[i];
        }

        double d = 0;
        int res = 0;
        while (d < sum / 2) {
            double t = pq.poll();
            d += t / 2;
            pq.offer(t / 2);
            res++;
        }
        return res;
    }
}