/**
 * @param {string[]} words
 * @return {number[]}
 */
var sumPrefixScores = function (words) {
    let trie = new Trie();
    for (let i = 0; i < words.length; i++) {
        trie.add(words[i]);
    }

    let res = Array(words.length);
    for (let i = 0; i < words.length; i++) {
        res[i] = trie.countWordsStartingWith(words[i]);
    }

    return res;
};


class Node {
    constructor(isWord) {
        this.next = new Map();
        this.isWord = isWord || false;
        this.prefixCount = 0;
    }
}

class Trie {
    constructor() {
        this.root = new Node();
        this.size = 0;
    }

    add(word) {
        let cur = this.root;
        for (let i = 0; i < word.length; i++) {
            if (!cur.next.has(word[i])) {
                cur.next.set(word[i], new Node());
            }
            cur = cur.next.get(word[i]);

            // 以当前字符作为前缀的单词数 + 1
            cur.prefixCount++;
        }
        if (!cur.isWord) {
            cur.isWord = true;
            this.size++;
        }
    }

    countWordsStartingWith(prefix) {
        let cur = this.root;

        let res = 0;
        for (let i = 0; i < prefix.length; i++) {
            if (!cur.next.has(prefix[i])) {
                return res;
            } else {
                cur = cur.next.get(prefix[i]);
                res += cur.prefixCount;
            }
        }
        return res;
    }
}