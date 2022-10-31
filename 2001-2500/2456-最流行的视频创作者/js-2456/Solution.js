/**
 * @param {string[]} creators
 * @param {string[]} ids
 * @param {number[]} views
 * @return {string[][]}
 */
var mostPopularCreator = function (creators, ids, views) {
    let n = creators.length

    let map = new Map()
    let max = -1

    let maxMap = new Map()
    for (let i = 0; i < n; i++) {
        let c = creators[i]
        if (!map.has(c)) {
            map.set(c, views[i])
            maxMap.set(c, i)
        } else {
            map.set(c, map.get(c) + views[i])

            if (views[i] > views[maxMap.get(c)]) {
                maxMap.set(c, i)
            }
            if (views[i] == views[maxMap.get(c)]) {
                if (ids[i] < ids[maxMap.get(c)]) {
                    maxMap.set(c, i)
                }
            }
        }
        max = Math.max(max, map.get(c))
    }

    let maxC = []
    for (let [key, val] of map) {
        if (val == max) {
            maxC.push(key)
        }
    }

    let res = []
    for (let i = 0; i < maxC.length; i++) {
        res.push([maxC[i], ids[maxMap.get(maxC[i])]])
    }
    return res
};