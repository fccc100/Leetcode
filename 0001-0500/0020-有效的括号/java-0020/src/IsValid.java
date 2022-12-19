import java.util.Deque;
import java.util.LinkedList;

class IsValid {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.offerFirst(s.charAt(i));
            } else {
                char t = stack.peekFirst();
                char c = s.charAt(i);

                if ((c == ')' && t == '(') || c == '}' && t == '{' || c == ']' && t == '[') {
                    stack.pollFirst();
                } else {
                    stack.offerFirst(c);
                }
            }
        }
        return stack.isEmpty();
    }
}