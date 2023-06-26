/**
 * @param {number[]} nums
 * @return {number}
 */
var countBeautifulPairs = function (nums) {
    let n = nums.length
    let res = 0
    for (let i = 0; i < n; i++) {
        let s1 = String(nums[i])
        for (let j = i + 1; j < n; j++) {
            let s2 = String(nums[j])

            if (gcd(Number(s1[0]), Number(s2[s2.length - 1])) == 1) {
                res++
            }
        }
    }
    return res
};

function gcd(x, y) {
    if (y == 0) return x;

    return gcd(y, x % y);
}