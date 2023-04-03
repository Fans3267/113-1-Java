import java.util.Scanner;

/**
 * Note that the run() method in each class is used to simulate the user interaction with the app.
 * Each class has its own run() method that presents a menu of options to the user and then calls the appropriate method based on the user's choice.
 * In this way, the Smartphone class acts as a container for the other classes and provides a unified interface for the user
 * to interact with the various apps.
 */
public class PhoneCall {
    private boolean callInProgress;
    private boolean incomingCall;
    private String voiceMail;
    private Scanner scanner;

    public PhoneCall() {
        callInProgress = false;
        incomingCall = false;
        voiceMail = "";
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("Select an option: ");
            System.out.println("1. Call");
            System.out.println("2. Receive call");
            System.out.println("3. Record voicemail");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Exiting PhoneCall...");
                    return;
                case 1:
                    call();
                    break;
                case 2:
                    receiveCall();
                    break;
                case 3:
                    recordVoiceMail();
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }

    public void call() {
        if (!callInProgress && !incomingCall) {
            System.out.println("Enter phone number to call: ");
            String phoneNumber = scanner.next();
            System.out.println("Calling " + phoneNumber + "...");
            callInProgress = true;
        } else {
            System.out.println("Call already in progress or incoming call!");
        }
    }

    public void receiveCall() {
        if (!callInProgress && !incomingCall) {
            System.out.println("Incoming call!");
            incomingCall = true;
        } else {
            System.out.println("Call already in progress or incoming call!");
        }
    }

    public void recordVoiceMail() {
        if (callInProgress) {
            System.out.println("Recording voicemail...");
            scanner.nextLine();
            String message = scanner.nextLine();
            voiceMail = message;
            System.out.println("Voicemail recorded!");
            callInProgress = false;
        } else {
            System.out.println("No call in progress!");
        }
    }
}
