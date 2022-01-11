package class07;

import sun.java2d.pipe.SpanShapeRenderer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class calTest {
    public static void main(String[] args) throws ParseException {
        int outworkState;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        calendar.setTime(simpleDateFormat.parse("2020-06-09"));
        calendar.add(Calendar.DAY_OF_MONTH, 180);
        if (calendar.getTime().after(new Date())) {
            outworkState = 2;
        } else {
            outworkState = 1;
        }
        System.out.println(outworkState);
    }

}
