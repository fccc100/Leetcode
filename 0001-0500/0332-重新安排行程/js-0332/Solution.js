/**
 * @param {string[][]} tickets
 * @return {string[]}
 */
var findItinerary = function (tickets) {
    let strToId = new Map()
    let idToStr = new Map()

    let cnt = 0
    for (let i = 0; i < tickets.length; i++) {
        let a = tickets[i][0]
        let b = tickets[i][1]
        if (!strToId.has(a)) {
            strToId.set(a, cnt)
            idToStr.set(cnt, a)
            cnt++
        }
        if (!strToId.has(b)) {
            strToId.set(b, cnt)
            idToStr.set(cnt, b)
            cnt++
        }
    }

    let graph = Array(cnt)
    for (let i = 0; i < cnt; i++) {
        graph[i] = []
    }

    for (let i = 0; i < tickets.length; i++) {
        let a = tickets[i][0]
        let b = tickets[i][1]
        graph[strToId.get(a)].push(strToId.get(b))
    }

    let res = []
    let stack = []
    stack.push('JFK')
    while (stack.length) {
        let curV = stack[stack.length - 1]
        let id = strToId.get(curV)
        if (graph[id].length != 0) {
            let keys = graph[id]
            let w = idToStr.get(keys[0])
            let idx = 0
            for (let i = 0; i < keys.length; i++) {
                if (idToStr.get(keys[i]) < w) {
                    w = idToStr.get(keys[i])
                    idx = i
                }
            }
            graph[id].splice(idx, 1)
            stack.push(w)
        } else {
            res.push(stack.pop())
        }
    }
    return res.reverse()
};