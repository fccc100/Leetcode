/**
 * @param {number[]} vals
 * @param {number[][]} edges
 * @param {number} k
 * @return {number}
 */
var maxStarSum = function (vals, edges, k) {
    if (k == 0) {
        vals.sort((a, b) => b - a)
        return vals[0]
    }

    let graph = Array(vals.length)
    for (let i = 0; i < graph.length; i++) {
        graph[i] = new Set()
    }
    for (let i = 0; i < edges.length; i++) {
        graph[edges[i][0]].add(edges[i][1])
        graph[edges[i][1]].add(edges[i][0])
    }

    let map = new Map()
    for (let i = 0; i < graph.length; i++) {
        if (!map.has(i)) {
            map.set(i, [])
        }
        for (let v of graph[i]) {
            map.get(i).push(vals[v])
        }
    }

    let res = -Infinity
    for (let [key, arr] of map) {
        arr.sort((a, b) => b - a)
        let i = 0
        let cur = vals[key]

        while (i < arr.length && i < k && arr[i] > 0) {
            cur += arr[i]
            i++
        }

        res = Math.max(res, cur)
    }
    return res
};