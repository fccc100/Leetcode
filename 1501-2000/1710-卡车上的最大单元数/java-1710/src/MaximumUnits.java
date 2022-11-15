import java.util.Arrays;

class MaximumUnits {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int n = boxTypes.length;

        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int res = 0;
        for (int i = 0; i < n; i++) {
            int curCnt = Math.min(truckSize, boxTypes[i][0]);

            res += curCnt * boxTypes[i][1];
            truckSize -= curCnt;
            if (truckSize <= 0) {
                break;
            }
        }
        return res;
    }
}