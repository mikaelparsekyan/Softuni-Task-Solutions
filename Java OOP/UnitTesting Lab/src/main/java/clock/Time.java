package clock;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class Time {
    private Date date;

    public Time(Date date) {
        this.date = date;
    }

    public boolean checkIfIsMorning() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if (hour == 8) {//8.00AM ring
            return true;
        }
        return false;
    }

}
