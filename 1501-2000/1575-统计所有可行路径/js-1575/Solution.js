/**
 * @param {number[]} locations
 * @param {number} start
 * @param {number} finish
 * @param {number} fuel
 * @return {number}
 */
var countRoutes = function (locations, start, finish, fuel) {
    let n = locations.length
    let MOD = 1e9 + 7

    let memo = Array(n)
    for (let i = 0; i < n; i++) {
        memo[i] = Array(fuel + 1).fill(-1)
    }
    function f(locations, idx, fuel) {
        if (fuel < 0) return 0

        if (memo[idx][fuel] != -1) {
            return memo[idx][fuel]
        }

        let res = 0
        if (idx == finish) {
            res += 1
        }

        for (let i = 0; i < n; i++) {
            if (i != idx) {
                if (Math.abs(locations[i] - locations[idx]) <= fuel) {
                    res += f(locations, i, fuel - Math.abs(locations[i] - locations[idx]))
                    res %= MOD
                }
            }
        }
        return memo[idx][fuel] = res % MOD
    }

    return f(locations, start, fuel)
};