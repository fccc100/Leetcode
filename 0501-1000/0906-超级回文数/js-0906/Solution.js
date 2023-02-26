/**
 * @param {string} left
 * @param {string} right
 * @return {number}
 */
var superpalindromesInRange = function (left, right) {
    let res = 0
    for (let i = 1; i <= 100000; i++) {
        let o = String(i)
        let t1 = o
        for (let j = o.length - 1; j >= 0; j--) {
            t1 += o[j]
        }
        let m1 = BigInt(Number(t1)) * BigInt(Number(t1))

        if (m1 >= Number(left) && m1 <= Number(right) && isValid(m1)) {
            res++
        }
        let t2 = o
        for (let j = o.length - 2; j >= 0; j--) {
            t2 += o[j]
        }

        let m2 = BigInt(Number(t2)) * BigInt(Number(t2))
        if (m2 > Number(right)) break
        if (m2 >= Number(left) && isValid(m2)) {
            res++
        }
    }
    return res
};

function isValid(n) {
    let s = String(n)
    let l = 0
    let r = s.length - 1
    while (l < r) {
        if (s[l] != s[r]) return false
        l++
        r--
    }
    return true
}