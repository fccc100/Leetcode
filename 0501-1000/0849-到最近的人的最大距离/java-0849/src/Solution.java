class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int[] dis = new int[n];
        int pre = -1;
        for (int i = 0; i < n; i++) {
            if (seats[i] == 0) {
                dis[i] = pre;
            } else {
                pre = i;
            }
        }

        int next = n;
        int max = -1;

        for (int i = n - 1; i >= 0; i--) {
            if (seats[i] == 0) {
                if (next >= n) {
                    if (i - dis[i] > max) {
                        max = i - dis[i];
                    }
                } else if (dis[i] < 0) {
                    if (next - i > max) {
                        max = next - i;
                    }
                } else {
                    if (Math.min(i - dis[i], next - i) > max) {
                        max = Math.min(i - dis[i], next - i);
                    }
                }
            } else {
                next = i;
            }
        }
        return max;
    }
}