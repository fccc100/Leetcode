import java.util.*;

class FindItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, Integer> strToId = new HashMap<>();
        HashMap<Integer, String> idToStr = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < tickets.size(); i++) {
            String a = tickets.get(i).get(0);
            String b = tickets.get(i).get(1);
            if (!strToId.containsKey(a)) {
                strToId.put(a, cnt);
                idToStr.put(cnt, a);
                cnt++;
            }
            if (!strToId.containsKey(b)) {
                strToId.put(b, cnt);
                idToStr.put(cnt, b);
                cnt++;
            }
        }

        ArrayList<Integer>[] graph = new ArrayList[cnt];
        for (int i = 0; i < cnt; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < tickets.size(); i++) {
            int a = strToId.get(tickets.get(i).get(0));
            int b = strToId.get(tickets.get(i).get(1));
            graph[a].add(b);
        }

        List<String> res = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while (!stack.isEmpty()) {
            String curV = stack.peek();
            int id = strToId.get(curV);
            if (!graph[id].isEmpty()) {
                List<Integer> keys = graph[id];
                String w = idToStr.get(keys.get(0));
                int idx = 0;
                for (int i = 0; i < keys.size(); i++) {
                    if (idToStr.get(keys.get(i)).compareTo(w) < 0) {
                        w = idToStr.get(keys.get(i));
                        idx = i;
                    }
                }
                graph[id].remove(idx);
                stack.push(w);
            } else {
                res.add(stack.pop());
            }
        }
        Collections.reverse(res);
        return res;
    }
}