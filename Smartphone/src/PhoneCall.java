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

        //JPanel設定
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.NONE;

        //呼叫按鈕設定
        setButtonlabel();

        //在phonecall呼叫時隨機(50%)接到電話
        if((Math.random())*10>=5){
            incomingCall = true;
            lb2.setText("Incoming Call!");
        }

        //按鈕偵測+回傳數值
        button1.addActionListener(e -> {
            lb2.setText(call()); //呼叫call函數
        });
        button2.addActionListener(e -> {
            lb2.setText(receiveCall()); //呼叫receiveCall函數
        });
        button3.addActionListener(e -> { //呼叫hangup函數
            lb2.setText(hangup());
        });
        button4.addActionListener(e -> { //離開APP 消除視窗並重新呼叫Screen方法
            frame.dispose();
            ValueReceiver receiver = new ValueReceiver();
            new Screen(receiver);
        });

        //新增設定好的物件到JPanel上
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

        //顯示Jframe
        frame.add(panel);
        frame.setVisible(true);
    }
    //按鈕+label設定
    public void setButtonlabel(){
        //label
        lb2 = new JLabel(" ",JLabel.CENTER);
        Dimension labelsize = new Dimension(300, 100);
        lb2.setPreferredSize(labelsize);
        lb2.setFont(new Font("Serif", Font.PLAIN, 27));

        //按鈕跟textbox
        jTextField = new JTextField(15);
        button1 = new JButton("Call");
        button2 = new JButton("Respond Call");
        button3 = new JButton("Hang up");
        button4 = new JButton("Exit");

        //按鈕大小
        Dimension buttonSize = new Dimension(200, 100);
        button1.setPreferredSize(buttonSize);
        button2.setPreferredSize(buttonSize);
        button3.setPreferredSize(buttonSize);
        button4.setPreferredSize(buttonSize);
    }
    //call(打電話)函數 按下第一個按鈕觸發
    public String call() {
        if(incomingCall){            //檢查有無來電
            return "Respond to call first"; //回傳一個"請先回覆來電"顯示在lb2上
        } else if (callInProgress) {  //檢查是否正在通話
            return "Already Calling!"; //回傳一個"已經在通話中"顯示在lb2上
        } else if(jTextField.getText().isEmpty()){  //檢查textbox有無空白
            return "Please Enter Numbers!"; //回傳一個"請輸入電話號碼"顯示在lb2上
        }
        callInProgress = true; //上述三個條件皆通過 開始打電話
        return "Calling: "+jTextField.getText(); //回傳一個String值顯示在lb2上
    }
    //receiveCall(來電)函數 按下第二個按鈕觸發
    public String receiveCall() {
        if(incomingCall){      //檢查有無來電 (開啟APP時有50%收到來電)
            incomingCall=false; //有來電則接起來 callInProgress(正在接電話)設為肯定
            callInProgress=true;
            return "You Picked up the call";  //回傳"你已接起來電"
        }else if (callInProgress) return "Already Calling!";  //如果狀態是正在打電話 按下按鈕回傳"你已經在打電話"給lb2顯示
        return "No Incoming Call"; //若沒來電 也沒在通話 回傳"沒有來電"給lb2顯示
    }
    //hangup(掛電話)函數 按下第三個按鈕觸發
    public String hangup() {
        if (callInProgress) {   //假設正在打電話
            callInProgress = false;   //將電話掛掉
            return "Hanged up";  //回傳給lb2顯示"已掛斷"
        }
        return "Not in a call";  //若沒有在通話中 回傳給lb2顯示"未在通話中"
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
