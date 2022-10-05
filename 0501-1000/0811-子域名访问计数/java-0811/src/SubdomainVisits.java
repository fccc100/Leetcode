import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class SubdomainVisits {
    public List<String> subdomainVisits(String[] cpdomains) {
        int n = cpdomains.length;
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String cur = cpdomains[i];

            String[] arr = cur.split(" ");
            int cnt = Integer.valueOf(arr[0]);
            String mail = arr[1];

            String[] mailStrs = mail.split("\\.");
            String curMail = "";

            for (int j = mailStrs.length - 1; j >= 0; j--) {
                curMail = mailStrs[j] + curMail;
                map.put(curMail, map.getOrDefault(curMail, 0) + cnt);
                curMail = "." + curMail;
            }
        }

        ArrayList<String> res = new ArrayList<>();
        for (String s : map.keySet()) {
            StringBuilder cur = new StringBuilder();
            int cnt = map.get(s);
            cur.append(cnt);
            cur.append(" ");
            cur.append(s.toString());
            res.add(cur.toString());
        }
        return res;
    }
}