import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AgendaApp {
    private JButton button1, button2, button3, button4;
    private JLabel lb2,lb1;
    private JTextField jTextField;
    private JList jList;
    private JComboBox jComboBox;
    private ArrayList<String> meetList = new ArrayList<>();
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private int slec;

    public void run() {
        //Jframe設定
        JFrame frame = new JFrame("Meetings");
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
            lb2.setText(newmeeting());
        });
        button2.addActionListener(e -> {
            lb2.setText(listmeetings());
        });
        button3.addActionListener(e -> {
            lb2.setText(rmmeeting());
        });
        button4.addActionListener(e -> {
            frame.dispose();
            ValueReceiver receiver = new ValueReceiver();
            new Screen(receiver);
        });
        jComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                slec = jComboBox.getSelectedIndex();
                //System.out.println(slec);
            }
        });

        // Add buttons to the panel with constraints
        gbc.gridy = 0;
        panel.add(lb1 , gbc);
        gbc.gridy = 1;
        panel.add(jTextField , gbc);
        gbc.gridy = 2;
        panel.add(jList, gbc);
        gbc.gridy = 3;
        panel.add(jComboBox, gbc);
        gbc.gridy = 4;
        panel.add(lb2 , gbc);
        gbc.gridy = 5;
        panel.add(button1, gbc);
        gbc.gridy = 6;
        panel.add(button2, gbc);
        gbc.gridy = 7;
        panel.add(button3, gbc);
        gbc.gridy = 8;
        panel.add(button4, gbc);

        // Add the panel to the frame
        frame.add(panel);
        // Make the frame visible
        frame.setVisible(true);
    }

    //按鈕+label設定
    public void setButtonlabel(){
        //jlist
        jList = new JList<>(listModel);
        jList.setFont(new Font("Arial",Font.BOLD,20));
        jList.setVisible(false);

        //combobox
        jComboBox = new JComboBox();
        jComboBox.setVisible(false);

        //label
        Dimension labelsize = new Dimension(300, 15);
        lb1 = new JLabel("Input Meeting Name:",JLabel.CENTER);
        lb1.setPreferredSize(labelsize);
        lb1.setFont(new Font("Serif", Font.PLAIN, 15));
        labelsize = new Dimension(300, 100);
        lb2 = new JLabel(" ",JLabel.CENTER);
        lb2.setPreferredSize(labelsize);
        lb2.setFont(new Font("Serif", Font.PLAIN, 27));

        // Initialize buttons as class-level variables
        jTextField = new JTextField(15);
        button1 = new JButton("Schedule Meeting");
        button2 = new JButton("Search Meeting");
        button3 = new JButton("Cancel Meeting");
        button4 = new JButton("Exit");

        // Set button sizes
        Dimension buttonSize = new Dimension(200, 60);
        button1.setPreferredSize(buttonSize);
        button2.setPreferredSize(buttonSize);
        button3.setPreferredSize(buttonSize);
        button4.setPreferredSize(buttonSize);
    }
    public String newmeeting() {
        jComboBox.setVisible(false);
        jList.setVisible(false);
        if(jTextField.getText().isEmpty()){
            return "Enter Meeting Name!";
        }
        meetList.add(jTextField.getText());
        return "Successfully Added!";
    }
    public String listmeetings() {
        jComboBox.setVisible(false);
        if(meetList.isEmpty()) return "No meetings";
        else {
            listModel.removeAllElements();
            for (String item : meetList) {
                listModel.addElement(item);
            }
        }
        jList.setVisible(true);
        return "";
    }
    public String rmmeeting() {
        if(meetList.isEmpty()) return "Nothing to remove!";
        jList.setVisible(false);
        updatecombo();
        if(!jComboBox.isVisible()){
            jComboBox.setVisible(true);
            return "Please Select";
        }
        jComboBox.removeItem(slec);
        meetList.remove(slec);
        updatecombo();
        return "Remove Successfully!";
    }
    public void updatecombo(){
        jComboBox.removeAllItems();
        for (String item : meetList) {
            jComboBox.addItem(item);
        }
    }
}
/*
import java.util.ArrayList;
import java.util.Scanner;

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
}*/
