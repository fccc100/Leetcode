import java.util.Stack;

class MaxSumMinProduct {
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        int MOD = 1000000007;

        long[] presum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }

        int[] leftMin = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                    int top = stack.pop();
                    leftMin[top] = i;
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            leftMin[stack.pop()] = -1;
        }

        int[] rightMin = new int[n];
        stack.clear();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                    int top = stack.pop();
                    rightMin[top] = i;
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            rightMin[stack.pop()] = n;
        }

        long res = 0;
        for (int i = 0; i < n; i++) {
            int l = leftMin[i];
            int r = rightMin[i];
            long sum = presum[r] - presum[l + 1];
            long pro = (long) nums[i] * sum;
            if (pro > res) res = pro;
        }
        return (int) (res % MOD);
    }
}