import com.sun.tools.javac.util.List;

import java.util.HashMap;

class AreSentencesSimilarTwo {
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
    }
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) return false;
        int n = similarPairs.size();
        HashMap<String, Integer> wordToId = new HashMap<>();
        int id = 0;
        for (int i = 0; i < n; i++) {
            if (!wordToId.containsKey(similarPairs.get(i).get(0))) {
                wordToId.put(similarPairs.get(i).get(0), id);
                id++;
            }
            if (!wordToId.containsKey(similarPairs.get(i).get(1))) {
                wordToId.put(similarPairs.get(i).get(1), id);
                id++;
            }
        }
        UnionFind uf = new UnionFind(id);
        for (int i = 0; i < n; i++) {
            uf.union(wordToId.get(similarPairs.get(i).get(0)), wordToId.get(similarPairs.get(i).get(1)));
        }

        for (int i = 0; i < sentence1.length; i++) {
            if (sentence1[i].equals(sentence2[i])) continue;

            if (!wordToId.containsKey(sentence1[i]) || !wordToId.containsKey(sentence2[i])) return false;

            if (!uf.isConnected(wordToId.get(sentence1[i]), wordToId.get(sentence2[i]))) return false;
        }
        return true;
    }
}