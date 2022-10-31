import javax.swing.text.html.StyleSheet;
import java.util.*;

class SecondGreaterElement {
    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];
        Deque<Integer> stack1 = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return nums[o1] - nums[o2];
            }
        });
        Arrays.fill(res, -1);

        for (int i = 0; i < n; i++) {
            if (stack1.isEmpty()) {
                stack1.push(i);
            } else {
                while (!pq.isEmpty() && nums[i] > nums[pq.peek()]) {
                    res[pq.poll()] = nums[i];
                }

                while (!stack1.isEmpty() && nums[i] > nums[stack1.peek()]) {
                    pq.offer(stack1.pop());
                }

                stack1.push(i);
            }
        }

        return res;
    }
}
