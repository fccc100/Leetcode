/**
 * @param {number[][]} clips
 * @param {number} time
 * @return {number}
 */
var videoStitching = function(clips, time) {
    return solve(clips, time)
};

function solve(intervals, n) {
    let maxRight = Array(n)
    for (let i = 0; i < n; i++) {
        maxRight[i] = i
    }

    for (let i = 0; i < intervals.length; i++) {
        let start = intervals[i][0]
        let end = intervals[i][1]
        maxRight[start] = Math.max(maxRight[start], end)
    }

    let last = 0
    let pre = 0
    let res = 0
    for (let i = 0; i < n; i++) {
        last = Math.max(last, maxRight[i])
        if (i == last) return -1

        if (i == pre) {
            res++
            pre = last
        }
    }
    return res
}