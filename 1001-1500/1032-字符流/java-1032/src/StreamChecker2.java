import java.util.HashMap;
import java.util.Map;

public class StreamChecker2 {
    class Node{
        boolean isWord;
        Map<Character, Node> next;
        public Node() {
            isWord = false;
            next = new HashMap<>();
        }
        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new HashMap<>();
        }
    }
    class Trie {
        Node root;
        int size;
        public Trie() {
            root = new Node();
            size = 0;
        }

        public void add(String word) {
            Node cur = root;
            for (int i = word.length() - 1; i >= 0; i--) {
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

        public boolean search(String word) {
            Node cur = this.root;
            for (int i = word.length() - 1; i >= 0; i--) {
                if (!cur.next.containsKey(word.charAt(i))) {
                    return false;
                } else {
                    cur = cur.next.get(word.charAt(i));
                }
                if (cur.isWord) {
                    return true;
                }
            }
            return !!cur.isWord;
        }
    }

    Trie trie;
    StringBuilder sb;
    public StreamChecker2(String[] words) {
        trie = new Trie();
        sb = new StringBuilder();
        for (String w : words) {
            trie.add(w);
        }
    }

    public boolean query(char letter) {
        sb.append(letter);
        System.out.println(sb);
        return trie.search(sb.toString());
    }

    // c -> b -> a
    // z -> y -> x
    // axyz
}
