import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class MusicPlayer {
    // 宣告主要按鈕和標籤
    private JButton button1, button2, button3, button4, button5; // 五個按鈕
    private JLabel lb2; // 用於顯示播放狀態的標籤
    private ArrayList<String> musicList = new ArrayList<>(); // 儲存音樂清單
    private boolean playing; // 播放狀態
    private String currentSong =""; // 當前播放的音樂名稱

    public void run() {
        // 設定 JFrame 視窗
        JFrame frame = new JFrame("Music Player");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 關閉視窗時結束程式
        frame.setSize(450, 800); // 設定視窗大小

        // 建立 JPanel 並設定佈局
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout()); // 使用 GridBagLayout 進行佈局
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0); // 設定元件之間的垂直間距
        gbc.gridx = 0; // 將元件置中
        gbc.fill = GridBagConstraints.NONE; // 不拉伸元件

        // 初始化按鈕和標籤
        setButtonlabel();
        setMusicList();

        // 設定按鈕的事件監聽器
        // 播放按鈕的動作
        button1.addActionListener(e -> {
            lb2.setText(play());
        });
        // 暫停按鈕的動作
        button2.addActionListener(e -> {
            lb2.setText(pause());
        });
        // 下一首按鈕的動作
        button3.addActionListener(e -> {
            lb2.setText(nextMusic());
        });
        // 上一首按鈕的動作
        button4.addActionListener(e -> {
            lb2.setText(previousMusic());
        });
        // 退出按鈕的動作
        button5.addActionListener(e -> {
            frame.dispose(); // 關閉視窗
            ValueReceiver receiver = new ValueReceiver();
            new Screen(receiver); // 開啟新的 Screen 視窗
        });

        // 將元件添加到 JPanel
        gbc.gridy = 0;
        panel.add(lb2, gbc); // 添加標籤
        gbc.gridy = 1;
        panel.add(button1, gbc); // 添加播放按鈕
        gbc.gridy = 2;
        panel.add(button2, gbc); // 添加暫停按鈕
        gbc.gridy = 3;
        panel.add(button3, gbc); // 添加下一首按鈕
        gbc.gridy = 4;
        panel.add(button4, gbc); // 添加上一首按鈕
        gbc.gridy = 5;
        panel.add(button5, gbc); // 添加退出按鈕

        // 將面板添加到 JFrame
        frame.add(panel);
        // 顯示視窗
        frame.setVisible(true);
    }

    // 初始化按鈕和標籤
    public void setButtonlabel(){
        // 設定標籤
        lb2 = new JLabel(" ",JLabel.CENTER); // 顯示播放狀態的標籤
        Dimension labelsize = new Dimension(300, 100);
        lb2.setPreferredSize(labelsize); // 設定標籤大小
        lb2.setFont(new Font("Serif", Font.PLAIN, 27)); // 設定字型

        // 初始化按鈕
        button1 = new JButton("Play"); // 播放按鈕
        button2 = new JButton("Pause"); // 暫停按鈕
        button3 = new JButton("Next Music"); // 下一首按鈕
        button4 = new JButton("Previous Music"); // 上一首按鈕
        button5 = new JButton("Exit Music Player"); // 退出按鈕

        // 設定按鈕大小
        Dimension buttonSize = new Dimension(200, 100);
        button1.setPreferredSize(buttonSize);
        button2.setPreferredSize(buttonSize);
        button3.setPreferredSize(buttonSize);
        button4.setPreferredSize(buttonSize);
        button5.setPreferredSize(buttonSize);
    }

    // 初始化音樂清單
    public void setMusicList(){
        musicList.add("1. bubble tea");
        musicList.add("2. NIGHT DANCER");
        musicList.add("3. September");
        musicList.add("4. golden hour");
        musicList.add("5. Wake (Studio)");
    }

    // 播放音樂
    public String play() {
        if (!playing && currentSong == "") { // 當未播放且沒有選擇音樂時
            playing = true; // 設定播放狀態
            Random random = new Random(); // 隨機播放音樂
            int randomIndex = random.nextInt(musicList.size());
            currentSong = musicList.get(randomIndex); // 設定當前播放的音樂
        }
        return currentSong; // 返回當前播放的音樂名稱
    }

    // 暫停音樂
    public String pause() {
        if (playing) { // 如果正在播放
            playing = false; // 設定為暫停狀態
        }
        return "Paused"; // 返回暫停訊息
    }

    // 播放上一首音樂
    public String previousMusic() {
        int index = musicList.indexOf(currentSong); // 找到當前音樂的索引
        if (index <= 0) { // 如果是第一首音樂
            currentSong = musicList.getLast(); // 播放最後一首音樂
        } else {
            currentSong = musicList.get(index - 1); // 播放前一首音樂
        }
        return currentSong; // 返回當前播放的音樂名稱
    }

    // 播放下一首音樂
    public String nextMusic() {
        int index = musicList.indexOf(currentSong); // 找到當前音樂的索引
        if (index >= (musicList.size() - 1)) { // 如果是最後一首音樂
            currentSong = musicList.getFirst(); // 播放第一首音樂
        } else {
            currentSong = musicList.get(index + 1); // 播放下一首音樂
        }
        return currentSong; // 返回當前播放的音樂名稱
    }
}

/*
public MusicPlayer {

    public MusicPlayer() {
        musicList = new ArrayList<>();

        //function to generate a music list:
        for (int i = 1; i < 5; i++) {
            musicList.add("Song " + i);
        }
        playing = false;
        currentSong = "";
    }

    public void run() {

            System.out.println("Select an option: ");
            System.out.println("1. Play");
            System.out.println("2. Pause");
            System.out.println("3. Select music from list");
            System.out.println("4. Next music on Playlist");
            System.out.println("0. Exit Music Player...");

            int choice =1;
            switch (choice) {
                case 0:
                    System.out.println("Exiting MusicPlayer...");
                    return;
                case 1:
                    play();
                    break;
                case 2:
                    pause();
                    break;
                case 3:
                    selectMusic();
                    break;
                case 4:
                    nextMusic();
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }

    }


}*/