import java.util.Collections;
import java.util.List;

import java.util.ArrayList;

class MakeSubKSumEqual {
    public long makeSubKSumEqual(int[] arr, int k) {
        int n = arr.length;

        boolean[] visited = new boolean[n];
        long res = 0;
        for (int i = 0; i < k; i++) {
            if (!visited[i]) {
                List<Integer> cur = new ArrayList<>();
                int t = i;
                while (!visited[t]) {
                    visited[t] = true;
                    cur.add(arr[t]);
                    t = (t + k) % n;
                }
                Collections.sort(cur);
                int sz = cur.size();
                for (Integer x : cur) {
                    res += Math.abs(x - cur.get(sz / 2));
                }
            }
        }
        return res;
    }
}

