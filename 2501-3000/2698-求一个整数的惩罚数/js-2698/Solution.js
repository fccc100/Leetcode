/**
 * @param {number} n
 * @return {number}
 */
var punishmentNumber = function (n) {

    let res = 0
    for (let i = 1; i <= n; i++) {
        let s = String(i * i)

        if (check(s, i)) {
            res += i * i
        }
    }

    return res
};
function check(s, t) {

    if (Number(s) == Number(t)) {
        return true
    }

    function f(s, c, t, idx) {
        if (idx >= s.length && c == t) {
            return true
        }
        if (c > t) return false
        if (idx > s.length) return false

        let res = false
        for (let i = idx; i < s.length; i++) {
            let m = s.substring(idx, i + 1)
            if (Number(m) <= t) {
                res = res || f(s, c + Number(m), t, i + 1)
            }
        }
        return res
    }
    return f(s, 0, t, 0)
}