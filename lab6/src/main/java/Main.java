/*Кондря Ксения, 5 группа, Лабораторная работа 6
Мое условие:
Пусть задан класс с именем OldCalculator, в котором есть 3 метода с именами:
add(int a, int b): возвращает сумму двух целых чисел;
subtract(int a, int b): возвращает разность двух целых чисел;
multiply(int a, int b): возвращает произведение двух целых чисел.

Нужно адаптировать класс OldCalculator к потребностям класса NewCalculator, который имеет следующие требования:

Метод add() нужно переименовать в sum(). Работа метода остается неизменной;
Метод subtract() нужно заменить методом subtractAndDouble(). Этот метод должен возвращать удвоенный результат вычитания;
Метод multiply() нужно заменить методом multiplyAndSquare(). Этот метод должен возвращать квадрат произведения.

Класс NewCalculator должен получать ссылку на интерфейс CalculatorTarget в конструкторе.
* */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OldCalculator oldCalculator = new OldCalculator();
        CalculatorTarget calculator = new NewCalculator(oldCalculator);

        Scanner sc = new Scanner(System.in);

        System.out.print("Введите два числа: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Сумма: " + calculator.sum(a, b));
        System.out.println();

        System.out.print("Введите два числа: ");
        int c = sc.nextInt();
        int d = sc.nextInt();
        System.out.println("Отнять и удвоить: " + calculator.subtractAndDouble(c, d));
        System.out.println();

        System.out.print("Введите два числа: ");
        int e = sc.nextInt();
        int f = sc.nextInt();
        System.out.println("Умножить и возвести в квадрат: " + calculator.multiplyAndSquare(e, f));
    }
}