/**
 * @param {number[][]} pairs
 * @return {number[][]}
 */
var validArrangement = function(pairs) {
    let graph = new Map()
    let degree = new Map()
    for (let i = 0; i < pairs.length; i++) {
        let x = pairs[i][0]
        let y = pairs[i][1]
        if (!graph.has(x)) {
            graph.set(x, [])
        }
        graph.get(x).push(y)

        if (!degree.has(x)) {
            degree.set(x, [0, 0])
        }
        degree.get(x)[0]++
        if (!degree.has(y)) {
            degree.set(y, [0, 0])
        }
        degree.get(y)[1]++
    }

    let start = pairs[0][0]
    for (let entry of degree.entries()) {
        let v = entry[0]
        let [outdegree, indegree] = entry[1]
        if (outdegree - indegree == 1) {
            start = v
            break
        }
    }

    let res = []
    let stack = []
    stack.push(start)
    while (stack.length) {
        let curV = stack[stack.length - 1]
        if (graph.has(curV) && graph.get(curV).length != 0) {
            let edges = graph.get(curV)
            let w = edges[edges.length - 1]
            edges.pop()
            stack.push(w)
        } else {
            res.push(stack.pop())
        }
    }

    let ans = []
    res.reverse()
    for (let i = 0; i < res.length - 1; i++) {
        ans.push([res[i], res[i + 1]])
    }
    return ans
};