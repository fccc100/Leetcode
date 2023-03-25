/**
 * @param {string} text
 * @return {number}
 */
var longestDecomposition = function (text) {
    if (!text.length) return 0;
    if (text.length == 1) return 1;

    let head = ''
    let tail = ''
    let l = -1
    let r = text.length
    while (l < r) {
        l++
        head = head + text[l]
        r--
        if (l >= r) break
        tail = text[r] + tail
        if (head == tail) {
            return 2 + longestDecomposition(text.substring(l + 1, r))
        }
    }
    return 1
};