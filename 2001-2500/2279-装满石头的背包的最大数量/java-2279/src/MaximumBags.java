import java.util.Arrays;

class MaximumBags {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;

        int[] leftCapacity = new int[n];
        for (int i = 0; i < n; i++) {
            leftCapacity[i] = capacity[i] - rocks[i];
        }

        Arrays.sort(leftCapacity);

        int res = 0;
        for (int i = 0;i < n; i++) {
            if (leftCapacity[i] > additionalRocks) break;

            additionalRocks -= leftCapacity[i];
            res++;
        }
        return res;
    }
}