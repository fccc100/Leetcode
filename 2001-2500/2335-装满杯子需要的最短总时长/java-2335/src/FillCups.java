import java.util.Arrays;

class FillCups {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        int res = 0;
        while (amount[2] > 0) {
            amount[1]--;
            amount[2]--;
            res++;
            Arrays.sort(amount);
        }
        return res;
    }
}