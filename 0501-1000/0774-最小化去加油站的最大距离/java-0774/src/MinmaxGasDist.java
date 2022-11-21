import java.util.PriorityQueue;

class MinmaxGasDist {
    public double minmaxGasDist(int[] stations, int k) {
        double l = 0;
        double r = 1e8;
        while (r - l > 1e-6) {
            double mid = (l + r) / 2.0;
            if (check(stations, mid, k)) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return l;
    }
    private boolean check(int[] stations, double mid, int k) {
        int used = 0;
        for (int i = 0; i < stations.length - 1; i++) {
            used += (int) ((stations[i + 1] - stations[i]) / mid);
        }
        return used <= k;
    }
}
