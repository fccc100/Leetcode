import java.util.Arrays;

class TrimMean {
    public double trimMean(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);

        int cnt = (int)Math.floor(n * 0.05);
        double sum = 0;

        for (int i = cnt; i < n - cnt; i++) {
            sum += arr[i];
        }
        return sum / (n - cnt - cnt);
    }
}