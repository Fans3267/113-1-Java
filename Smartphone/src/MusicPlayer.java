import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class MusicPlayer {
    private JButton button1, button2, button3, button4, button5;
    private JLabel lb2;
    private ArrayList<String> musicList = new ArrayList<>();
    private boolean playing;
    private String currentSong ="";

    public void run() {
        JFrame frame = new JFrame("Music Player");
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
        setMusicList();
        //按鈕偵測+回傳數值
        button1.addActionListener(e -> {
            lb2.setText(play());
        });
        button2.addActionListener(e -> {
            lb2.setText(pause());
        });
        button3.addActionListener(e -> {
            lb2.setText(nextMusic());
        });
        button4.addActionListener(e -> {
            lb2.setText(previousMusic());
        });
        button5.addActionListener(e -> {
            frame.dispose();
            ValueReceiver receiver = new ValueReceiver();
            new Screen(receiver);
        });

        // Add buttons to the panel with constraints
        gbc.gridy = 0;
        panel.add(lb2, gbc);
        gbc.gridy = 1;
        panel.add(button1, gbc);
        gbc.gridy = 2;
        panel.add(button2, gbc);
        gbc.gridy = 3;
        panel.add(button3, gbc);
        gbc.gridy = 4;
        panel.add(button4, gbc);
        gbc.gridy = 5;
        panel.add(button5, gbc);

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
        button1 = new JButton("Play");
        button2 = new JButton("Pause");
        button3 = new JButton("Next Music");
        button4 = new JButton("Previous Music");
        button5 = new JButton("Exit Music Player");

        // Set button sizes
        Dimension buttonSize = new Dimension(200, 100);
        button1.setPreferredSize(buttonSize);
        button2.setPreferredSize(buttonSize);
        button3.setPreferredSize(buttonSize);
        button4.setPreferredSize(buttonSize);
        button5.setPreferredSize(buttonSize);
    }
    //音樂清單設定
    public void setMusicList(){
        musicList.add("1. bubble tea");
        musicList.add("2. NIGHT DANCER");
        musicList.add("3. September");
        musicList.add("4. golden hour");
        musicList.add("5. Wake (Studio)");
    }

    public String play() {
        if (!playing && currentSong == "") {
            playing = true;
            //selecting a music by random music player
            Random random = new Random();
            int randomIndex = random.nextInt(musicList.size());
            currentSong = musicList.get(randomIndex);
        }
        return currentSong;
    }
    public String pause() {
        if (playing) {
            playing = false;
        }
        return "Paused";
    }
    public String previousMusic() {
        int index = musicList.indexOf(currentSong);
        if (index <= 0) {
            currentSong = musicList.getLast();
        } else currentSong = musicList.get(index - 1);
        return currentSong;
    }
    public String nextMusic() {
        int index = musicList.indexOf(currentSong);
        if (index >= (musicList.size()-1)) {
            currentSong = musicList.getFirst();
        } else currentSong = musicList.get(index + 1);
        return currentSong;
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