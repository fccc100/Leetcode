/**
 * @param {number[]} cont
 * @return {number[]}
 */
var fraction = function(cont) {
    let n = cont.length;
    if (n == 0) return [0, 0];
    if (n == 1) return [cont[0], 1];

    let res = [1, cont[n - 1]];
    for (let i = n - 2; i >= 0; i--) {
        res[0] = res[0] + res[1] * cont[i];

        if (i > 0) {
            let temp = res[0];
            res[0] = res[1];
            res[1] = temp;
        }
    }

    return res;
};