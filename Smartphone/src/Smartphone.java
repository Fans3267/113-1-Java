import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Smartphone {
    //宣告所有程式所在的class
    private MusicPlayer musicPlayer;
    private PhoneCall phoneCall;
    private WebBrowser webBrowser;
    private AgendaApp agendaApp;
    public Smartphone() {
        musicPlayer = new MusicPlayer();
        phoneCall = new PhoneCall();
        webBrowser = new WebBrowser();
        agendaApp = new AgendaApp();
    }
    //將Smartphone所傳入的數值(也就是按鈕按下的數值) 判斷該執行哪個APP的run funtion
    public void run(int value) {
            switch (value) {
                case 0:
                    //System.out.println("Goodbye!");
                    return;
                case 1:
                    //開起Music Player
                    musicPlayer.run();
                    break;
                case 2:
                    //開啟Phone Call
                    phoneCall.run();
                    break;
                case 3:
                    //開啟Meeting App
                    agendaApp.run();
                    break;
                case 4:
                    //開啟Web Browser
                    webBrowser.run();
                    break;
            }
    }
}