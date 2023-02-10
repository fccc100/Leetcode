class Solution:
    def findDifferentBinaryString(self, nums: List[str]) -> str:
        self.num_set = set()
        self.res = '-1'
        n = len(nums)
        for s in nums:
            self.num_set.add(s)

        self.dfs('', n, 0)
        return self.res

    def dfs(self, s, n, index):
        if index == n:
            if s not in self.num_set:
                self.res = s
                return
            return

        if self.res == '-1':
            self.dfs(s + "0", n, index + 1)
            self.dfs(s + "1", n, index + 1)
