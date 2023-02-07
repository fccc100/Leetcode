class Solution:
    def alertNames(self, keyName: List[str], keyTime: List[str]) -> List[str]:
        n, key_map = len(keyName), dict()
        for i in range(n):
            name, time = keyName[i], keyTime[i]
            if name not in key_map:
                key_map[name] = []
            key_map[name].append(time)

        res = []
        for name, timeList in key_map.items():
            if len(timeList) < 3:
                continue
            timeList.sort()
            l, r = 0, 2
            while r < len(timeList):
                prev_hour = int(timeList[l][0:2])
                pre_min = int(timeList[l][3:5])
                cur_hour = int(timeList[r][0:2])
                cur_min = int(timeList[r][3:5])
                if cur_hour == prev_hour:
                    res.append(name)
                    break
                elif cur_hour == prev_hour + 1 and cur_min <= pre_min:
                    res.append(name)
                    break
                else:
                    l += 1
                    r += 1
        res.sort()
        return res