import java.util.*;

public class MainThread implements Runnable {
    private int[] array;
    private int n;
    private final int sortOrder;

    public MainThread() {
        this.n = this.size();
        this.array = this.createArray();
        this.sortOrder = this.getOrder();
    }

    public MainThread(int n, int sortOrder) {
        this.n = n;
        this.array = this.createArray();
        this.sortOrder = sortOrder;
    }

    private int size() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите разамернсть массива: ");
        this.n = scanner.nextInt();
        return this.n;
    }

    private int[] createArray() {
        Random r = new Random();
        this.array = new int[this.n];

        for(int i = 0; i < this.n; ++i) {
            this.array[i] = r.nextInt(this.n) + 1;
        }

        return this.array;
    }

    private int getOrder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите порядок сортировки(1-возростание,2-убывание):");
        return scanner.nextInt();
    }

    private void show() {
        System.out.println("Массив: ");

        for(int i = 0; i < this.n; ++i) {
            System.out.print(this.array[i] + " ");
        }

        System.out.println();
    }

    public void run() {
        System.out.println("Поток MainThread начал работу.");
        show();
        Thread thread = new Thread(new SortThread(this.array, this.sortOrder));
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        show();
        System.out.println("Поток MainThread закончил работу.");
    }

    public int[] getArray() {
        return this.array;
    }
}