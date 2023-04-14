/**
 * @param {number[]} nums
 * @return {number[]}
 */
var replaceNonCoprimes = function (nums) {
    let n = nums.length

    let stack = []
    for (let i = 0; i < n; i++) {
        let x = nums[i]
        if (!stack.length) {
            stack.push(x)
        } else {
            stack.push(x)
            while (stack.length > 1) {
                let top1 = stack[stack.length - 1]
                let top2 = stack[stack.length - 2]
                let gcdVal = gcd(top1, top2)
                if (gcdVal <= 1) break
                stack.pop()
                stack.pop()
                stack.push((top1 * top2) / gcdVal)
            }
        }
    }
    return stack
}

function gcd(x, y) {
    if (y == 0) return x;

    return gcd(y, x % y);
}