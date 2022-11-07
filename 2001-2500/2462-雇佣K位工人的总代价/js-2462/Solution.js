/**
 * @param {number[]} costs
 * @param {number} k
 * @param {number} candidates
 * @return {number}
 */
var totalCost = function (costs, k, candidates) {
    let n = costs.length

    let leftHeap = new MinHeap()
    let l = 0
    while (l < candidates) {
        leftHeap.offer(costs[l])
        l++
    }
    l--

    let rightHeap = new MinHeap()
    let r = n - 1
    while (n - r < candidates + 1) {
        if (r <= l) break
        rightHeap.offer(costs[r])
        r--
    }
    r++

    let res = 0
    while (k > 0) {
        let cur = 0
        if (leftHeap.size() == 0 || rightHeap.size() == 0) {
            if (leftHeap.size() == 0) {
                cur = rightHeap.poll()
            } else {
                cur = leftHeap.poll()
            }
            res += cur
            k--
            continue
        }


        let lMin = leftHeap.peek()
        let rMin = rightHeap.peek()

        if (l >= r) {
            if (lMin > rMin) {
                cur = rightHeap.poll()
            } else {
                cur = leftHeap.poll()
            }
        } else {
            if (lMin > rMin) {
                cur = rightHeap.poll()
                r--
                if (r > l) {
                    rightHeap.offer(costs[r])
                }
            } else {
                cur = leftHeap.poll()
                l++
                if (l < r) {
                    leftHeap.offer(costs[l])
                }
            }
        }

        res += cur
        k--
    }
    return res
};

class MinHeap {
    constructor() {
        this.data = [];
    }

    size() {
        return this.data.length;
    }

    leftChild(index) {
        return 2 * index + 1;
    }

    rightChild(index) {
        return 2 * index + 2;
    }

    parent(index) {
        return (index - 1) >> 1;
    }

    __swap(i, j) {
        let temp = this.data[i];
        this.data[i] = this.data[j];
        this.data[j] = temp;
    }

    // 堆中添加元素
    offer(num) {
        this.data.push(num);
        this.__siftUp(this.size() - 1);
    }

    // 元素上浮
    __siftUp(index) {
        while (index > 0 && this.data[this.parent(index)] > this.data[index]) {
            this.__swap(index, this.parent(index));
            index = this.parent(index);
        }
    }

    // 取出堆顶元素
    poll() {
        let ret = this.data[0];

        this.__swap(0, this.size() - 1);
        this.data.pop();
        this.__siftDown(0);

        return ret;
    }

    __siftDown(index) {
        while (this.leftChild(index) < this.size()) {
            let minIndex = this.leftChild(index);
            let rightIndex = this.rightChild(index);
            if (rightIndex < this.size() && this.data[rightIndex] < this.data[minIndex]) {
                minIndex = rightIndex;
            }
            if (this.data[index] < this.data[minIndex]) {
                break;
            }

            this.__swap(index, minIndex);
            index = minIndex;
        }
    }

    // 查看堆顶元素
    peek() {
        return this.data[0];
    }
}