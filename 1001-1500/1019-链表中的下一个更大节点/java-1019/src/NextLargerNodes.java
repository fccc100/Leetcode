import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class NextLargerNodes {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> res = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            res.add(cur.val);
            cur = cur.next;
        }

        int[] ans = new int[res.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < res.size(); i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && res.get(stack.peek()) < res.get(i)) {
                    int top = stack.pop();
                    ans[top] = res.get(i);
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            ans[stack.pop()] = 0;
        }
        return ans;
    }
}