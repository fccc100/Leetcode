import java.util.HashMap;

class SumPrefixScores {

    public int[] sumPrefixScores(String[] words) {
        Trie1 trie = new Trie1();

        for (int i = 0; i < words.length; i++) {
            trie.add(words[i]);
        }

        int[] res = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            res[i] = trie.count(words[i]);
        }
        return res;
    }
}


class Trie1 {
    class Node {
        private HashMap<Character, Node> next;
        private boolean isWord;
        private int prefixCnt;

        public Node() {
            next = new HashMap<>();
            isWord = false;
            prefixCnt = 0;
        }
    }

    private int size;
    private Node root;
    public Trie1() {
        root = new Node();
        size = 0;
    }

    public void add(String word) {
        Node cur = root;

        for (int i = 0; i < word.length(); i++) {
            if (!cur.next.containsKey(word.charAt(i))) {
                cur.next.put(word.charAt(i), new Node());
            }
            cur = cur.next.get(word.charAt(i));
            cur.prefixCnt++;
        }

        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    public int count(String word) {
        Node cur = root;

        int res = 0;
        for (int i = 0; i < word.length(); i++) {
            if (!cur.next.containsKey(word.charAt(i))) {
                return res;
            } else {
                cur = cur.next.get(word.charAt(i));
                res += cur.prefixCnt;
            }
        }
        return res;
    }
}