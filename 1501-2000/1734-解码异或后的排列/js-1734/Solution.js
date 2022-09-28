/**
 * @param {number[]} encoded
 * @return {number[]}
 */
var decode = function(encoded) {
    let n = encoded.length + 1;

    let t = 0;
    for (let i = 1; i <= n; i++) {
        t ^= i;
    }

    for (let i = 1; i < encoded.length; i += 2) {
        t ^= encoded[i];
    }

    let res = Array(n);
    res[0] = t;
    for (let i = 1; i < n; i++) {
        res[i] = res[i - 1] ^ encoded[i - 1];
    }
    return res;
};