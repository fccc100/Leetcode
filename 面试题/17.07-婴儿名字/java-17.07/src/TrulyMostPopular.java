import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class TrulyMostPopular {
    class UnionFind {
        int[] parent;
        int[] rank;
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
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
            } else if (rank[qRoot] < rank[pRoot]) {
                parent[qRoot] = pRoot;
            } else {
                parent[pRoot] = qRoot;
                rank[qRoot] += 1;
            }
        }

        public HashMap<Integer, ArrayList<Integer>> getGroup() {
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

            for (int i = 0; i < parent.length; i++) {
                int root = find(i);
                if (!map.containsKey(root)) {
                    map.put(root, new ArrayList<>());
                }
                map.get(root).add(i);
            }
            return map;
        }
    }
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        int n = names.length;
        HashMap<String, Integer> nameToId = new HashMap<>();
        HashMap<Integer, String> idToName = new HashMap<>();
        HashMap<String, Integer> nameToCnt = new HashMap<>();
        int nameIdx = 0;
        for (int i = 0; i < n; i++) {
            String cur = names[i];
            int idx1 = cur.indexOf('(');
            int idx2 = cur.indexOf(')');
            String name = cur.substring(0, idx1);
            String cnt = cur.substring(idx1 + 1, idx2);

            if (!nameToId.containsKey(name)) {
                nameToId.put(name, nameIdx);
                idToName.put(nameIdx, name);
                nameIdx++;
            }
            nameToCnt.put(name, nameToCnt.getOrDefault(name, 0) + Integer.valueOf(cnt));
        }

        for (int i = 0; i < synonyms.length; i++) {
            String cur = synonyms[i];
            int len = cur.length();
            int idx = cur.indexOf(',');

            String name1 = cur.substring(1, idx);
            String name2 = cur.substring(idx + 1, len - 1);
            if (!nameToId.containsKey(name1)) {
                nameToId.put(name1, nameIdx);
                idToName.put(nameIdx, name1);
                nameIdx++;
            }
            if (!nameToId.containsKey(name2)) {
                nameToId.put(name2, nameIdx);
                idToName.put(nameIdx, name2);
                nameIdx++;
            }
        }

        UnionFind uf = new UnionFind(nameToId.size());
        for (int i = 0; i < synonyms.length; i++) {
            String cur = synonyms[i];
            int len = cur.length();
            int idx = cur.indexOf(',');

            String name1 = cur.substring(1, idx);
            String name2 = cur.substring(idx + 1, len - 1);
            int idx1 = nameToId.get(name1);
            int idx2 = nameToId.get(name2);
            uf.union(idx1, idx2);
        }

        HashMap<Integer, ArrayList<Integer>> group = uf.getGroup();
        ArrayList<String> res = new ArrayList<>();
        for (Map.Entry entry : group.entrySet()) {
            ArrayList<Integer> list = (ArrayList<Integer>) entry.getValue();

            String target = idToName.get(list.get(0));
            int totalCnt = 0;
            for (int i = 0; i < list.size(); i++) {
                String name = idToName.get(list.get(i));
                if (name.compareTo(target) < 0) {
                    target = name;
                }
                int cnt = nameToCnt.getOrDefault(name, 0);
                totalCnt += cnt;
            }
            String cur = target + "(" + totalCnt + ")";
            res.add(cur);
        }

        String[] ans = new String[res.size()];
        int idx = 0;
        for (int i = 0; i < res.size(); i++) {
            ans[idx] = res.get(i);
            idx++;
        }
        return ans;
    }
}