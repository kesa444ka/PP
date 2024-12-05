/* Кондря Ксениия 5 группа 2 курс, регулярные выражения

Из заданной строки исключить символы, расположенные внутри круглых скобок. Сами скобки тоже должны быть исключены.
Из заданной строки удалить из каждой группы идущих подряд цифр, в которой более двух цифр, все цифры, начиная с третьей.
*/

import java.io.*;

public class Main {
    private static String DeleteBrackets(String input) {
        return input.replaceAll("\\s*\\([^)]*\\)\\s*", " ");
        /*
          \\s - любой пробельный символ
          * означает, что предыдущий символ может встречать 0 или более раз
          \\( - экранированная скобка
           [^)] - любые символы кроме )
        */
    }

    private static String DeleteNumbers(String input) {
        return input.replaceAll("([0-9]{2})([0-9]+)", "$1");
        //$1 означает первую группу ([0-9]{2})
    }

    private static String DeleteZeros(String input) {
        return input.replaceAll("(0+)([0-9]+)", "$2");
        //$2 означает вторую группу ([0-9]+)
    }

    public static void main(String[] args) {
        try{
            String input;
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            input = br.readLine();

            input = DeleteBrackets(input);
            input = DeleteNumbers(input);
            input = DeleteZeros(input);

            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
            bw.write(input);
            bw.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}