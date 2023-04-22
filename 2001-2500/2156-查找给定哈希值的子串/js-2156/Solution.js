/**
 * @param {string} s
 * @param {number} power
 * @param {number} modulo
 * @param {number} k
 * @param {number} hashValue
 * @return {string}
 */
var subStrHash = function (s, power, modulo, k, hashValue) {
    let n = s.length

    let mod = BigInt(modulo)
    let modP = Array(n + 1).fill(0n)
    modP[0] = 1n
    for (let i = 1; i <= n; i++) {
        modP[i] = (modP[i - 1] * BigInt(power)) % mod
    }

    let hash = 0n
    for (let i = n - 1; i >= n - k; i--) {
        let c = s[i]
        let code = BigInt(c.charCodeAt() - 'a'.charCodeAt() + 1)
        hash = (hash + (code * modP[i - (n - k)]) % mod) % mod
    }

    let l = n - k, r = n - 1
    let res = ''
    if (hash == hashValue) {
        res = s.slice(n - k)
    }
    while (l > 0) {
        let cr = s[r]
        let coder = BigInt(cr.charCodeAt() - 'a'.charCodeAt() + 1)
        hash = (hash - ((coder * modP[k - 1]) % mod) + mod) % mod
        r--

        hash = (hash * BigInt(power)) % mod

        l--
        let cl = s[l]
        let codel = BigInt(cl.charCodeAt() - 'a'.charCodeAt() + 1)
        hash = (hash + (codel * modP[0]) % mod) % mod

        if (hash == hashValue) {
            res = s.substring(l, r + 1)
        }
    }
    return res
}

