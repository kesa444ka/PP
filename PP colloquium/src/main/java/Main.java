import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите натуральное число n: ");
            int n = scanner.nextInt();
            //FibonacciGenerator generator = new FibonacciGenerator();
            List<Integer> fibonacciNumbers = FibonacciGenerator.generateFibonacci(n);
            System.out.println("Первые " + n + " чисел Фибоначчи: " + fibonacciNumbers);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Произошла ошибка. Пожалуйста, введите натуральное число.");
        }
    }
}