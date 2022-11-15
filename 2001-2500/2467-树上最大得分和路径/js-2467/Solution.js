/**
 * @param {number[][]} edges
 * @param {number} bob
 * @param {number[]} amount
 * @return {number}
 */
var mostProfitablePath = function (edges, bob, amount) {
    let n = edges.length

    let graph = Array(n + 1)
    for (let i = 0; i < graph.length; i++) {
        graph[i] = new Set()
    }

    for (let i = 0; i < n; i++) {
        graph[edges[i][0]].add(edges[i][1])
        graph[edges[i][1]].add(edges[i][0])
    }

    let queue = []
    let bStep = Array(n + 1).fill(0)
    let bVisited = Array(n + 1).fill(false)
    queue.push([bob, 0])
    bVisited[bob] = true
    let paths = Array(n + 1).fill(-1)
    paths[bob] = bob
    while (queue.length) {
        let len = queue.length
        let newQueue = []
        for (let i = 0; i < len; i++) {
            let cur = queue[i]
            let p = cur[0]
            if (p == 0) break

            for (let v of graph[p]) {
                if (!bVisited[v]) {
                    bStep[v] = cur[1] + 1
                    paths[v] = p
                    bVisited[v] = true
                    newQueue.push([v, cur[1] + 1])
                }
            }
        }
        queue = newQueue
    }
    let vSet = new Set()
    let cur = 0
    vSet.add(cur)
    while (paths[cur] != bob) {
        cur = paths[cur]
        vSet.add(cur)
    }
    vSet.add(bob)

    for (let i = 0; i < paths.length; i++) {
        if (!vSet.has(i)) {
            paths[i] = -1
        }
    }

    let res = -Infinity
    let aVisited = Array(n + 1).fill(false)
    queue = []
    queue.push([0, 0, amount[0]])
    aVisited[0] = true
    while (queue.length) {
        let len = queue.length
        let newQueue = []
        for (let i = 0; i < len; i++) {
            let cur = queue[i]

            let hasChild = false
            for (let v of graph[cur[0]]) {
                if (!aVisited[v]) {
                    hasChild = true
                    let s
                    if (paths[v] == -1) {
                        s = amount[v]
                    } else {
                        if (cur[1] + 1 < bStep[v]) {
                            s = amount[v]
                        } else if (cur[1] + 1 == bStep[v]) {
                            s = amount[v] / 2
                        } else {
                            s = 0
                        }
                    }

                    newQueue.push([v, cur[1] + 1, cur[2] + s])
                    aVisited[v] = true
                }
            }
            if (!hasChild) {
                res = Math.max(res, cur[2])
            }

        }
        queue = newQueue
    }
    return res
};