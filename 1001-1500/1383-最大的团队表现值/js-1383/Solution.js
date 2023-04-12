/**
 * @param {number} n
 * @param {number[]} speed
 * @param {number[]} efficiency
 * @param {number} k
 * @return {number}
 */
var maxPerformance = function (n, speed, efficiency, k) {
    let p = Array(n)
    let MOD = BigInt(1e9 + 7)
    for (let i = 0; i < n; i++) {
        p[i] = [speed[i], efficiency[i]]
    }

    let pq = new PriorityQueue1((a, b) => a[0] - b[0])

    p.sort((a, b) => b[1] - a[1])

    let sum = 0n, res = 0n
    for (let i = 0; i < n; i++) {
        sum += BigInt(p[i][0])
        let cur = sum * BigInt(p[i][1])
        if (cur > res) res = cur
        pq.offer(p[i])
        if (pq.size() == k) {
            sum -= BigInt(pq.poll()[0])
        }
    }
    return res % MOD
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