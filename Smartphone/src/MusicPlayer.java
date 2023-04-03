
import java.util.ArrayList;
import java.util.Scanner;

public class MusicPlayer {
    private ArrayList<String> musicList;
    private boolean playing;
    private String currentSong;
    private Scanner scanner;

    public MusicPlayer() {
        musicList = new ArrayList<>();
        musicList.add("Song 1");
        musicList.add("Song 2");
        musicList.add("Song 3");
        playing = false;
        currentSong = "";
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("Select an option: ");
            System.out.println("1. Play");
            System.out.println("2. Pause");
            System.out.println("3. Select music from list");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();

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
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }

    public void play() {
        if (!playing && !currentSong.equals("")) {
            playing = true;
            System.out.println("Playing " + currentSong);
        } else {
            System.out.println("No song selected or song is already playing!");
        }
    }

    public void pause() {
        if (playing) {
            playing = false;
            System.out.println("Pausing " + currentSong);
        } else {
            System.out.println("No song playing!");
        }
    }

    public void selectMusic() {
        System.out.println("Select a song from the list: ");

        for (int i = 0; i < musicList.size(); i++) {
            System.out.println((i + 1) + ". " + musicList.get(i));
        }

        int choice = scanner.nextInt();

        if (choice < 1 || choice > musicList.size()) {
            System.out.println("Invalid choice!");
        }
    }

}