/**
 * @param {number[][]} grid
 * @return {number}
 */
var minimumVisitedCells = function (grid) {
    let m = grid.length
    let n = grid[0].length

    let dis = Array(m)
    let visited = Array(m)
    for (let i = 0; i < m; i++) {
        dis[i] = Array(n).fill(Infinity)
        visited[i] = Array(n).fill(false)
    }
    dis[0][0] = 1
    let pq = new PriorityQueue1((a, b) => a[2] - b[2])
    pq.offer([0, 0, 1])

    while (!pq.isEmpty()) {
        let cur = pq.poll()
        let i = cur[0]
        let j = cur[1]
        let d = cur[2]

        if (visited[i][j]) continue
        visited[i][j] = true
        if (i == m - 1 && j == n - 1) return d

        for (let k = Math.min(n - 1, grid[i][j] + j); k >= j + 1; k--) {
            if (k <= grid[i][j] + j) {
                if (!visited[i][k] && dis[i][j] + 1 < dis[i][k]) {
                    dis[i][k] = dis[i][j] + 1
                    pq.offer([i, k, dis[i][k]])

                }
            }
        }
        for (let k = Math.min(m - 1, grid[i][j] + i); k >= i + 1; k--) {
            if (k <= grid[i][j] + i) {
                if (!visited[k][j] && dis[i][j] + 1 < dis[k][j]) {
                    dis[k][j] = dis[i][j] + 1
                    pq.offer([k, j, dis[k][j]])
                }
            }
        }
    }

    return dis[m - 1][n - 1] == Infinity ? -1 : dis[m - 1][n - 1]
};

class PriorityQueue1 {
    constructor(comparator = this.__defaultComparator) {
        this.comparator = comparator
        this.data = []
    }

    size() {
        return this.data.length
    }

    isEmpty() {
        return this.size() == 0
    }

    offer(e) {
        this.data.push(e)
        this.__siftUp(this.size() - 1)
    }

    peek() {
        return this.data[0]
    }

    poll() {
        let res = this.peek()
        this.__swap(0, this.size() - 1)
        this.data.pop()
        this.__siftDown(0)
        return res
    }

    __defaultComparator(a, b) {
        return a - b;
    }

    __leftChild(index) {
        return 2 * index + 1
    }

    __rightChild(index) {
        return 2 * index + 2
    }

    __parent(index) {
        return (index - 1) >> 1
    }

    __swap(i, j) {
        let temp = this.data[i]
        this.data[i] = this.data[j]
        this.data[j] = temp
    }

    __siftUp(index) {
        while (index > 0 && this.comparator(this.data[this.__parent(index)], this.data[index]) > 0) {
            this.__swap(index, this.__parent(index))
            index = this.__parent(index)
        }
    }

    __siftDown(index) {
        while (this.__leftChild(index) < this.size()) {
            let targetIndex = this.__leftChild(index)
            let rightIndex = this.__rightChild(index)
            if (rightIndex < this.size() && this.comparator(this.data[rightIndex], this.data[targetIndex]) < 0) {
                targetIndex = rightIndex
            }
            if (this.comparator(this.data[index], this.data[targetIndex]) < 0) {
                break
            }

            this.__swap(index, targetIndex)
            index = targetIndex
        }
    }
}