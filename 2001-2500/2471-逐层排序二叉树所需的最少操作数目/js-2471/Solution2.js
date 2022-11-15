/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */

// 并查集解法
var minimumOperations = function (root) {
    if (root == null) return 0

    let queue = []
    queue.push(root)
    let res = 0
    while (queue.length) {
        let len = queue.length

        let newQueue = []
        let curLevel = []
        for (let i = 0; i < len; i++) {
            let cur = queue[i]
            curLevel.push(cur.val)
            if (cur.left) {
                newQueue.push(cur.left)
            }
            if (cur.right) {
                newQueue.push(cur.right)
            }
        }

        res += minSwaps(curLevel)
        queue = newQueue
    }

    return res
};

function minSwaps(arr) {
    let n = arr.length;

    let arrpos = [];
    for (let i = 0; i < n; i++)
        arrpos.push([arr[i], i]);

    arrpos.sort(function (a, b) {
        return a[0] - b[0];
    });

    let uf = new UnionFind(n);
    for (let i = 0; i < n; i++) {
        uf.union(i, arrpos[i][1]);
    }

    return n - uf.getConnectedComponent();
}

class UnionFind {
    constructor(size) {
        this.parent = Array(size);
        this.rank = Array(size);
        for (let i = 0; i < size; i++) {
            this.parent[i] = i;
            this.rank[i] = 1;
        }
    }

    find(p) {
        while (p != this.parent[p]) {
            p = this.parent[p];
        }
        return p;
    }

    isConnected(p, q) {
        return this.find(p) == this.find(q);
    }

    union(p, q) {
        let pRoot = this.find(p);
        let qRoot = this.find(q);
        if (pRoot == qRoot) {
            return;
        }
        if (this.rank[pRoot] < this.rank[qRoot]) {
            this.parent[pRoot] = qRoot;
        } else if (this.rank[qRoot] < this.rank[pRoot]) {
            this.parent[qRoot] = pRoot;
        } else {
            this.parent[pRoot] = qRoot;
            this.rank[qRoot] += 1;
        }
    }

    getConnectedComponent() {
        let res = 0;
        for (let i = 0; i < this.parent.length; i++) {
            if (this.parent[i] == i) {
                res++;
            }
        }
        return res;
    }
}