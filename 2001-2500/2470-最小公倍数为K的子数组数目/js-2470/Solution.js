/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var subarrayLCM = function (nums, k) {
    let n = nums.length
    let res = 0
    for (let i = 0; i < n; i++) {
        let cur = nums[i]
        if (cur == k) res++
        for (let j = i - 1; j >= 0; j--) {
            cur = lcm(cur, nums[j])
            if (cur == k) {
                res++
            } else if (cur > k) break;
        }

    }
    return res
};

function lcm(x, y) {
    return (x * y) / gcd(x, y);
}

function gcd(x, y) {
    while (y) {
        let t = y;
        y = x % y;
        x = t;
    }
    return x;
}