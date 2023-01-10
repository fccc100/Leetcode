/**
 * @param {string} word1
 * @param {string} word2
 * @return {boolean}
 */
var isItPossible = function (word1, word2) {
    let m = word1.length
    let n = word2.length

    let map1 = Array(26).fill(0)
    for (let i = 0; i < m; i++) {
        map1[word1[i].charCodeAt() - 'a'.charCodeAt()]++
    }

    let map2 = Array(26).fill(0)
    for (let i = 0; i < n; i++) {
        map2[word2[i].charCodeAt() - 'a'.charCodeAt()]++
    }

    for (let i = 0; i < map1.length; i++) {
        for (let j = 0; j < map2.length; j++) {
            if (map1[i] > 0 && map2[j] > 0) {
                map1[i]--
                map1[j]++
                map2[i]++
                map2[j]--
                if (check(map1, map2)) {
                    return true
                }
                map1[i]++
                map1[j]--
                map2[i]--
                map2[j]++
            }
        }
    }
    return false
};

function check(m1, m2) {
    let c1 = 0
    let c2 = 0
    for (let i = 0; i < m1.length; i++) {
        if (m1[i] > 0) c1++
        if (m2[i] > 0) c2++
    }
    return c1 == c2
}