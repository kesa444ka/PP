/* Кондря Ксениия 5 группа 2 курс, регулярные выражения
Входные данные:
Входной файл input1.html содержит текст, написанный на языке HTML.
В тесте находятся теги. В одной строке может быть несколько тегов. Теги находятся в угловых скобках, каждому открывающему тегу ставится в соответствие закрывающий тег. Например, пара тегов<b></b>.
Между тегами находится текст, причем теги не разрывают текст. Например, при поиске слова hello комбинация h<b><i>el</i>l</b>o должна быть найдена.
Гарантируется,что страница HTML является корректной, т.е. все символы "<" и ">" используются только в тегах, все теги записаны корректно.
Входной файл input2.in содержит список фрагментов текста, которые нужно найти в первом файле, записанных через разделители (точка с запятой). Может быть несколько строк.

Примечание: Ваша программа должна игнорировать различие между строчными и прописными буквами и для тегов и для искомого контекста.

Выходные данные:
1. В выходной файл output1.out вывести список всех тегов в порядке возрастания количества символов тега.
2. В выходной файл output2.out вывести номера строк (нумерация с 0) первого файла, в которых был найден искомый контекст в первый раз или -1 , если не был найден.
3. В выходной файл output3.out - список фрагментов второго файла, которые НЕ были найдены в первом файле.

*/

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Main {
    private static String read(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    private static void write(String filePath, List<?> content) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Object item : content) {
                bw.write(item.toString());
                bw.newLine();
            }
        }
    }

    public static void main(String[] args) {
        try {
            String html = read("input1.html");
            String in = read("input2.in");
            List<String> searchElems = new ArrayList<>(Arrays.asList(in.split(";")));

            Set<String> tags = new HashSet<>();
            Pattern p = Pattern.compile("<(/?[^>]+)>");
            Matcher m = p.matcher(html);
            while (m.find()) {
                tags.add(m.group(0).toLowerCase());
            }
            Vector<String> tags1 = new Vector<>(tags);
            tags1.sort(Comparator.comparingInt(String::length));
            write("output1.out", tags1);

            List<Integer> lineNumbers = new ArrayList<>();
            String[] lines = html.split("\n");
            List<String> notFoundElems = new ArrayList<>();

            for (String term : searchElems) {
                String term1 = term.replaceAll("\n", "");
                boolean found = false;
                for (int i = 0; i < lines.length; i++) {
                    String cleanLine = lines[i].replaceAll("<[^>]*>", "");
                    if (cleanLine.toLowerCase().contains(term1.toLowerCase())) {
                        lineNumbers.add(i);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    lineNumbers.add(-1);
                    notFoundElems.add(term);
                }
            }

            notFoundElems.replaceAll(String::trim);

            write("output2.out", lineNumbers);
            write("output3.out", notFoundElems);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}