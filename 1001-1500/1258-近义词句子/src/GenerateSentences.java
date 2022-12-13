import com.sun.tools.javac.util.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class GenerateSentences {
    class UnionFind {
        int[] parent;
        int[] size;
        int[] rank;
        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
                rank[i] = 1;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }

        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) return;

            if (rank[pRoot] < rank[qRoot]) {
                parent[pRoot] = qRoot;
                size[qRoot] += size[pRoot];
            } else if (rank[pRoot] > rank[qRoot]) {
                parent[qRoot] = pRoot;
                size[pRoot] += size[qRoot];
            } else {
                parent[pRoot] = qRoot;
                size[qRoot] += size[pRoot];
                rank[qRoot]++;
            }
        }

        public HashMap<Integer, List<Integer>> getGroup() {
            HashMap<Integer, List<Integer>> res = new HashMap<>();
            for (int i = 0; i < parent.length; i++) {
                int root = find(i);
                if (!res.containsKey(root)) {
                    res.put(root, new ArrayList<>());
                }
                res.get(root).add(i);
            }
            return res;
        }
    }

    List<String> res;
    HashMap<String, Integer> nameToId;
    HashMap<Integer, String> idToName;
    UnionFind uf;
    HashMap<Integer, List<Integer>> group;
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        int n = synonyms.size();
        nameToId = new HashMap<>();
        idToName = new HashMap<>();
        res = new ArrayList<>();

        int id = 0;
        for (int i = 0; i < n; i++) {
            List<String> pair = synonyms.get(i);

            if (!nameToId.containsKey(pair.get(0))) {
                nameToId.put(pair.get(0), id);
                idToName.put(id, pair.get(0));
                id++;
            }
            if (!nameToId.containsKey(pair.get(1))) {
                nameToId.put(pair.get(1), id);
                idToName.put(id, pair.get(1));
                id++;
            }
        }

        uf = new UnionFind(id);
        for (int i = 0; i < n; i++) {
            uf.union(nameToId.get(synonyms.get(i).get(0)), nameToId.get(synonyms.get(i).get(1)));
        }

        group = uf.getGroup();

        String[] textArr = text.split(" ");
        build(textArr, 0, "");
        Collections.sort(res);
        return res;
    }
    private void build(String[] arr, int index, String curStr) {
        if (index == arr.length) {
            res.add(curStr);
            return;
        }

        String curText = arr[index];
        if (!nameToId.containsKey(curText)) {
            if (curStr.length() > 0) {
                build(arr, index + 1, curStr + " " + curText);
            } else {
                build(arr, index + 1, curStr + curText);
            }
        } else {
            int id = nameToId.get(curText);
            List<Integer> g = group.get(uf.find(id));

            for (int i = 0; i < g.size(); i++) {
                int transId = g.get(i);

                if (curStr.length() > 0) {
                    build(arr, index + 1, curStr + " " + idToName.get(transId));
                } else {
                    build(arr, index + 1, curStr + idToName.get(transId));
                }
            }
        }
    }
}