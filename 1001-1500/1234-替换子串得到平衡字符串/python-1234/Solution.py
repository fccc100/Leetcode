class Solution:
    def balancedString(self, s: str) -> int:
        n, cnt = len(s), [0] * 4
        for c in s:
            if c == 'Q':
                cnt[0] += 1
            if c == 'W':
                cnt[1] += 1
            if c == 'E':
                cnt[2] += 1
            if c == 'R':
                cnt[3] += 1
        if cnt[0] == cnt[1] and cnt[1] == cnt[2] and cnt[2] == cnt[3]:
            return 0
        avg = (cnt[0] + cnt[1] + cnt[2] + cnt[3]) // 4
        l, r, res = 0, -1, n + 1
        while l < n:
            if max(cnt) > avg:
                r += 1
                if r >= n:
                    break
                c = s[r]
                if c == 'Q':
                    cnt[0] -= 1
                if c == 'W':
                    cnt[1] -= 1
                if c == 'E':
                    cnt[2] -= 1
                if c == 'R':
                    cnt[3] -= 1
            else:
                res, c = min(res, r - l + 1), s[l]
                if c == 'Q':
                    cnt[0] += 1
                if c == 'W':
                    cnt[1] += 1
                if c == 'E':
                    cnt[2] += 1
                if c == 'R':
                    cnt[3] += 1
                l += 1
        return res
