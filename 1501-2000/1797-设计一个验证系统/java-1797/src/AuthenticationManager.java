import java.util.HashMap;
import java.util.Map;

class AuthenticationManager {

    int timeToLive;
    HashMap<String, Integer> map;
    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        map = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime);
    }

    public void renew(String tokenId, int currentTime) {
        if (map.containsKey(tokenId)) {
            int time = map.get(tokenId);
            if (time + timeToLive > currentTime) {
                map.put(tokenId, currentTime);
            }
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int res = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String token = entry.getKey();
            int time = entry.getValue();
            int curTimeToLive = time + timeToLive;
            if (curTimeToLive > currentTime) {
                res++;
            }
        }
        return res;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */