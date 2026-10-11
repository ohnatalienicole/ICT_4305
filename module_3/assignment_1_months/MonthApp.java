
import java.util.ArrayList;

public class MonthApp {
    public static void main(String[] args) {

        ArrayList<Month<Integer>> monthNumbers = new ArrayList<>();
        ArrayList<Month<String>> monthNames = new ArrayList<>();

        String[] names = {
            "January", "February", "March", "April",
            "May", "June", "July", "August",
            "September", "October", "November", "December"
        };

        // Create 24 Month objects
        for (int i = 0; i < 12; i++) {
            Month<Integer> monthNumber = new Month<>(i + 1);
            Month<String> monthName = new Month<>(names[i]);

            monthNumbers.add(monthNumber);
            monthNames.add(monthName);
        }

        // Display month numbers and names
        for (int i = 0; i < 12; i++) {
            System.out.println(
                monthNumbers.get(i).getMonth()
                + " = "
                + monthNames.get(i).getMonth()
            );
        }
    }
}

