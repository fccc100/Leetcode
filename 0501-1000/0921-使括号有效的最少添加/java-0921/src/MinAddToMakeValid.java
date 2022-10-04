import java.util.Deque;
import java.util.LinkedList;

class MinAddToMakeValid {
    public int minAddToMakeValid(String s) {
        Deque<Character> stack = new LinkedList<>();

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.offerLast(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    res++;
                    continue;
                }
                if (stack.peekLast() == '(') {
                    stack.pollLast();
                } else {
                    res++;
                }
            }
        }
        return res + stack.size();
    }
}