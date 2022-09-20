/**
 * @param {string[]} words
 * @return {number}
 */
var maxProduct = function (words) {
    let n = words.length;

    let masks = Array(n).fill(0);

    for (let i = 0; i < n; i++) {
        let word = words[i];

        for (let j = 0; j < word.length; j++) {
            masks[i] |= (1 << word[j].charCodeAt() - 'a'.charCodeAt());
        }
    }

    let res = 0;
    for (let i = 0; i < n; i++) {
        for (let j = i + 1; j < n; j++) {
            if ((masks[i] & masks[j]) == 0) {
                res = Math.max(res, words[i].length * words[j].length);
            }
        }
    }
    return res;
};