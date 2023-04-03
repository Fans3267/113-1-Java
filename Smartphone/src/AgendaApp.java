import java.util.ArrayList;
import java.util.Scanner;

/**
 * The AgendaApp class has its own ArrayList to store the meetings,
 * and the newMeeting() method allows the user to add a new meeting to the list.
 * The listMeeting() method displays a list of all meetings that have been scheduled,
 * and the editMeeting() method allows the user to select a meeting from the list and edit its name.
 */

public class AgendaApp {
    private ArrayList<String> meetings;
    private Scanner scanner;

    public AgendaApp() {
        meetings = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("Select an option: ");
            System.out.println("1. New meeting");
            System.out.println("2. List meetings");
            System.out.println("3. Edit meeting");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Exiting AgendaApp...");
                    return;
                case 1:
                    newMeeting();
                    break;
                case 2:
                    listMeeting();
                    break;
                case 3:
                    editMeeting();
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }

    public void newMeeting() {
        System.out.println("Enter name of new meeting: ");
        String name = scanner.next();
        meetings.add(name);
        System.out.println("Meeting added: " + name);
    }

    public void listMeeting() {
        if (meetings.isEmpty()) {
            System.out.println("No meetings scheduled!");
        } else {
            System.out.println("Meetings: ");
            for (String meeting : meetings) {
                System.out.println("- " + meeting);
            }
        }
    }

    public void editMeeting() {
        if (meetings.isEmpty()) {
            System.out.println("No meetings to edit!");
        } else {
            System.out.println("Select a meeting to edit: ");
            for (int i = 0; i < meetings.size(); i++) {
                System.out.println((i+1) + ". " + meetings.get(i));
            }
            int choice = scanner.nextInt();
            if (choice >= 1 && choice <= meetings.size()) {
                String meeting = meetings.get(choice-1);
                System.out.println("Enter new name for meeting: ");
                String newName = scanner.next();
                meetings.set(choice-1, newName);
                System.out.println("Meeting edited: " + meeting + " -> " + newName);
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }
}
