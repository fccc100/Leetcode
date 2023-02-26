import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class MergeArrays {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int id = nums1[i][0];
            int val = nums1[i][1];
            if (!map.containsKey(id)) {
                map.put(id, 0);
            }
            map.put(id, map.get(id) + val);
        }
        for (int i = 0; i < n; i++) {
            int id = nums2[i][0];
            int val = nums2[i][1];
            if (!map.containsKey(id)) {
                map.put(id, 0);
            }
            map.put(id, map.get(id) + val);
        }

        int[][] res = new int[map.size()][2];
        int idx = 0;
        for (Map.Entry entry : map.entrySet()) {
            res[idx] = new int[]{(int) entry.getKey(), (int) entry.getValue()};
            idx++;
        }
        Arrays.sort(res, (a, b) -> a[0] - b[0]);
        return res;
    }
}