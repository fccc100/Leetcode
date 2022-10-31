import java.util.Arrays;

class CarFleet {
    class Car {
        int position;
        double time;
        public Car(int position, double time) {
            this.position = position;
            this.time = time;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        Car[] pairs = new Car [n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Car(position[i], (double) (target - position[i]) / speed[i]);
        }

        Arrays.sort(pairs, (a, b) -> Integer.compare(a.position, b.position));

        int res = 0;
        int i;
        for (i = n - 1; i > 0; i--) {
            if (pairs[i].time < pairs[i - 1].time) {
                res++;
            } else {
                pairs[i - 1] = pairs[i];
            }
        }
        return i == 0 ? res + 1 : res;
    }
}

