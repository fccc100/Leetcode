/**
 * @param {number} x
 * @param {number} y
 * @return {number}
 */
var hammingDistance = function(x, y) {
    let s1 = getBit(x);
    let s2 = getBit(y);

    let res = 0;
    for (let i = 0; i < s1.length; i++) {
        if (s1[i] != s2[i]) {
            res++;
        }
    }
    return res;
};

function getBit(n) {
    let res = '';
    for (let i = 31; i >= 0; i--) {
        res += (n & (1 << i)) == 0 ? '0' : '1';
    }
    return res;
}