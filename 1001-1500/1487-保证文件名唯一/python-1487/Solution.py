class Solution:
    def getFolderNames(self, names: List[str]) -> List[str]:
        n, res, name_set, min_idx = len(names), [], set(), dict()
        for i in range(n):
            if names[i] not in name_set:
                name_set.add(names[i])
                res.append(names[i])
            else:
                idx = 1 if names[i] not in min_idx else min_idx.get(names[i])
                while (names[i] + "(" + str(idx) + ")") in name_set:
                    idx += 1
                s = names[i] + "(" + str(idx) + ")"
                name_set.add(s)
                min_idx[names[i]] = idx + 1
                res.append(s)
        return res