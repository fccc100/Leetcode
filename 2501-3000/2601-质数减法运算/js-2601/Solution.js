function solvePrimes(n) {
    let isPrime = Array(n).fill(1)
    for (let i = 0; i < 2; i++) {
        isPrime[i] = 0
    }

    for (let i = 2; i < n; i++) {
        // 从2开始遍历，每遍历到一个数i，则 从j = i * i开始， 每增加一次i，都标记为非质数
        // 为什么可以从i * i开始， 因为 i 乘 [1, i - 1]的情况在处理前面的i时就已经标记过了
        if (isPrime[i] == 1) {
            for (let j = i * i; j < n; j += i) {
                isPrime[j] = 0
            }
        }
    }
    return isPrime
}

/**
 * @param {number[]} nums
 * @return {boolean}
 */
var primeSubOperation = function (nums) {
    let n = nums.length
    let isPrime = solvePrimes(1001)
    let primes = []
    for (let i = 0; i < isPrime.length; i++) {
        if (isPrime[i] == 1) {
            primes.push(i)
        }
    }

    let p0 = -1
    for (let i = 0; i < primes.length; i++) {
        if (primes[i] >= nums[0]) {
            break
        }
        p0 = primes[i]
    }
    if (p0 > -1) {
        nums[0] -= p0
    }


    for (let i = 1; i < n; i++) {
        let cur = nums[i]

        let p = -1
        for (let j = 0; j < primes.length; j++) {
            if (cur - primes[j] > nums[i - 1]) {
                p = primes[j]
            } else {
                break
            }
        }
        if (p == -1 && nums[i] <= nums[i - 1]) return false
        if (p > -1) {
            nums[i] -= p
        }
    }

    return true
};