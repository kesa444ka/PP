/*Кондря Ксения, 5 группа, Лабораторная работа 1, задание 6 */
/*синус*/

import java.util.Scanner;
import java.math.BigDecimal;

public class Main {
    public static BigDecimal bigDSinus (BigDecimal x, BigDecimal e){
        BigDecimal sinus = BigDecimal.ZERO;
        BigDecimal term = x;
        int n = 1;

        while (term.abs().compareTo(e) >= 0) {
           sinus = sinus.add(term);
           BigDecimal xSquared = x.multiply(x);
           BigDecimal factorial = new BigDecimal(2 * n * (2 * n + 1));
           term = term.multiply(xSquared).multiply(BigDecimal.valueOf(-1)).divide(factorial, 3, BigDecimal.ROUND_HALF_UP);
           n++;
        }
        return sinus;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите значение x (в радианах): ");
        double x = scanner.nextDouble();
        System.out.print("Введите значение k (натуральное число): ");
        int k = scanner.nextInt();

        double e = Math.pow(10, -k);

        double sinus = Math.sin(x);
        BigDecimal bdsinus = bigDSinus(BigDecimal.valueOf(x), BigDecimal.valueOf(e));
        double mysinus = 0.0;
        int n = 1;
        double x1 = x;
        while (Math.abs(x1) >= e) {
            mysinus += x1;
            x1 *= -x * x / ((2 * n) * (2 * n + 1));
            n++;
        }

        System.out.printf("Синус c BigDecimal и BigInteger: %s%n", bdsinus);
        System.out.printf("Синус по Тейлору: %.3f%n", mysinus);
        System.out.printf("Синус: %.3f%n", sinus);

        scanner.close();
    }
}