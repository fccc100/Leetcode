/**
 * @param {number} n
 * @param {number[][]} roads
 * @return {number}
 */
var minScore = function (n, roads) {
    let m = roads.length

    let graph = Array(n + 1)

    let dis = []
    for (let i = 0; i <= n; i++) {
        graph[i] = new Set()
        dis[i] = new Map()
    }

    let uf = new UnionFind(n + 1)
    for (let i = 0; i < m; i++) {
        let v1 = roads[i][0]
        let v2 = roads[i][1]
        uf.union(v1, v2)
        graph[v1].add(v2)
        graph[v2].add(v1)

        dis[v1].set(v2, roads[i][2])
        dis[v2].set(v1, roads[i][2])
    }

    let res = Infinity
    for (let i = 1; i < graph.length; i++) {
        if (uf.isConnected(i, n)) {

            for (let k of graph[i]) {
                res = Math.min(res, dis[i].get(k))
            }
        }
    }
    return res
};

class UnionFind {
    constructor(size) {
        this.parent = Array(size);
        this.rank = Array(size);
        for (let i = 0; i < size; i++) {
            this.parent[i] = i;
            this.rank[i] = 1;
        }
    }

    // 查询p的根节点
    find(p) {
        while (p != this.parent[p]) {
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
        } else if (this.rank[qRoot] < this.rank[pRoot]) {
            this.parent[qRoot] = pRoot;
        } else {
            this.parent[pRoot] = qRoot;
            this.rank[qRoot] += 1;
        }
    }
}