import javax.swing.*;
import java.awt.*;

public class PhoneCall {
    private JButton button1, button2, button3, button4;
    private JLabel lb2;
    private JTextField jTextField;
    private boolean callInProgress=false;
    private boolean incomingCall;

    public void run() {
        //Jframe設定
        JFrame frame = new JFrame("Phone Call");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 800);

        // Create a panel to hold the buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout()); // Use GridBagLayout for centering and spacing
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0); // Add vertical spacing between buttons
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.NONE;

        setButtonlabel();

        //在phonecall呼叫時隨機(50%)接到電話
        if((Math.random())*10>=5){
            incomingCall = true;
            lb2.setText("Incoming Call!");
        }

        //按鈕偵測+回傳數值
        button1.addActionListener(e -> {
            lb2.setText(call());
        });
        button2.addActionListener(e -> {
            lb2.setText(receiveCall());
        });
        button3.addActionListener(e -> {
            lb2.setText(hangup());
        });
        button4.addActionListener(e -> {
            frame.dispose();
            ValueReceiver receiver = new ValueReceiver();
            new Screen(receiver);
        });

        // Add buttons to the panel with constraints
        gbc.gridy = 0;
        panel.add(jTextField , gbc);
        gbc.gridy = 1;
        panel.add(lb2, gbc);
        gbc.gridy = 2;
        panel.add(button1, gbc);
        gbc.gridy = 3;
        panel.add(button2, gbc);
        gbc.gridy = 4;
        panel.add(button3, gbc);
        gbc.gridy = 5;
        panel.add(button4, gbc);


        // Add the panel to the frame
        frame.add(panel);
        // Make the frame visible
        frame.setVisible(true);
    }

    //按鈕+label設定
    public void setButtonlabel(){

        //label
        lb2 = new JLabel(" ",JLabel.CENTER);
        Dimension labelsize = new Dimension(300, 100);
        lb2.setPreferredSize(labelsize);
        lb2.setFont(new Font("Serif", Font.PLAIN, 27));


        // Initialize buttons as class-level variables
        jTextField = new JTextField(15);
        button1 = new JButton("Call");
        button2 = new JButton("Respond Call");
        button3 = new JButton("Hang up");
        button4 = new JButton("Exit");

        // Set button sizes
        Dimension buttonSize = new Dimension(200, 100);
        button1.setPreferredSize(buttonSize);
        button2.setPreferredSize(buttonSize);
        button3.setPreferredSize(buttonSize);
        button4.setPreferredSize(buttonSize);
    }

    public String call() {
        if(incomingCall){
            return "Respond to call first";
        } else if (callInProgress) {
            return "Already Calling!";
        } else if(jTextField.getText().isEmpty()){
            return "Please Enter Numbers!";
        }
        callInProgress = true;
        return "Calling: "+jTextField.getText();
    }

    public String receiveCall() {
        if(incomingCall){
            incomingCall=false;
            callInProgress=true;
            return "You Picked up the call";
        }else if (callInProgress) return "Already Calling!";
        return "No Incoming Call";
    }

    public String hangup() {
        if (callInProgress) {
            callInProgress = false;
            return "Hanged up";
        }
        return "Not in a call";
    }
}



/*
import java.util.Scanner;

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
}*/
