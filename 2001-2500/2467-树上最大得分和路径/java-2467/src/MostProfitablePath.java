import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class MostProfitablePath {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = edges.length;

        HashSet<Integer>[] graph = new HashSet[n + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new HashSet<>();
        }

        for (int i = 0; i < n; i++) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }

        Queue<int[]> queue = new LinkedList<>();
        int[] bStep = new int[n + 1];
        boolean[] bVisited = new boolean[n + 1];
        queue.offer(new int[]{bob, 0});
        bVisited[bob] = true;
        int[] paths = new int[n + 1];
        Arrays.fill(paths, -1);
        paths[bob] = bob;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int[] cur = queue.poll();
                int p = cur[0];
                if (p == 0) break;

                for (int v : graph[p]) {
                    if (!bVisited[v]) {
                        bStep[v] = cur[1] + 1;
                        paths[v] = p;
                        bVisited[v] = true;
                        queue.offer(new int[]{v, cur[1] + 1});
                    }
                }
            }
        }

        HashSet<Integer> vSet = new HashSet<>();
        int cur = 0;
        vSet.add(cur);
        while (paths[cur] != bob) {
            cur = paths[cur];
            vSet.add(cur);
        }
        vSet.add(bob);

        for (int i = 0; i < paths.length; i++) {
            if (!vSet.contains(i)) {
                paths[i] = -1;
            }
        }

        int res = Integer.MIN_VALUE;
        boolean[] aVisited = new boolean[n + 1];
        queue.clear();
        queue.offer(new int[]{0, 0, amount[0]});
        aVisited[0] = true;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int[] curP = queue.poll();

                boolean hasChild = false;
                for (int v : graph[curP[0]]) {
                    if (!aVisited[v]) {
                        hasChild = true;
                        int s = 0;
                        if (paths[v] == -1) {
                            s = amount[v];
                        } else {
                            if (curP[1] + 1 < bStep[v]) {
                                s = amount[v];
                            } else if (curP[1] + 1 == bStep[v]) {
                                s = amount[v] / 2;
                            } else {
                                s = 0;
                            }
                        }

                        queue.offer(new int[]{v, curP[1] + 1, curP[2] + s});
                        aVisited[v] = true;
                    }
                }
                if (!hasChild) {
                    res = Math.max(res, curP[2]);
                }

            }
        }
        return res;
    }
}