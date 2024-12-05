import java.util.Iterator;
import java.util.Comparator;

public class Contact implements Comparable<Contact>, Iterable<String> {
    private String name;
    private String phoneNumber;
    private String email;
    private String address;

    public Contact(String str) {
        if(str!=null){
            String[] strs = str.split(", ");
            if(strs.length == 4){
                this.name = strs[0];
                this.phoneNumber = strs[1];
                this.email = strs[2];
                this.address = strs[3];
            }
        }
    }

    public String toString() {
        return String.format("%-15s %-15s %-25s %-30s", name, phoneNumber, email, address);
    }

    public int compareTo(Contact other) {
        return this.name.compareTo(other.name);
    }
    public static Comparator<Contact> compareByPhoneNumber() {
        return Comparator.comparing(contact -> contact.phoneNumber);
    }
    public static Comparator<Contact> compareByEmail() {
        return Comparator.comparing(contact -> contact.email);
    }

    public Iterator<String> iterator() {
        return new Iterator<>() {
            private int index = 0;
            private final String[] fields = {name, phoneNumber, email, address};

            public boolean hasNext() {
                return index < fields.length;
            }

            public String next() {
                return fields[index++];
            }
        };
    }
}