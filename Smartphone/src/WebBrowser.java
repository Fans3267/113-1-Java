import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class WebBrowser {
    // 宣告按鈕、標籤和文字框
    private JButton button1, button2, button3, button4; // 四個按鈕
    private JLabel lb2, lb1; // 用於顯示 URL 和頁面狀態的標籤
    private JTextField jTextField; // 用於輸入 URL 的文字框
    private ArrayList<String> webList = new ArrayList<>(); // 儲存瀏覽的網頁列表
    private int currentpage; // 當前顯示的頁面索引

    // 執行 Web Browser 應用程式
    public void run() {
        // JFrame 設定
        JFrame frame = new JFrame("Web Browser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 設定視窗關閉行為
        frame.setSize(450, 800); // 設定視窗大小

        // 創建並設定 JPanel
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout()); // 使用 GridBagLayout 進行佈局
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0); // 設定元件之間的垂直間距
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.NONE; // 不拉伸元件

        // 呼叫方法設定按鈕和標籤
        setButtonlabel();

        // 按鈕偵測與回傳功能
        // 按鈕 1：新增新頁面
        button1.addActionListener(e -> {
            lb2.setText(newpage());
        });
        // 按鈕 2：切換到下一個頁面
        button2.addActionListener(e -> {
            lb2.setText(nextpage());
        });
        // 按鈕 3：移除當前頁面
        button3.addActionListener(e -> {
            lb2.setText(rmpage());
        });
        // 按鈕 4：退出應用程式
        button4.addActionListener(e -> {
            frame.dispose(); // 關閉當前視窗
            ValueReceiver receiver = new ValueReceiver();
            new Screen(receiver); // 開啟新的 Screen 視窗
        });

        // 將元件新增到 JPanel
        gbc.gridy = 0;
        panel.add(lb1, gbc); // 添加 URL 提示標籤
        gbc.gridy = 1;
        panel.add(jTextField, gbc); // 添加文字框
        gbc.gridy = 2;
        panel.add(lb2, gbc); // 添加結果顯示標籤
        gbc.gridy = 3;
        panel.add(button1, gbc); // 添加按鈕 1
        gbc.gridy = 4;
        panel.add(button2, gbc); // 添加按鈕 2
        gbc.gridy = 5;
        panel.add(button3, gbc); // 添加按鈕 3
        gbc.gridy = 6;
        panel.add(button4, gbc); // 添加按鈕 4

        // 顯示 JFrame
        frame.add(panel);
        frame.setVisible(true);
    }

    // 初始化按鈕和標籤
    public void setButtonlabel() {
        // 初始化標籤
        Dimension labelsize = new Dimension(170, 15);
        lb1 = new JLabel("URL:", JLabel.LEFT); // URL 輸入提示標籤
        lb1.setPreferredSize(labelsize);
        lb1.setFont(new Font("Serif", Font.PLAIN, 15));
        labelsize = new Dimension(300, 100);
        lb2 = new JLabel(" ", JLabel.CENTER); // 顯示結果的標籤
        lb2.setPreferredSize(labelsize);
        lb2.setFont(new Font("Serif", Font.PLAIN, 27));

        // 初始化按鈕
        jTextField = new JTextField(15); // URL 輸入框
        button1 = new JButton("New Page"); // 新增頁面按鈕
        button2 = new JButton("Next Page"); // 下一頁按鈕
        button3 = new JButton("Remove Page"); // 移除頁面按鈕
        button4 = new JButton("Exit"); // 退出按鈕

        // 設定按鈕大小
        Dimension buttonSize = new Dimension(200, 100);
        button1.setPreferredSize(buttonSize);
        button2.setPreferredSize(buttonSize);
        button3.setPreferredSize(buttonSize);
        button4.setPreferredSize(buttonSize);
    }

    // 新增新頁面
    public String newpage() {
        if (jTextField.getText().isEmpty()) { // 如果未輸入 URL
            return "Please Enter URL"; // 提示輸入 URL
        }
        String url = jTextField.getText(); // 取得輸入的 URL
        for (String e : webList) {
            if (e.equals(jTextField.getText())) { // 如果 URL 已存在
                currentpage = webList.indexOf(url); // 設定當前頁面索引
                int index = webList.indexOf(url) + 1; // 計算頁面編號
                return "Viewing: " + index + ". " + url; // 返回當前瀏覽頁面
            }
        }
        webList.add(url); // 新增 URL 到列表
        currentpage = webList.indexOf(url); // 更新當前頁面索引
        int index = webList.indexOf(url) + 1; // 計算頁面編號
        return "Viewing: " + index + ". " + url; // 返回當前瀏覽頁面
    }

    // 切換到下一個頁面
    public String nextpage() {
        if (webList.isEmpty()) { // 如果列表為空
            return "No Page to Show!"; // 提示無頁面可顯示
        }
        currentpage++; // 切換到下一頁
        if (currentpage >= webList.size()) currentpage = 0; // 若超過範圍，回到第一頁
        int index = webList.indexOf(webList.get(currentpage)) + 1; // 計算頁面編號
        return "Viewing: " + index + ". " + webList.get(currentpage); // 返回當前頁面
    }

    // 移除當前頁面
    public String rmpage() {
        if (webList.isEmpty()) return "No Page to Delete!"; // 如果列表為空，提示無頁面可刪除
        String url = webList.get(currentpage); // 取得當前頁面的 URL
        webList.remove(currentpage); // 從列表中移除頁面
        return url + " Removed!"; // 返回移除結果
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
