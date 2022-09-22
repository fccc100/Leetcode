/**
 * @param {string} s
 * @return {string}
 */
var replaceSpace = function(s) {
    let arr = s.split('');

    for (let i = 0; i < arr.length; i++) {
        if (arr[i] == ' ') {
            arr[i] = '%20';
        }
    }
    return arr.join('');
};