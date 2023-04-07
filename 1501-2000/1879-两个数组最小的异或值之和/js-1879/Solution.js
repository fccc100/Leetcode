/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var minimumXORSum = function (nums1, nums2) {
    let n = nums1.length

    let dp = Array(1 << n).fill(Infinity)
    dp[0] = 0
    for (let mask = 1; mask < 1 << n; mask++) {
        let c = bitCount(mask)
        for (let i = 0; i < n; i++) {
            if ((mask & (1 << i)) != 0) {
                dp[mask] = Math.min(dp[mask], dp[mask ^ (1 << i)] + (nums1[c - 1] ^ nums2[i]))
            }
        }
    }
    return dp[(1 << n) - 1]
};

function bitCount(n) {
    let res = 0
    while (n > 0) {
        n &= (n - 1)
        res++
    }
    return res
}