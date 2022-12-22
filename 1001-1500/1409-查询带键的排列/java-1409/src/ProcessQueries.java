import java.util.ArrayList;

class ProcessQueries {
    public int[] processQueries(int[] queries, int m) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            nums.add(i);
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int idx = nums.indexOf(queries[i]);
            nums.remove(idx);
            nums.add(0, queries[i]);
            res[i] = idx;
        }
        return res;
    }
}