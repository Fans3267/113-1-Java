import java.util.ArrayList;
import java.util.Scanner;

/**
 * Note that the WebBrowser class has its own ArrayList to store the pages that have been visited,
 * and the showPage() and uploadPage() methods present the user with a list of the available pages to choose from.
 * The addNewPage() method allows the user to add a new page to the list.
 */
public class WebBrowser {
    private ArrayList<String> pages;
    private Scanner scanner;

    public WebBrowser() {
        pages = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("Select an option: ");
            System.out.println("1. Show page");
            System.out.println("2. Add new page");
            System.out.println("3. Upload page");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Exiting WebBrowser...");
                    return;
                case 1:
                    showPage();
                    break;
                case 2:
                    addNewPage();
                    break;
                case 3:
                    uploadPage();
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }

    public void showPage() {
        if (pages.isEmpty()) {
            System.out.println("No pages to show!");
        } else {
            System.out.println("Select a page to show: ");
            for (int i = 0; i < pages.size(); i++) {
                System.out.println((i+1) + ". " + pages.get(i));
            }
            int choice = scanner.nextInt();
            if (choice >= 1 && choice <= pages.size()) {
                String page = pages.get(choice-1);
                System.out.println("Showing page: " + page);
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }

    public void addNewPage() {
        System.out.println("Enter URL of new page: ");
        String url = scanner.next();
        pages.add(url);
        System.out.println("Page added: " + url);
    }

    public void uploadPage() {
        if (pages.isEmpty()) {
            System.out.println("No pages to upload!");
        } else {
            System.out.println("Select a page to upload: ");
            for (int i = 0; i < pages.size(); i++) {
                System.out.println((i+1) + ". " + pages.get(i));
            }
            int choice = scanner.nextInt();
            if (choice >= 1 && choice <= pages.size()) {
                String page = pages.get(choice-1);
                System.out.println("Uploading page: " + page);
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }
}
