import java.util.HashMap;

class MinimumRounds {
    public int minimumRounds(int[] tasks) {
        int n = tasks.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }

        int res = 0;
        for (Integer val : map.values()) {
            if (val < 2) return -1;
            if (val % 3 == 0) {
                res += val / 3;
            } else {
                res += val / 3 + 1;
            }
        }
        return res;
    }
}