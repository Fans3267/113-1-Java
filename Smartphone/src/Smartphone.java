import java.util.Scanner;

public class Smartphone {

    private MusicPlayer musicPlayer;
    private PhoneCall phoneCall;
    private WebBrowser webBrowser;
    private AgendaApp agendaApp;
    private Scanner scanner;

    public Smartphone() {
        musicPlayer = new MusicPlayer();
        phoneCall = new PhoneCall();
        webBrowser = new WebBrowser();
        agendaApp = new AgendaApp();
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("Select an app: ");
            System.out.println("1. MusicPlayer");
            System.out.println("2. PhoneCall");
            System.out.println("3. WebBrowser");
            System.out.println("4. AgendaApp");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Goodbye!");
                    return;
                case 1:
                    musicPlayer.run();
                    break;
                case 2:
                    phoneCall.run();
                    break;
                case 3:
                    webBrowser.run();
                    break;
                case 4:
                    agendaApp.run();
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }


        }
    }
}