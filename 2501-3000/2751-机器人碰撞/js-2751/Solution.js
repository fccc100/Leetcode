/**
 * @param {number[]} positions
 * @param {number[]} healths
 * @param {string} directions
 * @return {number[]}
 */
var survivedRobotsHealths = function (positions, healths, directions) {
    let n = positions.length

    let robs = Array(n)
    for (let i = 0; i < n; i++) {
        robs[i] = [positions[i], healths[i], directions[i], i]
    }

    robs.sort((a, b) => a[0] - b[0])

    let stack = []
    let map = new Map()
    for (let i = 0; i < robs.length; i++) {
        let cr = robs[i]
        if (stack.length == 0) {
            if (cr[2] == 'L') {
                map.set(cr[3], cr[1])
            } else {
                stack.push(cr)
            }
        } else {
            if (cr[2] == 'R') {
                stack.push(cr)
            } else {
                let e = true
                while (stack.length) {
                    let top = stack.pop()

                    if (top[1] == cr[1]) {
                        e = false
                        break
                    } else if (top[1] < cr[1]) {
                        cr[1] -= 1
                    } else if (top[1] > cr[1]) {
                        top[1] -= 1
                        stack.push(top)
                        break
                    }
                }
                if (!stack.length && e) {
                    map.set(cr[3], cr[1])
                }
            }
        }
    }
    for (let i = 0; i < stack.length; i++) {
        let cr = stack[i]
        map.set(cr[3], cr[1])
    }

    let p = []
    for (let entry of map.entries()) {
        p.push(entry)
    }
    p.sort((a, b) => a[0] - b[0])
    let res = []
    for (let i = 0; i < p.length; i++) {
        res.push(p[i][1])
    }
    return res
};