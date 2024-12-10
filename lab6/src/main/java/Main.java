import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Original original = new Original();
        Adapter adapter = new Adapter(original);
        Client client = new Client(adapter);

        System.out.print("Введите дробное число: ");
        double d=sc.nextDouble();

        System.out.print("Введите целое число: ");
        int i=sc.nextInt();

        System.out.print("Введите символ: ");
        char c=sc.next().charAt(0);

        client.show(d, i, c);
    }
}
