import java.util.Arrays;
import java.util.HashMap;

class GetMaximumConsecutive {
    public int getMaximumConsecutive(int[] coins) {
        int n = coins.length;
        Arrays.sort(coins);

        int res = 1;
        for (int x : coins) {
            if (x > res) break;
            res += x;
        }
        return res;
    }
}