class Solution:
    def minimumDeletions(self, s: str) -> int:
        n, right_a = len(s), 0
        for c in s:
            if c == 'a':
                right_a += 1

        left_b, res = 0, right_a
        for c in s:
            if c == 'a':
                right_a -= 1
            else:
                left_b += 1
            res = min(res, left_b + right_a)

        return res