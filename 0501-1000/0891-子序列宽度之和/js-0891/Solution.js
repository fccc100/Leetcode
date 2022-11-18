/**
 * @param {number[]} nums
 * @return {number}
 */
var sumSubseqWidths = function(nums) {
    let n = nums.length;
    let mod = 1000000007n;

    nums.sort((a, b) => a - b);
    let res = BigInt(0);

    let pow2 = Array(n);
    pow2[0] = BigInt(1);
    for (let i = 1; i < n; i++) {
        pow2[i] = pow2[i - 1] * BigInt(2) % mod;
    }
    for (let i = 0; i < n; i++) {
        res += (pow2[i] - pow2[n - 1 - i]) * BigInt(nums[i]);
    }

    return (res % mod + mod) % mod;
};