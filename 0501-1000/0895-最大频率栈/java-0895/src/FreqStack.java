import java.util.HashMap;
import java.util.Stack;

class FreqStack {

    public HashMap<Integer, Integer> freq;
    public HashMap<Integer, Stack<Integer>> freqGroup;
    int maxFreq;
    public FreqStack() {
        freq = new HashMap<>();
        freqGroup = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);
        if (f > maxFreq) {
            maxFreq = f;
        }

        if (freqGroup.containsKey(f)) {
            freqGroup.get(f).push(val);
        } else {
            freqGroup.put(f, new Stack<>());
            freqGroup.get(f).push(val);
        }
    }

    public int pop() {
        int res = freqGroup.get(maxFreq).pop();
        freq.put(res, freq.get(res) - 1);
        if (freqGroup.get(maxFreq).size() == 0) {
            maxFreq--;
        }
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */