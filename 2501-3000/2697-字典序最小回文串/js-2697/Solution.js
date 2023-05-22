/**
 * @param {string} s
 * @return {string}
 */
var makeSmallestPalindrome = function (s) {
    let n = s.length

    let map = new Map()
    let l = 0
    let r = n - 1
    while (l < r) {
        if (s[l] == s[r]) {
            l++
            r--
        } else {
            if (s[l] < s[r]) {
                map.set(r, s[l])
            } else {
                map.set(l, s[r])
            }
            l++
            r--
        }
    }
    let res = ''
    for (let i = 0; i < n; i++) {
        if (!map.has(i)) {
            res += s[i]
        } else {
            res += map.get(i)
        }
    }
    return res
};