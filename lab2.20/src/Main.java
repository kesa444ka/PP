/*Кондря Ксения, 5 группа, Лабораторная работа 2, задание 20
Условие: Подсчитать количество строк заданной матрицы, являющихся перестановкой чисел -1, -2, ..., -10.

Матрица 10х10 (6 строк-перестановок):
-1 -2 -10 -9 -4 -3 -7 -5 -6 -8
-1 2 3 4 5 6 7 8 9 10
-1 -2 -3 -4 -5 -6 -7 -8 -9 -3
-3 -4 -5 -1 -2 -6 -7 -9 -8 -10
-1 -1 -2 -3 -4 -5 -6 -7 -8 -9
1 -2 3 -4 5 -6 7 -8 9 -10
-10 -9 -8 -7 -6 -5 -4 -3 -2 -1
-6 -2 -4 -10 -8 -3 -7 -1 -9 -5
-8 -3 -5 -2 -1 -10 -9 -4 -7 -6
-3 -1 -4 -2 -5 -10 -9 -6 -8 -7

Матрица 10х6(3 строки-перестановки):
-10 -9 -8 -7 -6 -5 -4 -3 -2 -1
-1 -1 -1 -2 -2 -2 -3 -3 -3 -4
1 2 3 4 5 6 7 8 9 10
-1 -2 -3 -4 -5 -6 -7 -8 -9 -10
-4 -2 -5 -1 -8 -6 -9 -10 -3 -7
-2 -5 -1 -7 -6 -4 -8 -10 -9 -2
*/

import java.io.*;
import java.util.Vector;

public class Main {

    private static boolean isPerestanovka(Vector<Vector<Integer>> matrix, int row){
        Vector<Integer> a = new Vector<>(10);
        Vector<Integer> b = new Vector<>(10);
        for (int i = 0; i < 10; i++){
            a.add((-1) * (i + 1));
            b.add(0);
        }
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                if(matrix.get(row).get(i).equals(a.get(j))) {
                    b.set(j, b.get(j) + 1);
                }
            }
        }
        for (int i = 0; i < 10; i++){
            if(!b.get(i).equals(1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        System.out.print("Введите количество строк: ");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Количеством столбцов автоматически является 10 :)");
        int m = 10;

        Vector<Vector<Integer>> matrix = new Vector<>(n);
        for (int i = 0; i < n; i++) {
            matrix.add(new Vector<>(m));
        }

        System.out.println("Введите элементы матрицы:");
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] numbers = line.split(" ");
            for (int j = 0; j < m; j++) {
                try {
                    matrix.get(i).add(Integer.parseInt(numbers[j]));
                } catch (NumberFormatException e){
                    System.out.println("Не целое число. Оно будет замененено на 0");
                }
            }
        }

        System.out.print("Количество строк матрицы, являющихся перестановкой чисел -1, -2, ..., -10: ");
        int k=0;
        for(int i = 0; i < n; i++) {
            if(isPerestanovka(matrix, i)) {
                k++;
            }
        }
        System.out.print(k);
    }
}