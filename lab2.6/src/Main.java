/*Кондря Ксения, 5 группа, Лабораторная работа 2
*
* найти столбцы в матрице, которые являются монотонными последовательностями
* */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {
    private static boolean isMonoton(int[][] matrix, int j) {
        boolean increase = true;
        boolean decrease = true;

        for(int i = 1; i < matrix.length; ++i) {
            if (matrix[i][j] > matrix[i - 1][j]) {
                decrease = false;
            } else if (matrix[i][j] < matrix[i - 1][j]) {
                increase = false;
            }
        }

        return increase || decrease;
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        Random random = new Random();
        System.out.print("Введите количество строк: ");
        int n = Integer.parseInt(br.readLine());
        System.out.print("Введите количество столбцов: ");
        int m = Integer.parseInt(br.readLine());
        System.out.println();
        int[][] matrix = new int[n][m];

        int count;
        int j;
        for(count = 0; count < n; ++count) {
            for(j = 0; j < m; ++j) {
                matrix[count][j] = random.nextInt(20);
            }
        }

        System.out.println("Введенная матрица:");

        for(count = 0; count < n; ++count) {
            for(j = 0; j < m; ++j) {
                System.out.print(matrix[count][j] + "\t");
            }

            System.out.println();
        }

        count = 0;
        System.out.println("Номера столбцов с монотонными последовательностями:");

        for(j = 0; j < m; ++j) {
            if (isMonoton(matrix, j)) {
                System.out.println(j + 1);
                ++count;
            }
        }

        if (count == 0) {
            System.out.println("Таких столбцов нет.");
        }

    }
}
