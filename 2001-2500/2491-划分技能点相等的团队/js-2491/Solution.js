/**
 * @param {number[]} skill
 * @return {number}
 */
var dividePlayers = function (s) {
    let n = s.length

    s.sort((a, b) => a - b)
    if (n % 2 == 1) return -1

    let res = 0
    let l = 0
    let r = n - 1

    let sum = s[l] + s[r]
    while (l < r) {
        let ll = s[l]
        let rr = s[r]

        if (ll + rr != sum) {
            return -1
        }
        res += (ll * rr)
        l++
        r--
    }
    return res
};