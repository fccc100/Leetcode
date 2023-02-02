import java.util.Arrays;
import java.util.PriorityQueue;

class MaxPrice {
    class Solution {
        public double maxPrice(int[][] items, int capacity) {
            int n = items.length;
            Arrays.sort(items, (a, b) -> {
                double diff = (double) b[0] / b[1] - (double) a[0] / a[1];
                if (diff == 0) {
                    return 0;
                } else if (diff > 0) {
                    return 1;
                } else {
                    return -1;
                }
            });

            double res = 0;
            for (int i = 0; i < n; i++) {
                int p = items[i][0];
                int w = items[i][1];
                if (w <= capacity) {
                    res += p;
                    capacity -= w;
                    if (capacity <= 0) break;
                } else {
                    res += ((double) capacity * p) / (double) w;
                    capacity = 0;
                    break;
                }
            }
            return capacity == 0 ? res : -1;
        }
    }
}
