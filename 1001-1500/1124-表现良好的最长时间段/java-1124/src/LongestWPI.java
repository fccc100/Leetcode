import java.util.HashMap;
import java.util.Stack;

class LongestWPI {
    // 求区间和为0的最长子数组
    public int longestWPI(int[] hours) {
        int n = hours.length;
        for (int i = 0; i < n; i++) {
            hours[i] = hours[i] > 8 ? 1 : -1;
        }

        int[] presum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i - 1] + hours[i - 1];
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= n; i++) {
            if (stack.isEmpty() || presum[stack.peek()] > presum[i]) {
                stack.push(i);
            }
        }

        int res = 0;
        for (int i = n; i >= 0; i--) {
            while (!stack.isEmpty()) {
                if (presum[i] - presum[stack.peek()] > 0) {
                    res = Math.max(res, i - stack.peek());
                    stack.pop();
                } else break;
            }
        }
        return res;
    }
}

// [9, 9,  6, 0,  6,  6,  9]
// [1, 1, -1, -1, -1, -1, 1]
// [1, 2,  1,  0, -1, -2, -1]
//