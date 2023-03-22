/**
 * @param {number[]} nums
 * @return {number}
 */
var findScore = function (nums) {
    let n = nums.length
    let pq = new PriorityQueue1((a, b) => {
        if (a[0] - b[0] > 0) {
            return 1
        } else if (a[0] - b[0] < 0) {
            return -1
        } else {
            return a[1] - b[1]
        }
    })

    let visited = Array(n).fill(false)
    for (let i = 0; i < n; i++) {
        pq.offer([nums[i], i])
    }

    let res = 0
    while (!pq.isEmpty()) {
        let t = pq.poll()
        if (visited[t[1]]) continue

        res += t[0]
        let idx = t[1]
        visited[idx] = true
        if (idx - 1 >= 0) {
            visited[idx - 1] = true
        }
        if (idx + 1 < n) {
            visited[idx + 1] = true
        }
    }
    return res
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