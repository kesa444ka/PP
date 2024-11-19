import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String fileName = "input.txt";
        String line;
        List<Contact> contacts = new ArrayList<>();

        try {
            BufferedReader fin = new BufferedReader(new FileReader(fileName));
            while ((line = fin.readLine()) != null) {
                contacts.add(new Contact(line));
            }
        } catch (Exception  e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);

        Collections.sort(contacts);
        System.out.println("\nОтсортированные по именам контакты:");
        for (Contact contact : contacts) {
            System.out.println(contact);
        }

        contacts.sort(Contact.compareByEmail());
        System.out.println("\nОтсортированные по email контакты:");
        for (Contact contact : contacts) {
            System.out.println(contact);
        }

        contacts.sort(Contact.compareByPhoneNumber());
        System.out.println("\nОтсортированные по номерам телефона контакты:");
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
        scanner.close();
    }
}