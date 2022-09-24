import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Decrypt {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        if (k == 0) {
            return res;
        } else if (k > 0) {
            for (int i = 0; i < n; i++) {
                int sum = 0;
                int t = k;

                for (int j = (i + 1 >= n ? 0: i + 1); t > 0; t--) {
                    sum += code[j];
                    j = (j + 1) % n;
                }
                res[i] = sum;
            }
        } else {
            for (int i = 0; i < n; i++) {
                int sum = 0;
                int t = k;

                for (int j = (i - 1 < 0 ? n - 1 : i - 1); t < 0; t++) {
                    sum += code[j];
                    j = (j + n - 1) % n;
                }
                res[i] = sum;
            }
        }
        return res;
    }
}

class Solution {
    public int transportationHub(int[][] path) {

        int n = 0;
        for (int i = 0; i < path.length; i++) {
            n = Math.max(n, Math.max(path[i][0], path[i][1]));
        }
        n = n + 1;

        ArrayList<HashSet<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet());
        }

        int [] inDegree = new int[n];

        for (int i = 0; i < path.length; i++) {

            graph.get(path[i][0]).add(path[i][1]);
            inDegree[path[i][1]]++;
        }
        System.out.print(graph);

        int visitedCnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                visitedCnt++;
            }
        }
        if (queue.isEmpty()) return -1;



        int res = -1;
        boolean flag = false;
        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                int curV = queue.poll();

                HashSet<Integer> curSet = graph.get(curV);
                for (Integer key : curSet) {
                    inDegree[key]--;
                    if (inDegree[key] == 0) {
                        queue.offer(key);
                        if (len == 1 && visitedCnt == n - 1) {
                            flag = true;
                            res = key;
                        }
                    }
                }
            }
        }

        boolean hasRes = true;
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] > 0) {
                hasRes = false;
            }
        }
        if (hasRes && false) {
            return res;
        } else {
            return -1;
        }
    }
}