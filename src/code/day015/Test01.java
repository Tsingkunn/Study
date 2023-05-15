package code.day015;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test01 {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(date));

        String str = "2022-88-11";
        sdf.setLenient(false);
        System.out.println(sdf.format(sdf.parse(str)));
    }
}
