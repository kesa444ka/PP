/*Кондря Ксения, 5 группа, Лабораторная работа 2, задание 6
Условие: Выведите  номера столбцов, элементы каждого из которых образуют монотонную
последовательность (монотонно убывающую или монотонно возрастающую).*/

import java.io.*;
import java.util.Random;

class Main {

    private static boolean isMonoton(int[][] matrix, int j) {
        boolean increase = true;
        boolean decrease = true;

        for (int i = 1; i < matrix.length; i++) {
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

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                    matrix[i][j] = random.nextInt(20);
            }
        }

        System.out.println("Введенная матрица:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        int count = 0;
        System.out.println("Номера столбцов с монотонными последовательностями:");
        for (int j = 0; j < m; j++) {
            if (isMonoton(matrix, j)) {
                System.out.println(j + 1);
                count++;
            }
        }
        if(count==0){
            System.out.println("Таких столбцов нет.");
        }

    }

}