import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Smartphone {

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

    public void run(int value) {
            switch (value) {
                case 0
                    //System.out.println("Goodbye!");
                    return;
                case 1:
                    musicPlayer.run();
                    break;
                case 2:
                    phoneCall.run();
                    break;
                case 3:
                    agendaApp.run();
                    break;
                case 4:
                    webBrowser.run();
                    break;
            }
    }
}