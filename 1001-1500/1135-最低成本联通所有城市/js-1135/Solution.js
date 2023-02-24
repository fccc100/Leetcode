/**
 * @param {number} n
 * @param {number[][]} connections
 * @return {number}
 */
var minimumCost = function(n, connections) {
    let res = kruskal(connections, n + 1)
    if (res.length < n - 1) return -1
    let sum = 0
    for (let i = 0; i < res.length; i++) {
        sum += res[i][2]
    }
    return sum
};

function kruskal(edges, n) {
    let res = []
    edges.sort((a, b) => a[2] - b[2])
    let uf = new UnionFind(n)
    for (let i = 0; i < edges.length; i++) {
        let v1 = edges[i][0]
        let v2 = edges[i][1]
        if (!uf.isConnected(v1, v2)) {
            res.push(edges[i])
            uf.union(v1, v2)
        }
    }
    return res
}

class UnionFind {
    constructor(n) {
        this.parent = Array(n);
        this.rank = Array(n);
        this.size = Array(n);
        for (let i = 0; i < n; i++) {
            this.parent[i] = i;
            this.rank[i] = 1;
            this.size[i] = 1;
        }
    }

    // 查询p的根节点
    find(p) {
        while (p != this.parent[p]) {
            this.parent[p] = this.parent[this.parent[p]];
            p = this.parent[p];
        }
        return p;
    }

    // 判断p q是否联通
    isConnected(p, q) {
        return this.find(p) == this.find(q);
    }

    // 合并
    union(p, q) {
        let pRoot = this.find(p);
        let qRoot = this.find(q);
        if (pRoot == qRoot) {
            return;
        }
        if (this.rank[pRoot] < this.rank[qRoot]) {
            this.parent[pRoot] = qRoot;
            this.size[qRoot] += this.size[pRoot];
        } else if (this.rank[qRoot] < this.rank[pRoot]) {
            this.parent[qRoot] = pRoot;
            this.size[pRoot] += this.size[qRoot];
        } else {
            this.parent[pRoot] = qRoot;
            this.rank[qRoot] += 1;
            this.size[qRoot] += this.size[pRoot];
        }
    }
}