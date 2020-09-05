package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @program: SimpleDateFormatTest
 * @description:
 * @author: wangf-q
 * @date: 2020-01-16 11:20
 **/
public class SimpleDateFormatTest {

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        for (int i = 0; i < 10; ++i){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(sdf.parse("2020-01-16 11:22:50"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
    }
}
