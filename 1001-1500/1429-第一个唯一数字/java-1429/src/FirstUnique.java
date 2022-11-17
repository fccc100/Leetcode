import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class FirstUnique {
    HashMap<Integer, Integer> freqMap;
    Queue<Integer> queue = new LinkedList<>();
    public FirstUnique(int[] nums) {
        freqMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
            queue.offer(nums[i]);
        }
    }

    public int showFirstUnique() {
        while (!queue.isEmpty() && freqMap.get(queue.peek()) > 1) {
            queue.poll();
        }
        return queue.isEmpty() ? -1 : queue.peek();
    }

    public void add(int value) {
        freqMap.put(value, freqMap.getOrDefault(value, 0) + 1);
        queue.offer(value);
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */