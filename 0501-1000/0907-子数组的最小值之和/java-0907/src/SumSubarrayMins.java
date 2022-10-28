import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

class SumSubarrayMins {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = 1000000007;

        int[] leftMin = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                    leftMin[stack.pop()] = i;
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
                while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                    rightMin[stack.pop()] = i;
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            rightMin[stack.pop()] = n;
        }

        long res = 0;
        for (int i = 0; i < n; i++) {
            int leftCnt = i - leftMin[i];
            int rightCnt = rightMin[i] - i;

            res = (res + (long) arr[i] * leftCnt * rightCnt) % mod;
        }
        return (int) res;
    }
}