import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AgendaApp {
    // 宣告主要元件，包括按鈕、標籤、文字框、列表等
    private JButton button1, button2, button3, button4; // 四個按鈕
    private JLabel lb2, lb1; // 用於顯示訊息和提示的標籤
    private JTextField jTextField; // 用於輸入會議名稱的文字框
    private JList jList; // 顯示會議列表
    private JComboBox jComboBox; // 下拉選單，用於選擇會議
    private ArrayList<String> meetList = new ArrayList<>(); // 儲存會議名稱的清單
    private DefaultListModel<String> listModel = new DefaultListModel<>(); // JList 的模型
    private int slec; // 用於記錄選擇的會議索引

    public void run() {
        // 建立 JFrame 並進行基本設定
        JFrame frame = new JFrame("Meetings");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 關閉視窗時結束程式
        frame.setSize(450, 800); // 設定視窗大小

        // 建立一個面板來放置按鈕和其他元件
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout()); // 使用 GridBagLayout 進行佈局
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0); // 設定元件之間的垂直間距
        gbc.gridx = 0; // 將元件置中
        gbc.fill = GridBagConstraints.NONE; // 不拉伸元件

        // 初始化按鈕和標籤
        setButtonlabel();
        jTextField.addActionListener(e -> {
            jTextField.setText(""); // 清空文字框內容
        });

        // 設定按鈕的事件監聽器
        // 按鈕 1：安排新會議
        button1.addActionListener(e -> {
            lb2.setText(newmeeting()); // 顯示操作結果
        });
        // 按鈕 2：列出所有會議
        button2.addActionListener(e -> {
            lb2.setText(listmeetings());
        });
        // 按鈕 3：移除會議
        button3.addActionListener(e -> {
            lb2.setText(rmmeeting());
        });
        // 按鈕 4：退出程式並開啟新視窗
        button4.addActionListener(e -> {
            frame.dispose(); // 關閉當前視窗
            ValueReceiver receiver = new ValueReceiver();
            new Screen(receiver); // 開啟新的視窗
        });

        // 設定下拉選單的事件
        jComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                slec = jComboBox.getSelectedIndex(); // 紀錄選中的索引
                // System.out.println(slec); // 除錯用
            }
        });

        // 將元件添加到面板，按照垂直順序排列
        gbc.gridy = 0;
        panel.add(lb1, gbc); // 添加提示標籤
        gbc.gridy = 1;
        panel.add(jTextField, gbc); // 添加文字框
        gbc.gridy = 2;
        panel.add(jList, gbc); // 添加列表
        gbc.gridy = 3;
        panel.add(jComboBox, gbc); // 添加下拉選單
        gbc.gridy = 4;
        panel.add(lb2, gbc); // 添加結果標籤
        gbc.gridy = 5;
        panel.add(button1, gbc); // 添加按鈕 1
        gbc.gridy = 6;
        panel.add(button2, gbc); // 添加按鈕 2
        gbc.gridy = 7;
        panel.add(button3, gbc); // 添加按鈕 3
        gbc.gridy = 8;
        panel.add(button4, gbc); // 添加按鈕 4

        // 將面板添加到視窗並顯示
        frame.add(panel);
        frame.setVisible(true);
    }

    // 初始化按鈕和標籤
    public void setButtonlabel() {
        // 初始化會議列表（JList）
        jList = new JList<>(listModel);
        jList.setFont(new Font("Serif", Font.BOLD, 20)); // 設定字型
        jList.setVisible(false); // 初始為隱藏

        // 初始化下拉選單（JComboBox）
        jComboBox = new JComboBox();
        jComboBox.setVisible(false); // 初始為隱藏

        // 初始化標籤
        Dimension labelsize = new Dimension(300, 15);
        lb1 = new JLabel("Input Meeting Name:", JLabel.CENTER); // 輸入提示
        lb1.setPreferredSize(labelsize);
        lb1.setFont(new Font("Serif", Font.PLAIN, 15));
        labelsize = new Dimension(300, 100);
        lb2 = new JLabel(" ", JLabel.CENTER); // 結果顯示
        lb2.setPreferredSize(labelsize);
        lb2.setFont(new Font("Serif", Font.PLAIN, 27));

        // 初始化按鈕
        jTextField = new JTextField(15); // 文字框
        button1 = new JButton("Schedule Meeting"); // 安排會議按鈕
        button2 = new JButton("Search Meeting"); // 搜尋會議按鈕
        button3 = new JButton("Cancel Meeting"); // 取消會議按鈕
        button4 = new JButton("Exit"); // 退出按鈕

        // 設定按鈕大小
        Dimension buttonSize = new Dimension(200, 60);
        button1.setPreferredSize(buttonSize);
        button2.setPreferredSize(buttonSize);
        button3.setPreferredSize(buttonSize);
        button4.setPreferredSize(buttonSize);
    }

    // 新增會議
    public String newmeeting() {
        jComboBox.setVisible(false); // 隱藏下拉選單
        jList.setVisible(false); // 隱藏列表
        if (jTextField.getText().isEmpty()) {
            return "Enter Meeting Name!"; // 提示輸入會議名稱
        }
        meetList.add(jTextField.getText()); // 添加會議名稱到清單
        return "Successfully Added!"; // 返回成功訊息
    }

    // 列出所有會議
    public String listmeetings() {
        jComboBox.setVisible(false); // 隱藏下拉選單
        if (meetList.isEmpty()) return "No meetings"; // 如果清單為空，提示無會議
        listModel.removeAllElements(); // 清空列表模型
        for (String item : meetList) {
            listModel.addElement(item); // 添加會議到列表
        }
        jList.setVisible(true); // 顯示列表
        return "";
    }
    //刪除指定會議
    public String rmmeeting() {
        if(meetList.isEmpty()) return "Nothing to remove!"; //如果無會議 提示無會議可刪除
        jList.setVisible(false);  //隱藏列表
        updatecombo(); // 更新下拉選單
        if(!jComboBox.isVisible()){
            jComboBox.setVisible(true);  // 顯示下拉選單
            return "Please Select"; // 提示選擇會議
        }
        jComboBox.removeItem(slec); // 移除選中的項目
        meetList.remove(slec); // 從清單中刪除
        updatecombo(); // 更新下拉選單
        return "Remove Successfully!";// 返回成功訊息
    }

    // 更新下拉選單內容
    public void updatecombo() {
        jComboBox.removeAllItems(); // 清空下拉選單
        for (String item : meetList) {
            jComboBox.addItem(item); // 將會議名稱添加到下拉選單
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
