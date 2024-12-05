/*Кондря Ксения, 5 группа, 2 курс, Лабораторная работа 5*/

import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main {
    public static List<Company> Read(String file) throws IOException {
        List<Company> companies = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length == 6) {
                    Company company = new Company(data[0], data[1], data[2], data[3], data[4], data[5]);
                    companies.add(company);
                }
            }
        }
        return companies;
    }

    public static void writeToXml(String file, List<Company> companies) throws IOException {
        try (FileWriter fw = new FileWriter(file)) {
            StringBuilder xmlContent = new StringBuilder();
            xmlContent.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            xmlContent.append("<Companies>\n");

            for (Company company : companies) {
                xmlContent.append("  <Company>\n");
                xmlContent.append("    <name>").append(company.getName()).append("</name>\n");
                xmlContent.append("    <shortTitle>").append(company.getShortTitle()).append("</shortTitle>\n");
                xmlContent.append("    <dateFoundation>").append(company.getDateFoundation()).append("</dateFoundation>\n");
                xmlContent.append("    <countEmployees>").append(company.getCountEmployees()).append("</countEmployees>\n");
                xmlContent.append("    <branch>").append(company.getBranch()).append("</branch>\n");
                xmlContent.append("    <activity>").append(company.getActivity()).append("</activity>\n");
                xmlContent.append("  </Company>\n");
            }
            xmlContent.append("</Companies>");
            fw.write(xmlContent.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToJSON(String file, List<Company> companies) {
        try (FileWriter fw = new FileWriter(file)) {
            StringBuilder jsonContent = new StringBuilder();
            jsonContent.append("[\n");

            for (int i = 0; i < companies.size(); i++) {
                Company company = companies.get(i);
                jsonContent.append("  {\n");
                jsonContent.append("    \"name\": \"").append(company.getName()).append("\",\n");
                jsonContent.append("    \"shortTitle\": \"").append(company.getShortTitle()).append("\",\n");
                jsonContent.append("    \"dateFoundation\": \"").append(company.getDateFoundation()).append("\",\n");
                jsonContent.append("    \"countEmployees\": \"").append(company.getCountEmployees()).append("\",\n");
                jsonContent.append("    \"branch\": \"").append(company.getBranch()).append("\",\n");
                jsonContent.append("    \"activity\": \"").append(company.getActivity()).append("\"\n");
                jsonContent.append("  }");

                if (i < companies.size() - 1) {
                    jsonContent.append(",");
                }
                jsonContent.append("\n");
            }
            jsonContent.append("]");
            fw.write(jsonContent.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToLog(String query, String user, int count) {
        try (FileWriter fw = new FileWriter("logfile.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();

            out.printf("%s - %s: \"%s\"; Найдено компаний: %d%n", dtf.format(now), query, user, count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String file1 = "input.csv";
        String file2 = "output1.xml";
        String file3 = "output2.json";
        List<Company> companies = Read(file1);
        System.out.println("Данные из файла input.scv: ");
        for (Company company : companies) {
            System.out.println(company);
        }
        String q1 = "Найти компанию по краткому наименованию";
        String q2 = "Выбрать компании по отрасли";
        String q3 = "Выбрать компании по виду деятельности";
        String q4 = "Выбрать компании по дате основания в определенном промежутке (с и по)";
        String q5 = "Выбрать компании по численности сотрудников в определенном промежутке (с и по)";

        System.out.println("Что вы хотите найти?\n" +
                "1. " + q1 + "\n" +
                "2. " + q2 + "\n" +
                "3. " + q3 + "\n" +
                "4. " + q4 + "\n" +
                "5. " + q5 + "\n");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Введите краткое наименование компании: ");
                String companyName = scanner.nextLine();
                List<Company> found = new ArrayList<>();
                for (Company company : companies) {
                    if(company.FindCompany(companyName, 1)){
                        System.out.println(company);
                        found.add(company);
                    }
                }
                writeToLog(q1, companyName, found.size());
                writeToXml(file2, found);
                writeToJSON(file3, found);
                break;
            case 2:
                System.out.println("Введите отрасль: ");
                String companyBranch = scanner.nextLine();
                List<Company> found1 = new ArrayList<>();
                for (Company company : companies) {
                    if (company.FindCompany(companyBranch, 2)) {
                        System.out.println(company);
                        found1.add(company);
                    }
                }
                writeToLog(q2, companyBranch, found1.size());
                writeToXml(file2, found1);
                writeToJSON(file3, found1);
                break;
            case 3:
                System.out.println("Введите вид деятельности: ");
                String companyActivity = scanner.nextLine();
                List<Company> found2 = new ArrayList<>();
                for (Company company : companies) {
                    if (company.FindCompany(companyActivity, 3)) {
                        System.out.println(company);
                        found2.add(company);
                    }
                }
                writeToLog(q3, companyActivity, found2.size());
                writeToXml(file2, found2);
                writeToJSON(file3, found2);
                break;
            case 4:
                System.out.println("Введите две даты в формате dd.mm.yyyy\n" +
                        "Дату с какого момента искать компании: ");
                String one = scanner.next();
                System.out.println("Дату до какого момента искать компании: ");
                String two = scanner.next();
                List<Company> found3 = new ArrayList<>();
                for (Company company : companies) {
                    if (company.isBetweenDate(one, two)) {
                        System.out.println(company);
                        found3.add(company);
                    }
                }
                writeToLog(q4, "с " + one + " по " + two, found3.size());
                writeToXml(file2, found3);
                writeToJSON(file3, found3);
                break;
            case 5:
                System.out.println("Введите два числа(промежуток численности сотрудников)\n" +
                        "С: ");
                String one1 = scanner.next();
                System.out.println("По: ");
                String two1 = scanner.next();
                List<Company> found4 = new ArrayList<>();
                for (Company company : companies) {
                    if (company.isBetweenEmployee(one1, two1)) {
                        System.out.println(company);
                        found4.add(company);
                    }
                }
                writeToLog(q5, "с " + one1 + " по " + two1, found4.size());
                writeToXml(file2, found4);
                writeToJSON(file3, found4);
                break;
        }
        scanner.close();
    }
}