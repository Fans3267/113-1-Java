import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeDate {
    //建立兩個方法
    //一個獲取系統當下日期(年-月-日)
    public String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        //回傳給Screen的Label
        return dateFormat.format(date);
    }
    //一個獲取系統當下時間(時-分)
    public String getCurrentTime() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        //回傳給Screen的Label
        return dateFormat.format(date);
    }
}
