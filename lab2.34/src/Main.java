/* Кондря Ксения, 5 группа, Лабораторная работа 2, задание 34
Условие: Переставляя ее строки и столбцы,  добиться,  чтобы наименьший элемент (один  из них)
оказался в нижнем правом углу. Вывести на экран полученную матрицу.
*/

import java.io.*;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void SwapRows (List<List<Integer>> matrix, int r1, int r2) {
        if (r1 == r2) {
            return;
        }
        List<Integer> temp = matrix.get(r1);
        matrix.set(r1, matrix.get(r2));
        matrix.set(r2, temp);
    }

    public static void SwapCols (List<List<Integer>> matrix, int c1, int c2) {
        if (c1 == c2) {
            return;
        }
        for (int i = 0; i < matrix.size(); i++) {
            matrix.get(i).set(i, 9);
            int temp = matrix.get(i).get(c1);
            matrix.get(i).set(c1, matrix.get(i).get(c2));
            matrix.get(i).set(c2, temp);
        }
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        Random random = new Random();

        System.out.print("Введите количество строк: ");
        int n = Integer.parseInt(br.readLine());
        System.out.print("Введите количество столбцов: ");
        int m = Integer.parseInt(br.readLine());

        List<List<Integer>> matrix = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>(m);
            for (int j = 0; j < m; j++) {
                row.add(random.nextInt(50));
            }
            matrix.add(row);
        }

        System.out.println("Введенная матрица:");
        for (List<Integer> row : matrix) {
            for (Integer value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
        System.out.println();

        int min = matrix.get(0).get(0);
        int k = 0;
        int l = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix.get(i).get(j) < min){
                    min = matrix.get(i).get(j);
                    k = i; //строка
                    l = j; //столбец
                }
            }
        }
        System.out.println("Минимальный элемент матрицы: " + min + '(' + k + " строка, " + l + " столбец)");
        System.out.println();

        SwapCols(matrix, l, m-1);
        SwapRows(matrix, k, n-1);

        System.out.println("Измененная матрица: ");
        for (List<Integer> row : matrix) {
            for (Integer value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}