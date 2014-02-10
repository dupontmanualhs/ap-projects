import java.util.Random;

public class Constants {
    private static Random rand = new Random();
    
    public static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }
    
    public static long factorial(int n) {
        long fact = 1L;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
    
    public static double piSeries(int n) {
        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            double currVal = 4.0 * Math.pow(-1, i) / (2 * i + 1);
            sum += currVal;
        }
        return sum;
    }
    
    public static double piRandom(int n) {
        int relPrime = 0;
        for (int i = 0; i < n; i++) {
            int randInt1 = Math.abs(rand.nextInt());
            int randInt2 = Math.abs(rand.nextInt());
            while (randInt1 == 0 || randInt2 == 0) {
                randInt1 = Math.abs(rand.nextInt());
                randInt2 = Math.abs(rand.nextInt());
            }
            if (gcd(randInt1, randInt2) == 1) {
                relPrime++;
            }
        }
        double prob = 1.0 * relPrime / n;
        double maybePi = Math.sqrt(6.0 / prob);
        return maybePi;
    }
    
    public static double eSeries(int n) {
        double sum = 0.0;
        for (int i = 0; i <= n; i++) {
            double currVal = 1.0 / factorial(i);
            sum += currVal;
        }
        return sum;
    }
    
    private static int addToOne() {
        double sum = 0.0;
        int count = 0;
        while (sum < 1) {
            sum += rand.nextDouble();
            count++;
        }
        return count;
    }
    
    public static double eRandom(int n) {
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += addToOne();
        }
        return 1.0 * total / n;
    }
    
}
