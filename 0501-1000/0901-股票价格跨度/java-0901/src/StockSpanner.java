import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

class StockSpanner {

    ArrayList<Integer> prices;
    Deque<Integer> idxStack;
    public StockSpanner() {
        prices = new ArrayList<>();
        idxStack = new LinkedList<>();
    }

    public int next(int price) {
        int res;
        if (idxStack.isEmpty()) {
            idxStack.push(prices.size());
            res = 1;
        } else {
            while (!idxStack.isEmpty() && prices.get(idxStack.peek()) <= price) {
                idxStack.poll();
            }
            if (idxStack.isEmpty()) {
                res = prices.size() + 1;
            } else {
                res = prices.size() - idxStack.peek();
            }
        }
        idxStack.push(prices.size());
        prices.add(price);
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */