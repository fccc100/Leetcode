/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSumMinProduct = function (nums) {
    let n = nums.length
    let MOD = 1000000007n

    let presum = Array(n).fill(0)
    for (let i = 1; i <= n; i++) {
        presum[i] = presum[i - 1] + nums[i - 1]
    }

    // 以每个值作为最小值，看左边小于它的元素、右边小于它的元素的位置，再用区间和 * 当前值
    let leftMin = Array(n).fill(0)
    let stack = new Stack()
    for (let i = n - 1; i >= 0; i--) {
        if (stack.isEmpty()) {
            stack.push(i)
        } else {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                let top = stack.pop()
                leftMin[top] = i
            }
            stack.push(i)
        }
    }
    while (!stack.isEmpty()) {
        leftMin[stack.pop()] = -1
    }

    let rightMin = Array(n).fill(0)
    stack.clear()
    for (let i = 0; i < n; i++) {
        if (stack.isEmpty()) {
            stack.push(i)
        } else {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                let top = stack.pop()
                rightMin[top] = i
            }
            stack.push(i)
        }
    }

    while (!stack.isEmpty()) {
        rightMin[stack.pop()] = n
    }

    let res = 0n
    for (let i = 0; i < n; i++) {
        let l = leftMin[i]
        let r = rightMin[i]
        let sum = presum[r] - presum[l + 1]
        let pro = BigInt(nums[i]) * BigInt(sum)
        if (pro > res) res = pro
    }
    return res % MOD
}

class Stack {
    constructor() {
        this.data = []
    }

    isEmpty() {
        return this.data.length == 0
    }

    size() {
        return this.data.length
    }

    push(val) {
        this.data.push(val)
    }

    pop() {
        if (this.isEmpty()) {
            throw new Error('stack is empty.')
        }
        return this.data.pop()
    }

    peek() {
        if (this.isEmpty()) {
            throw new Error('stack is empty.')
        }
        return this.data[this.data.length - 1]
    }

    clear() {
        this.data = []
    }
}