/**
 * @param {string[]} words
 * @return {string}
 */
var longestWord = function (words) {
    let trie = new Trie();
    for (let i = 0; i < words.length; i++) {
        trie.add(words[i]);
    }

    let res = '';
    for (let i = 0; i < words.length; i++) {
        if (trie.check(words[i])) {
            if (words[i].length > res.length) {
                res = words[i];
            } else if (words[i].length == res.length) {
                res = res < words[i] ? res : words[i];
            }
        }
    }
    return res;
};

class Node {
    constructor() {
        this.next = new Map();
        this.isWord = false;
    }
}

class Trie {
    constructor() {
        this.root = new Node;
        this.size = 0;
    }

    add(word) {
        let cur = this.root;

        for (let i = 0; i < word.length; i++) {
            if (!cur.next.has(word[i])) {
                cur.next.set(word[i], new Node());
            }

            cur = cur.next.get(word[i]);
        }

        if (!cur.isWord) {
            cur.isWord = true;
            this.size++;
        }
    }

    check(word) {
        let cur = this.root;

        for (let i = 0; i < word.length; i++) {
            cur = cur.next.get(word[i]);
            if (!cur.isWord) {
                return false;
            }
        }
        return cur.isWord;
    }
}