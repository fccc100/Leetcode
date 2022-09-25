/**
 * @param {string} s
 * @return {number}
 */
var calculate = function(s) {
    let x = 1, y = 0;

    for (let i = 0; i < s.length; i++) {
        if (s[i] == 'A') {
            x = 2 * x + y;
        } else {
            y = 2 * y + x;
        }
    }
    return x + y;
};