package sv.com.orderapp.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Mohan on 5/26/2016.
 */
public class FormatUtil {

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,##0.00");

    public static Date parseDate(String date) {
        try {
            if (date == null) {
                return null;
            }

            return DATE_FORMAT.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String formatDate(Date date) {
        if (date == null) {
            return null;
        }

        return DATE_FORMAT.format(date);
    }


    public static Double parseDouble(String number) {
        try {
            return DECIMAL_FORMAT.parse(number).doubleValue();
        } catch (ParseException e) {
            return null;
        }
    }

    public static String formatDouble(Double date) {
        return DECIMAL_FORMAT.format(date);
    }


}
