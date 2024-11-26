import java.util.ArrayList;
import java.util.List;

public class FibonacciGenerator {

    public static List<Integer> generateFibonacci(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n должно быть натуральным числом (n > 0).");
        }

        List<Integer> fibonacciNumbers = new ArrayList<>();

        // Начальные значения Фибоначчи
        int a = 0;
        int b = 1;

        for (int i = 0; i < n; i++) {
            fibonacciNumbers.add(a);
            int next = a + b;
            a = b;
            b = next;
        }

        return fibonacciNumbers;
    }
}