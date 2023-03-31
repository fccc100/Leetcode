import java.util.HashSet;

class ArithmeticTriplets {
    public int arithmeticTriplets(int[] nums, int diff) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int x : nums) {
            set.add(x);
        }
        int res = 0;
        for (int x : nums) {
            if (set.contains(x + diff) && set.contains(x - diff)) {
                res ++;
            }
        }
        return res;
    }
}