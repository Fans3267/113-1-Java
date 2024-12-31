import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
    public String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //get current date time with Date()
        Date date = new Date();

        return dateFormat.format(date);
    }
    public String getCurrentTime() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        //get current date time with Date()
        Date date = new Date();

        return dateFormat.format(date);
    }
}
