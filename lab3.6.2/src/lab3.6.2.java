/*Кондря Ксения, 5 группа, Лабораторная работа 3, задание 6.2
Условие: Задан текстовый файл input.txt. Требуется определить строки этого файла, содержащие максимальную по длине
подстроку, состоящую только из цифр. Если таких строк несколько, найти первые 10. Результат вывести на консоль в форме, удобной для чтения.
*/

import java.io.*;
import java.util.*;

class Main {
    private static int getLength(String str) {
        int maxLength = 0;
        int currentLength = 0;

        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                currentLength++;
            } else {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 0;
            }
        }

        return Math.max(maxLength, currentLength);
    }

    public static void main(String[] args) {
        String fileName = "input.txt";
        Vector<String> lines = new Vector<>();
        int max = 0;
        String line;

        try {
            BufferedReader fin = new BufferedReader(new FileReader(fileName));
            while ((line = fin.readLine()) != null) {
                int currentMax = getLength(line);
                if (currentMax > max) {
                    max = currentMax;
                    lines.clear();
                    lines.add(line);
                } else if (currentMax == max && max > 0) {
                    lines.add(line);
                }
            }
        } catch (Exception  e) {
            e.printStackTrace();
        }

        System.out.println("Строки с максимальной длиной подстроки из цифр:");
        for (int i = 0; i < Math.min(lines.size(), 10); i++) {
            System.out.println(lines.get(i));
        }
    }
}