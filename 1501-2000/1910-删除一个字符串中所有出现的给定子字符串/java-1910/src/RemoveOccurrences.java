import java.util.HashSet;

class RemoveOccurrences {
    public String removeOccurrences(String s, String part) {
        while (s.indexOf(part) > -1) {
            int idx = s.indexOf(part);
            s = s.substring(0, idx) + s.substring(idx + part.length());
        }

        return s;
    }
}