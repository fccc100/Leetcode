/**
 * @param {number[]} arr
 * @return {number}
 */
var trimMean = function(arr) {
    let n = arr.length;
    arr.sort((a, b) => a - b)

    let cnt = parseInt(n * 0.05);
    let sum = 0;
    for (let i = cnt; i < n - cnt; i++) {
        sum += arr[i];
    }
    return sum / (n - cnt - cnt);
};