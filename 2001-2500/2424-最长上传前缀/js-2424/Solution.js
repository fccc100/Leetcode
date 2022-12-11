// 并查集
class UnionFind {
    constructor(size) {
        this.parent = Array(size);
        this.size = Array(size);
        this.rank = Array(size);
        for (let i = 0; i < size; i++) {
            this.parent[i] = i;
            this.size[i] = 1;
            this.rank[i] = 1;
        }
    }

    findRoot(p) {
        while (p != this.parent[p]) {
            this.parent[p] = this.parent[this.parent[p]];
            p = this.parent[p];
        }
        return p;
    }

    isConnected(p, q) {
        return this.findRoot(p) == this.findRoot(q);
    }

    union(p, q) {
        let pRoot = this.findRoot(p);
        let qRoot = this.findRoot(q);

        if (pRoot == qRoot) {
            return;
        }

        // 基于rank合并
        let rank = this.rank;
        if (rank[pRoot] < rank[qRoot]) {
            this.parent[pRoot] = qRoot;
            this.size[qRoot] += this.size[pRoot];
        } else if (rank[pRoot] > rank[qRoot]) {
            this.parent[qRoot] = pRoot;
            this.size[pRoot] += this.size[qRoot];
        } else {
            this.parent[pRoot] = qRoot;
            this.size[qRoot] += this.size[pRoot];
            rank[qRoot] += 1;
        }
    }

    get() {
        return this.size[this.findRoot(1)];
    }
}

/**
 * @param {number} n
 */
var LUPrefix = function (n) {
    this.uf = new UnionFind(n + 1);
    this.nums = Array(n + 1).fill(0);
};

/**
 * @param {number} video
 * @return {void}
 */
LUPrefix.prototype.upload = function (video) {
    let nums = this.nums;
    let uf = this.uf;

    nums[video] = 1;
    if (video - 1 >= 1 && nums[video - 1] == 1) {
        uf.union(video, video - 1);
    }
    if (video + 1 < nums.length && nums[video + 1] == 1) {
        uf.union(video, video + 1);
    }
};

/**
 * @return {number}
 */
LUPrefix.prototype.longest = function () {
    if (this.nums[1] == 0) return 0;

    return this.uf.get();
};

/**
 * Your LUPrefix object will be instantiated and called as such:
 * var obj = new LUPrefix(n)
 * obj.upload(video)
 * var param_2 = obj.longest()
 */