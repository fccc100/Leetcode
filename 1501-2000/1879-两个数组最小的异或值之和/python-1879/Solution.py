class Solution:
    def minimumXORSum(self, nums1: List[int], nums2: List[int]) -> int:
        n = len(nums1)
        dp = [float('inf')] * (1 << n)
        dp[0] = 0

        for mask in range(1, len(dp) + 1):
            c = bin(mask).count('1')
            for i in range(n):
                if mask & (1 << i) != 0:
                    dp[mask] = min(dp[mask], dp[mask ^ (1 << i)] + (nums1[c - 1] ^ nums2[i]))
        return dp[(1 << n) - 1]
