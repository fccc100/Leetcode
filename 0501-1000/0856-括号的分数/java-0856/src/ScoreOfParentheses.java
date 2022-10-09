import java.util.Deque;
import java.util.LinkedList;

class ScoreOfParentheses {
    public int scoreOfParentheses(String s) {
        int n = s.length();
        if (n == 0) return 0;
        if (n == 2) return 1;

        Deque<Character> stack = new LinkedList<>();
        int matchIndex = -1;
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                if (s.charAt(i) == '(') {
                    stack.push(s.charAt(i));
                } else {
                    stack.poll();

                    if (stack.isEmpty()) {
                        matchIndex = i;
                        break;
                    }
                }
            }
        }

        if (matchIndex == n - 1) {
            return 2 * scoreOfParentheses(s.substring(1, n - 1));
        } else {
            return scoreOfParentheses(s.substring(0, matchIndex + 1)) + scoreOfParentheses(s.substring(matchIndex + 1, n));
        }
    }
}