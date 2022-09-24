/**
 * @param {number[]} code
 * @param {number} k
 * @return {number[]}
 */
var decrypt = function(code, k) {
    let n = code.length;
    let res = Array(n).fill(0);
    if (k == 0) {
        return res;
    } else if (k > 0) {
        for (let i = 0; i < n; i++) {
            let sum = 0;
            let temp = k;
            for (let j = (i + 1 >= n ? 0 : i + 1); temp > 0; temp --) {
                sum += code[j];
                j = (j + 1) % n;
            }

            res[i] = sum;
        }
        return res;
    } else {
        for (let i = 0; i < n; i++) {
            let sum = 0;
            let temp = k;
            for (let j = (i - 1 < 0 ? n - 1 : i - 1); temp < 0; temp++) {
                sum += code[j];
                j = (j - 1 + n) % n;
            }
            res[i] = sum;
        }
        return res;
    }
};