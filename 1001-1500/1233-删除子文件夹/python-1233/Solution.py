class Solution:
    def removeSubfolders(self, folder: List[str]) -> List[str]:
        n, res = len(folder), []
        folder.sort()

        res.append(folder[0])
        prev_idx = 0
        for i in range(1, n):
            s = folder[i]
            prev = folder[prev_idx]
            if s.startswith(prev) and s[len(prev)] == '/':
                pass
            else:
                res.append(s)
                prev_idx = i
        return res