/**
 * @param {string} s
 * @return {number}
 */
var findTheLongestBalancedSubstring = function (s) {
    let n = s.length
    let res = 0
    for (let i = 0; i < n; i++) {
        if (s[i] == 1) continue
        let zCnt = 1
        let oneCnt = 0
        for (let j = i + 1; j < n; j++) {
            if (s[j] == 0) {
                if (oneCnt > 0) {
                    break
                }
                zCnt++
            } else {
                oneCnt++
            }
            if (oneCnt == zCnt) {
                res = Math.max(res, j - i + 1)
            }
        }
    }
    return res
};