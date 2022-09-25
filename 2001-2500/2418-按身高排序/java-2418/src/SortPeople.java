import java.util.ArrayList;
import java.util.Arrays;

class SortPeople {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        int[][] pairs = new int[n][2];

        for (int i = 0; i < n; i++) {
            pairs[i][0] = i;
            pairs[i][1] = heights[i];
        }

        Arrays.sort(pairs, (a, b) -> {
            return b[1] - a[1];
        });

        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = names[pairs[i][0]];
        }
        return res;
    }
}