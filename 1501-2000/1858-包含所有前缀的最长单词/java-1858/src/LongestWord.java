import java.util.HashMap;

class LongestWord {
    public String longestWord(String[] words) {
        Trie trie = new Trie();

        for (int i = 0; i < words.length; i++) {
            trie.add(words[i]);
        }

        String res = "";
        for (int i = 0; i < words.length; i++) {
            if (trie.check(words[i])) {
                if (words[i].length() > res.length()) {
                    res = words[i];
                } else if (words[i].length() == res.length()) {
                    res = res.compareTo(words[i]) < 0 ? res : words[i];
                }
            }
        }
        return res;
    }
}

class Trie {
    class Node {
        private HashMap<Character, Node> next;
        private boolean isWord;

        public Node() {
            next = new HashMap<>();
            isWord = false;
        }
    }

    private int size;
    private Node root;
    public Trie() {
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
        }

        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    public boolean check(String word) {
        Node cur = root;

        for (int i = 0; i < word.length(); i++) {
            cur = cur.next.get(word.charAt(i));
            if (!cur.isWord) {
                return false;
            }
        }
        return cur.isWord;
    }
}
