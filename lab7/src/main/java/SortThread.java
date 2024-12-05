import java.util.Arrays;

class SortThread implements Runnable {
    private final int[] array;
    private final int sortOrder;

    public SortThread(int[] array, int sortOrder) {
        this.array = array;
        this.sortOrder = sortOrder;
    }

    public void run() {
        System.out.println("Поток SortThread начал работу.");
        if (this.sortOrder == 1) {
            Arrays.sort(this.array);
        } else if (this.sortOrder == 2) {
            Arrays.sort(this.array);

            for(int i = 0; i < this.array.length / 2; ++i) {
                int temp = this.array[i];
                this.array[i] = this.array[this.array.length - 1 - i];
                this.array[this.array.length - 1 - i] = temp;
            }
        } else {
            System.out.println("Некорректный порядок сортировки. Используйте 'asc' или 'desc'.");
        }

        System.out.println("Поток SortThread закончил работу.");
    }
}