import java.time.LocalDate;
import java.time.format.*;

public class Company {
    String name;
    String shortTitle;
    String dateFoundation;
    String countEmployees;
    String branch;
    String activity;

    public Company(String name, String shortTitle, String dateFoundation,
                   String countEmployees, String branch, String activity) {
        this.name = name;
        this.shortTitle = shortTitle;
        this.dateFoundation = dateFoundation;
        this.countEmployees = countEmployees;
        this.branch = branch;
        this.activity = activity;
    }

    public String toString() {
        String f = "%-27s %-7s %-15s %-7s %-17s %-25s";
        return String.format(f, name, shortTitle, dateFoundation, countEmployees, branch, activity);
    }

    public String getName() {
        return name;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public String getDateFoundation() {
        return dateFoundation;
    }

    public String getCountEmployees() {
        return countEmployees;
    }

    public String getBranch() {
        return branch;
    }

    public String getActivity() {
        return activity;
    }

    public boolean FindCompany(String str, int choice) {
        if (choice == 1) {
            return shortTitle.equalsIgnoreCase(str);
        } else if (choice == 2) {
            return branch.equalsIgnoreCase(str);
        } else if (choice == 3) {
            return activity.equalsIgnoreCase(str);
        }
        return false;
    }

    public boolean isBetweenEmployee(String str1, String str2) {
        try {
            int min = Integer.parseInt(str1);
            int max = Integer.parseInt(str2);
            int count = Integer.parseInt(countEmployees);
            return count >= min && count <= max;

        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean isBetweenDate(String str1, String str2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        try{
            LocalDate date = LocalDate.parse(dateFoundation, formatter);
            LocalDate start = LocalDate.parse(str1, formatter);
            LocalDate end = LocalDate.parse(str2, formatter);

            return !(date.isBefore(start) || date.isAfter(end));
        } catch(DateTimeParseException e) {
            return false;
        }

    }
}
