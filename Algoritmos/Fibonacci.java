package Algoritmos;
public class Fibonacci {
    
    public static long fibonacci(int n) {
        // casos cuando n es 0 y 1
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

}