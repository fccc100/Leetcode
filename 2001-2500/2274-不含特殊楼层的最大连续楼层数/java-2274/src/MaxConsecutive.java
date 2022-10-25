import java.util.Arrays;

class MaxConsecutive {
    public int maxConsecutive(int bottom, int top, int[] special) {
        int n = special.length;

        Arrays.sort(special);
        int max = special[0] - bottom;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, special[i] - special[i - 1] - 1);
        }
        return Math.max(max, top - special[n - 1]);
    }
}