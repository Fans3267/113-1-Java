import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class WebBrowser {
    private JButton button1, button2, button3, button4;
    private JLabel lb2;
    private JTextField jTextField;
    private ArrayList<String> webList = new ArrayList<>();
    private int currentpage;


    public void run() {
        //Jframe設定
        JFrame frame = new JFrame("Web Browser");
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
        jTextField.addActionListener(e -> {
            jTextField.setText("");
        });
        //按鈕偵測+回傳數值
        button1.addActionListener(e -> {
            lb2.setText(newpage());
        });
        button2.addActionListener(e -> {
            lb2.setText(nextpage());
        });
        button3.addActionListener(e -> {
            lb2.setText(rmpage());
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
        button1 = new JButton("New Page");
        button2 = new JButton("Next Page");
        button3 = new JButton("Remove Page");
        button4 = new JButton("Exit");

        // Set button sizes
        Dimension buttonSize = new Dimension(200, 100);
        button1.setPreferredSize(buttonSize);
        button2.setPreferredSize(buttonSize);
        button3.setPreferredSize(buttonSize);
        button4.setPreferredSize(buttonSize);
    }

    public String newpage() {
        if(jTextField.getText().isEmpty()){
            return "Please Enter URL";
        }
        String url = jTextField.getText();
        for (String e : webList) {
            if (e.equals(jTextField.getText())) {
                currentpage=webList.indexOf(url);
                int index = webList.indexOf(url)+1;
                return "Viewing: "+index+". "+url;
            }
        }
        webList.add(url);
        currentpage=webList.indexOf(url);
        int index = webList.indexOf(url)+1;
        return "Viewing: "+index+". "+url;
    }
    public String nextpage() {
        if(webList.isEmpty()){
            return "No Page to Show!";
        }
        currentpage++;
        if(currentpage>=webList.size())currentpage=0;
        int index=webList.indexOf(webList.get(currentpage))+1;
        return "Viewing: "+index+". "+webList.get(currentpage);
    }
    public String rmpage() {
        if(webList.isEmpty()) return "No Page to Delete!";
        String url = webList.get(currentpage);
        webList.remove(currentpage);
        return url+" Removed!";
    }
}



/*
import java.util.ArrayList;
import java.util.Scanner;

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
}*/
