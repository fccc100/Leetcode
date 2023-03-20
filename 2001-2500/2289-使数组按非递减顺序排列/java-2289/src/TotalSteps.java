import java.util.Deque;
import java.util.LinkedList;

class TotalSteps {
    public int totalSteps(int[] nums) {
        int n = nums.length;
        int res = 0;
        Deque<int[]> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int maxT = 0;
            while (!stack.isEmpty() && stack.peek()[0] <= nums[i]) {
                maxT = Math.max(maxT, stack.pop()[1]);
            }
            maxT = stack.isEmpty() ? 0 : maxT + 1;
            res = Math.max(res, maxT);
            stack.push(new int[]{nums[i], maxT});
        }
        return res;
    }
}
// [10,0]
// [10,0][1,1]
// [10,0][2,2]

// [10,1,2,3,4,5,6,1,2,3]
// [10,2,3,4,5,6,2,3]
// [10,3,4,5,6,3]
// [10,4,5,6]
// [10,5,6]
// [10,6]
// [10]