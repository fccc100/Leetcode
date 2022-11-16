import java.util.ArrayList;
import java.util.Collections;

class StreamRank {

    ArrayList<Integer> nums;
    public StreamRank() {
        nums = new ArrayList<>();
    }

    public void track(int x) {
        nums.add(x);
        Collections.sort(nums);
    }

    public int getRankOfNumber(int x) {
        int res = 0;
        for (Integer n : nums) {
            if (n > x) break;
            res++;
        }
        return res;
    }
}

/**
 * Your StreamRank object will be instantiated and called as such:
 * StreamRank obj = new StreamRank();
 * obj.track(x);
 * int param_2 = obj.getRankOfNumber(x);
 */

// 2 3 4 10 5