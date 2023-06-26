import java.util.*;

class Solution {
    class Robot {
        private int pos;
        private int heal;
        private char dir;
        private int idx;

        public Robot(int pos, int heal, char dir, int idx) {
            this.pos = pos;
            this.heal = heal;
            this.dir = dir;
            this.idx = idx;
        }

        public int getPos() {
            return pos;
        }

        public void setPos(int pos) {
            this.pos = pos;
        }

        public int getHeal() {
            return heal;
        }

        public void setHeal(int heal) {
            this.heal = heal;
        }

        public char getDir() {
            return dir;
        }

        public void setDir(char dir) {
            this.dir = dir;
        }

        public int getIdx() {
            return idx;
        }

        public void setIdx(int idx) {
            this.idx = idx;
        }
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Robot[] robs = new Robot[n];
        for (int i = 0; i < n; i++) {
            robs[i] = new Robot(positions[i], healths[i], directions.charAt(i), i);
        }

        Arrays.sort(robs, (a, b) -> a.getPos() - b.getPos());

        Deque<Robot> stack = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < robs.length; i++) {
            Robot cr = robs[i];
            if (stack.isEmpty()) {
                if (cr.getDir() == 'L') {
                    map.put(cr.getIdx(), cr.getHeal());
                } else {
                    stack.push(cr);
                }
            } else {
                if (cr.getDir() == 'R') {
                    stack.push(cr);
                } else {
                    boolean e = true;
                    while (!stack.isEmpty()) {
                        Robot top = stack.pop();

                        if (top.getHeal() == cr.getHeal()) {
                            e = false;
                            break;
                        } else if (top.getHeal() < cr.getHeal()) {
                            cr.setHeal(cr.getHeal() - 1);
                        } else if (top.getHeal() > cr.getHeal()) {
                            top.setHeal(top.getHeal() - 1);
                            stack.push(top);
                            break;
                        }
                    }
                    if (stack.isEmpty() && e) {
                        map.put(cr.getIdx(), cr.getHeal());
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            Robot cr = stack.pop();
            map.put(cr.getIdx(), cr.getHeal());
        }

        List<List<Integer>> p = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            List<Integer> cur = new ArrayList<>();
            cur.add(entry.getKey());
            cur.add(entry.getValue());
            p.add(cur);
        }

        Collections.sort(p, (a, b) -> a.get(0) - b.get(0));
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < p.size(); i++) {
            res.add(p.get(i).get(1));
        }
        return res;
    }
}