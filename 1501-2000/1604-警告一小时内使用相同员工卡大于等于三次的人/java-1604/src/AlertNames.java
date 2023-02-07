import java.util.*;

class AlertNames {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        int n = keyName.length;
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = keyName[i];
            String time = keyTime[i];
            if (!map.containsKey(name)) {
                map.put(name, new ArrayList<String>());
            }
            map.get(name).add(time);
        }

        List<String> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String name = entry.getKey();
            List<String> timeList = entry.getValue();
            if (timeList.size() < 3) continue;
            Collections.sort(timeList);

            int l = 0, r = 2;
            while (r < timeList.size()) {
                String[] prev = timeList.get(l).split(":");
                int preHour = Integer.valueOf(prev[0]);
                int preMin = Integer.valueOf(prev[1]);
                String[] cur = timeList.get(r).split(":");
                int curHour = Integer.valueOf(cur[0]);
                int curMin = Integer.valueOf(cur[1]);
                if (curHour == preHour) {
                    res.add(name);
                    break;
                } else if (curHour == preHour + 1 && curMin <= preMin) {
                    res.add(name);
                    break;
                } else {
                    l++;
                    r++;
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}
