/**
 * @param {number[]} weights
 * @param {number} k
 * @return {number}
 */
var putMarbles = function (weights, k) {
    let n = weights.length

    let cnt = k - 1
    let pq1 = new PriorityQueue1()
    let pq2 = new PriorityQueue1((a, b) => b - a)

    for (let i = 1; i < n; i++) {
        let x = weights[i - 1]
        let y = weights[i]
        pq1.offer(x + y)
        pq2.offer(x + y)
    }
    let min = weights[0] + weights[n - 1]

    while (cnt > 0) {
        min += pq1.poll()
        cnt--
    }
    let max = weights[0] + weights[n - 1]
    cnt = k - 1

    while (cnt > 0) {
        max += pq2.poll()
        cnt--
    }

    return max - min
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