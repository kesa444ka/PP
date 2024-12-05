/* Кондря Ксения, 5 группа, Лабораторная работа 3, задание 6
Условие: Задана строка  из слов. Слова в исходной строке разделяются некоторым множеством разделителей. Поместить
в начало строки слова, содержащие только цифры, а затем – все остальные слова. Порядок слов внутри заданных групп
не должен изменяться.  Слова в новой строке должны разделяться ровно одним пробелом.

Пример строки:
123,abc-456 ..  789.def
*/

import java.util.Scanner;

public class Main {
    public static boolean isNumber(String s) {
        if (s.isEmpty())
            return false;

        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isWord(String s) {
        if (s.isEmpty())
            return false;

        for (char c : s.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String input = scanner.nextLine();

        String delimiters = "[{}() ,.!?;-]+";

        String[] words = input.split(delimiters);

        String result = "";
        for(String word : words){
            if(isNumber(word)){
                result += ' ' + word;
            }
        }
        for(String word : words){
            if(isWord(word)){
                result += ' ' + word;
            }
        }

        result = result.trim();
        System.out.println(result);

        scanner.close();
    }
}