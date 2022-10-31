/**
 * @param {number} n
 * @param {number} target
 * @return {number}
 */
var makeIntegerBeautiful = function (n, target) {

    if (sum(n) <= target) {
        return 0
    } else {
        let t = 10
        let temp = n
        while (sum(temp) > target) {
            let m = t - (n % t)
            temp = (Math.floor(n / t) + 1) * 10

            if (sum(temp) <= target) {
                return m
            } else {
                temp = n
                t *= 10
            }
        }
    }
};

function sum(n) {
    let s = String(n)
    let res = 0
    for (let i = 0; i < s.length; i++) {
        res += Number(s[i])
    }
    return res
}