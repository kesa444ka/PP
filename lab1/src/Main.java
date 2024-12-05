/*Кондря Ксения, 5 группа, Лабораторная работа 1
* вычисление синуса
* */
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {
    public static BigDecimal bigDSinus(BigDecimal x, BigDecimal e) {
        BigDecimal sinus = BigDecimal.ZERO;
        BigDecimal term = x;

        for(int n = 1; term.abs().compareTo(e) >= 0; ++n) {
            sinus = sinus.add(term);
            BigDecimal xSquared = x.multiply(x);
            BigDecimal factorial = new BigDecimal(2 * n * (2 * n + 1));
            term = term.multiply(xSquared).multiply(BigDecimal.valueOf(-1L)).divide(factorial, 3, RoundingMode.HALF_UP);
        }

        return sinus;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите значение x (в радианах): ");
        double x = scanner.nextDouble();
        System.out.print("Введите значение k (натуральное число): ");
        int k = scanner.nextInt();
        double e = Math.pow(10.0, -k);
        double sinus = Math.sin(x);
        BigDecimal bdsinus = bigDSinus(BigDecimal.valueOf(x), BigDecimal.valueOf(e));
        double mysinus = 0.0;
        int n = 1;

        for(double x1 = x; Math.abs(x1) >= e; ++n) {
            mysinus += x1;
            x1 *= -x * x / (double)(2 * n * (2 * n + 1));
        }

        System.out.printf("Синус c BigDecimal и BigInteger: %s%n", bdsinus);
        System.out.printf("Синус по Тейлору: %.3f%n", mysinus);
        System.out.printf("Синус: %.3f%n", sinus);
        scanner.close();
    }
}
