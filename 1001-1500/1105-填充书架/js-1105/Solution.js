/**
 * @param {number[][]} books
 * @param {number} shelfWidth
 * @return {number}
 */
var minHeightShelves = function (books, shelfWidth) {
    let n = books.length

    let dp = Array(n + 1).fill(Infinity)
    dp[0] = 0
    for (let i = 0; i < n; i++) {
        let maxHeight = 0, curWidth = 0
        for (let j = i; j >= 0; j--) {
            curWidth += books[j][0]
            if (curWidth <= shelfWidth) {
                maxHeight = Math.max(maxHeight, books[j][1])
                dp[i + 1] = Math.min(dp[i + 1], dp[j] + maxHeight)
            } else break
        }
    }
    return dp[n]
}