import java.util.Deque;
import java.util.LinkedList;

public class ScoreOfParentheses2 {
    public int scoreOfParentheses(String s) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(0);
            } else {
                int v = stack.pop();
                int top = stack.pop() + Math.max(2 * v, 1);
                stack.push(top);
            }
        }
        return stack.peek();
    }
}
